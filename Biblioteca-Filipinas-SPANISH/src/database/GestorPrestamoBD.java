package database;

import java.sql.*;
import java.util.*;

import modelo.Lector;
import modelo.Libro;
import modelo.Prestamo;

/**
 * La clase GestorPrestamoBD gestiona las interacciones con la tabla `prestamo` en la
 * base de datos. Proporciona métodos para crear, obtener, actualizar y borrar
 * registros de préstamos, que son mapeados a objetos Prestamo como en un framework ORM.
 * 
 * (El método de eliminación de registros de préstamo no se incluye en el código
 * por no ser necesario para la solución propuesta en el proyecto).
 * 
 * Esta clase utiliza una conexión a la base de datos MySQL para ejecutar sentencias
 * SQL sobre la tabla `prestamo`, que almacena información de cada préstamo, incluyendo
 * el lector prestatario, el libro prestado, la fecha de préstamo, la fecha de devolución
 * (si el libro ha sido devuelto) y la penalización que corresponda por devoluciones tardías.
 * 
 * Los métodos en esta clase utilizan una sintaxis try-with-resources para instanciar
 * un objeto Connection y ejecutar sentencias SQL en el bloque try, que permiten
 * cerrar automáticamente los recursos después de usarlos.
 * 
 * Para utilizar los métodos de esta clase, es necesario tener una base de datos MySQL
 * ejecutándose en un servidor que sea accesible desde la aplicación de Java. Asimismo es
 * necesario tener el driver adecuado instalado y disponible en el classpath del proyecto.
 * 
 * @author Alejandro M. González
 */

public class GestorPrestamoBD {

    /**
     * Obtiene una lista de todos los préstamos en la tabla `prestamo` de la base de datos.
     * @return una lista de objetos Prestamo con todos los préstamos en la base de datos.
     * @throws SQLException si hay un error en el acceso a la base de datos.
     */
    public static List<Prestamo> getPrestamos() throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT * FROM prestamo";
        
        try (Connection conexion = ConexionBD.getDBConnection();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setPrestamoId(resultSet.getInt("prestamo_id"));

                Libro libroPrestado = GestorLibroBD.getLibroPorId(resultSet.getInt("libro_id"));
                prestamo.setLibro(libroPrestado);
                Lector lectorPrestatario = GestorLectorBD.getLectorPorId(resultSet.getInt("lector_id"));
                prestamo.setLector(lectorPrestatario);
                
                prestamo.setFechaPrestamo(resultSet.getTimestamp("fecha_prestamo"));
                prestamo.setFechaDevolucion(resultSet.getTimestamp("fecha_devolucion"));
                prestamo.setDiasPenalizacion(resultSet.getInt("penalizacion"));
                prestamos.add(prestamo);
            }
        } 
        return prestamos;
    }

    /**
     * Obtiene todos los préstamos de un lector específico de la tabla `prestamo` en
     * la base de datos.
     * @param lectorId the id of the reader whose borrowings are to be retrieved.
     * @return a list of Borrowing objects representing the borrowings by the specified reader.
     * @throws SQLException if there is an error executing the SQL query.
     */
    public static List<Prestamo> getPrestamosPorIdLector(int lectorId) {
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT * FROM prestamo WHERE lector_id = ?";
        
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lectorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Prestamo prestamo = new Prestamo();
                    prestamo.setPrestamoId(resultSet.getInt("prestamo_id"));

                    Libro libroPrestado = GestorLibroBD.getLibroPorId(resultSet.getInt("libro_id"));
                    prestamo.setLibro(libroPrestado);
                    Lector lectorPrestatario = GestorLectorBD.getLectorPorId(resultSet.getInt("lector_id"));
                    prestamo.setLector(lectorPrestatario);

                    prestamo.setFechaPrestamo(resultSet.getTimestamp("fecha_prestamo"));
                    prestamo.setFechaDevolucion(resultSet.getTimestamp("fecha_devolucion"));
                    prestamo.setDiasPenalizacion(resultSet.getInt("penalizacion"));
                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return prestamos;
    }
 
    /**
     * Devuelve el ID del préstamo de un libro determinado a un lector determinado
     * en función de el ID especificado de uno y otro. Este método consulta la
     * base de datos y recupera el ID del préstamo más reciente que coincide con
     * los criterios de búsqueda por libro y lector, de modo que son descartados
     * posibles préstamos anteriores del mismo libro al mismo lector.
     * @param libroId  El ID del libro.
     * @param lectorId El ID del lector prestatario.
     * @return el ID del último préstamo del libro y lector cuyos ID se han
     *         especificado, o -1 si no se encuentra un préstamo que coincida.
     */
    public static int getIdPrestamo(int libroId, int lectorId) {
        String query = "SELECT prestamo_id FROM prestamo " 
        				+ "WHERE libro_id = ? AND lector_id = ? " 
        				+ "ORDER BY prestamo_id DESC LIMIT 1";
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, libroId);
            statement.setInt(2, lectorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("prestamo_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    /**
     * Crea un registro de un préstamo en la base de datos referido al libro y lector
     * especificados y en la fecha especificada.
     * @param libroId       El ID del libro prestado.
     * @param lectorId      El ID del lector prestatario.
     * @param fechaPrestamo La fecha del día y hora en que el lector toma prestado el libro.
     * @return true si el préstamo es registrado correctamente, false en caso contrario.
     */
    public static boolean crearPrestamo(int libroId, int lectorId, Timestamp fechaPrestamo) {
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(
                "INSERT INTO prestamo (libro_id, lector_id, fecha_prestamo) VALUES (?, ?, ?)")) {
            statement.setInt(1, libroId);
            statement.setInt(2, lectorId);
            statement.setTimestamp(3, fechaPrestamo);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene la fecha de préstamo del registro de un préstamo según su ID especificado.
     * @param prestamoId El ID del préstamo del que se consulta su fecha de préstamo.
     * @return la fecha del préstamo como un objeto Timestamp, 
     *         o null si no se encuentra el préstamo.
     */
    public static Timestamp getFechaPrestamo(int prestamoId) {
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(
                "SELECT fecha_prestamo FROM prestamo WHERE prestamo_id = ?")) {
            statement.setInt(1, prestamoId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getTimestamp("fecha_prestamo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza la fecha de préstamo del registro de préstamo según su ID especificado.
     * @param prestamoId the id of the borrowing record to update
     * @param fechaPrestamo the new borrowing date to set
     */
    public static void setFechaPrestamo(int prestamoId, Timestamp fechaPrestamo) {
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(
                "UPDATE prestamo SET fecha_prestamo = ? WHERE prestamo_id = ?")) {
            statement.setTimestamp(1, fechaPrestamo);
            statement.setInt(2, prestamoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene la fecha de devolución de un préstamo según su ID especificado.
     * @param prestamoId El ID del préstamo.
     * @return la fecha de devolución del préstamo, o null si no es posible obtenerla.
     */
    public static Timestamp getFechaDevolucion(int prestamoId) {
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(
                     "SELECT fecha_devolucion FROM prestamo WHERE prestamo_id = ?")) {
            statement.setInt(1, prestamoId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("fecha_devolucion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Establece la fecha de devolución de un préstamo en la base de datos
     * por el ID de préstamo especificado.
     * @param prestamoId      El ID del préstamo.
     * @param fechaDevolucion La fecha de devolución del préstamo.
     * @return true si la fecha de devolución se actualizó correctamente,
     *         false en caso contrario.
     */
    public static boolean setFechaDevolucion(int prestamoId, Timestamp fechaDevolucion) {
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(
                     "UPDATE prestamo SET fecha_devolucion = ? WHERE prestamo_id = ?")) {
            statement.setTimestamp(1, fechaDevolucion);
            statement.setInt(2, prestamoId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Establece los días de penalización asociados a un préstamo por el ID
     * de préstamo especificado. La penalización en días por retraso en la
     * devolución de libros depende de las reglas de la biblioteca.
     * @param prestamoId   El ID del préstamo.
     * @param penalizacion La penalización en días que se establece por la devolución
     *                     tardía de este préstamo de libro.
     */
    public static void setPenalizacionPrestamo(int prestamoId, int penalizacion) {
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(
                     "UPDATE prestamo SET penalizacion = ? WHERE prestamo_id = ?")) {
            statement.setInt(1, penalizacion);
            statement.setInt(2, prestamoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

