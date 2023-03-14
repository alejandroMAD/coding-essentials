package productos;

/**
 * Chocolatina, subtipo de Producto, representa una chocolatina vendida
 * unitariamente. Hereda de la clase Producto su estructura básica
 * y fija el nombre y precio mediante constantes.
 * 
 * @author Alejandro M. González
 */
public class Chocolatina extends Producto {
	
	private final static String NOMBRE = "Chocolatina individual";
	private final static double PRECIO = 2.0;

	/**
	 * Construye un producto Chocolatina con el nombre y precio especificados
	 * por las constantes.
	 */
	public Chocolatina() {
		super(PRECIO, NOMBRE);
	}
	
}
