package biblioteca;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import database.GestorLibroBD;
import database.GestorPrestamoBD;
import modelo.Lector;
import modelo.Libro;
import modelo.Prestamo;
import database.GestorBibliotecaBD;
import database.GestorLectorBD;

/**
 * Esta clase suministra la lógica de gestión de préstamos y devoluciones de libros
 * por lectores interactuando con los registros de la base de datos. GestorPrestamos
 * proporciona métodos para manejar los préstamos y devoluciones por el usuario,
 * teniendo en cuenta las reglas de la biblioteca que conciernen al número máximo de
 * préstamos simultáneos, el periodo máximo del préstamo de un libro y los días de
 * penalización o suspensión de privilegios de préstamo por retraso en una devolución.
 * 
 * Esta clase también administra el contador de préstamos actuales de un lector y
 * sus días de penalización, cuando corresponda. La interacción con el usuario del
 * sistema se realiza mediante el flujo de entrada por defecto en la consola.
 * 
 * @author Alejandro M. González
 */
public class GestorPrestamos {
	
    private static final Scanner scanner = new Scanner(System.in);
    private static int prestamosSimultaneos;
    private static int periodoPrestamo;
    private static int diasPenalización;

    /**
     * Constructor que inicializa el objeto GestorPrestamos y comprueba los valores
     * de máximos préstamos simultáneos, periodo máximo de un préstamo y días de
     * penalización por retraso en una devolución en la base de datos.
     * A continuación, inicia un bucle de lectura para gestionar la selección del
     * usuario de las opciones para registrar préstamos o devoluciones de libros.
     */
    public GestorPrestamos() {
    	prestamosSimultaneos = GestorBibliotecaBD.getPrestamosSimultaneos();
    	periodoPrestamo = GestorBibliotecaBD.getDiasPrestamo();
    	diasPenalización = GestorBibliotecaBD.getDiasPenalizacion();
    	
        while (true) {
        	System.out.println("+-----------------------------------------------------------------------+");
        	System.out.println("| ¿Realizar préstamo o devolución de un libro? (PRESTAR/DEVOLVER/SALIR) |");
        	System.out.println("+-----------------------------------------------------------------------+");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("salir")) {
                System.out.println("Abandonando la aplicación...");
                break;
            } else if (input.equals("prestar")) {
                registrarPrestamo();
            } else if (input.equals("devolver")) {
                registrarDevolucion();
            } else {
                System.err.println("Opción inválida, por favor inténtelo de nuevo.");
            }
        }
        scanner.close();
    }

    /**
     * Método gestor de préstamos de libros. Solicita al usuario introducir el ID del libro
     * y el ID del lector y comprueba si el libro está disponible para ser prestado, si el
     * lector no posee ya el máximo número de libros prestados y no tiene retrasos o penalizaciones.
     * Si se reúnen las condiciones, crea el registro de un préstamo en la base de datos,
     * actualiza la disponibilidad del libro como false e incrementa el contador de libros
     * prestados al lector especificado incrementándolo en 1.
     */
    private static void registrarPrestamo() {
        System.out.println("Introduzca el ID del libro: ");
        int libroId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduzca el ID del lector: ");
        int lectorId = scanner.nextInt();
        scanner.nextLine();
        
        Libro libro = GestorLibroBD.getLibroPorId(libroId);
        Lector lector = GestorLectorBD.getLectorPorId(lectorId);

        boolean disponible = GestorLibroBD.getDisponibilidadLibro(libroId);
        int contadorPrestamosLector = GestorLectorBD.getLibrosPrestados(lectorId);

        if (!disponible) {
            System.out.println(
            		"El libro '" + libro.getTitulo() + "' ya está prestado.");
        } else if (contadorPrestamosLector >= 3 ) {
        	System.out.println(
        			"El lector " + lector.getNombre() + " " + lector.getApellido() 
        			+ " ya posee el número máximo de libros prestados.");
        } else if (GestorLectorBD.getDiasPenalizacion(lectorId) > 0 || tieneRetraso(lectorId)) {
        	System.out.println(
        			"El lector " + lector.getNombre() + " " + lector.getApellido() 
        			+ " se ha retrasado en una devolución o tiene una penalización " 
					+ "y no puede tomar préstamos.");        	
        } else {
            Timestamp fechaPrestamo = new Timestamp(System.currentTimeMillis());
            boolean exitoOperacion = GestorPrestamoBD.crearPrestamo(libroId, lectorId, fechaPrestamo);

            if (exitoOperacion) {
                GestorLibroBD.setDisponibilidadLibro(libroId, false);
                GestorLectorBD.actualizarLibrosPrestados(lectorId, 1);
                System.out.println(
                		"El libro " + libro.getTitulo() + " se ha prestado correctamente a " 
        				+ lector.getNombre() + " " + lector.getApellido() 
                		+ " y se ha registrado como 'no disponible'.");
            } else {
                System.out.println("Error en la operación de préstamo del libro.");
            }
        }
    }

    /**
     * Método gestor de devoluciones de libros. Solicita al usuario introducir el ID del libro
     * y el ID del lector y comprueba que el libro especificado está actualmente en préstamo
     * al lector especificado, estableciendo la fecha de devolución del préstamo en la base de
     * datos, actualizando la disponibilidad del libro como true y disminuyendo el contador de
     * libros prestados al lector en 1 si el proceso culmina con éxito.
     * 
     * Este método comprueba asimismo si la devolución se está produciendo con retraso comparando
     * la diferencia entre la fecha y hora actual y la fecha del préstamo, y actualiza los valores
     * correspondiente de penalización por devolución tardía en las tablas `lector` y `prestamo`.
     */
    private static void registrarDevolucion() {
        System.out.print("Introduzca el ID del libro:");
        int libroId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduzca el ID del lector:");
        int lectorId = scanner.nextInt();
        scanner.nextLine();
        
        Libro libro = GestorLibroBD.getLibroPorId(libroId);
        Lector lector = GestorLectorBD.getLectorPorId(lectorId);

        boolean disponible = GestorLibroBD.getDisponibilidadLibro(libroId);
        int prestamoId = GestorPrestamoBD.getIdPrestamo(libroId, lectorId);
        Timestamp fechaDevolucion = GestorPrestamoBD.getFechaDevolucion(prestamoId);

        if (disponible) {
            System.out.println(
            		"El libro '" + libro.getTitulo() + "' no está actualmente prestado.");
        } else if (fechaDevolucion != null) {
        	System.out.println(
        			"El libro '" + libro.getTitulo() 
        			+ "' no está actualmente prestado al lector " 
					+ lector.getNombre() + " " + lector.getApellido());
        } else if (prestamoId == -1) {
        	System.out.println("No se ha encontrado un préstamo del libro y lector especificados.");
        } else {
            fechaDevolucion = new Timestamp(System.currentTimeMillis());
            boolean exitoOperacion = GestorPrestamoBD.setFechaDevolucion(prestamoId, fechaDevolucion);

            if (exitoOperacion) {
                GestorLibroBD.setDisponibilidadLibro(libroId, true);
                GestorLectorBD.actualizarLibrosPrestados(lectorId, -1);
                System.out.println(
                		"El libro '" + libro.getTitulo() + "' se ha devuelto correctamente " 
    					+ "y se ha registrado como 'disponible'.");
                
                Timestamp fechaPrestamo = GestorPrestamoBD.getFechaPrestamo(prestamoId);

                long diferenciaMilisegundos = Math.abs(fechaDevolucion.getTime() - fechaPrestamo.getTime());
                long diferencia = TimeUnit.DAYS.convert(diferenciaMilisegundos, TimeUnit.MILLISECONDS);

                if (diferencia > periodoPrestamo) {
                    int diasRetraso = (int) (diferencia - periodoPrestamo);
                    int penalizacion = diasRetraso * diasPenalización;
                    
                    GestorLectorBD.actualizarDiasPenalizacion(lectorId, penalizacion);
                    GestorPrestamoBD.setPenalizacionPrestamo(prestamoId, penalizacion);
                    System.out.println(
                    		"Aplicada una penalización por retraso en la devolución de: " 
            				+ penalizacion + " días.");
                }
            } else {
                System.out.println("Error en la operación de devolución del libro.");
            }
        }
    }
    
    /**
     * Comprueba si el lector tiene actualmente una situación de retraso en la
     * obligación de devolver un libro que posee en un préstamo vigente.
     * @param lectorId El ID del lector cuya situación se ha de comprobar.
     * @return true si el lector se ha retrasado en la devolución de un libro que tiene
     *         actualmente prestado y no devuelto, false en caso contrario.
     */
    public static boolean tieneRetraso(int lectorId) {
        List<Prestamo> prestamos = GestorPrestamoBD.getPrestamosPorIdLector(lectorId);
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion() == null) {
                Timestamp fechaDevolucion = prestamo.getFechaPrestamo();
                long diferencia = System.currentTimeMillis() - fechaDevolucion.getTime();
                long diasRetraso = (diferencia / (1000 * 60 * 60 * 24)) - periodoPrestamo;
                if (diasRetraso > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

