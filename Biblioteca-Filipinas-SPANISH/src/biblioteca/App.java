package biblioteca;

/**
 * Entry-point de la aplicación de gestión de préstamos de la biblioteca.
 * En el método main() se instancia un objeto GestorPrestamos, cuyo
 * método constructor administra la lógica relacionada con la gestión
 * de préstamos y devoluciones de libros por lectores registrados en la
 * base de datos para los fines de este programa.
 * 
 * @author Alejandro M. González
 *
 */
public class App {

	public static void main(String[] args) {
		
		new GestorPrestamos();

	}
}
