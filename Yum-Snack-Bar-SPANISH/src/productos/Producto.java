package productos;

/**
 * La clase Producto representa genéricamente un producto con un nombre y precio.
 * Proporciona métodos para obtener y modificar el precio y nombre del producto.
 * Su propósito es servir como superclase para que otras clases concretas de productos
 * puedan heredar su funcionalidad.
 * 
 * @author Alejandro M. González
 */
public abstract class Producto {
	
	private double precio;
	private final String nombre;

	/**
	 * Construye un nuevo objeto Producto con el precio y nombre especificados.
	 * @param precio el precio del producto
	 * @param nombre el nombre del product
	 */
	public Producto(double precio, String nombre) {
		this.precio = precio;
		this.nombre = nombre;
	}

	/**
	 * Devuelve un String con información del nombre y precio del producto.
	 * @return la representación como String del objeto Producto
	 */
	@Override
	public String toString() {
		return "Producto: '" + nombre + "' - precio=" + precio;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
