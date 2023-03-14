package productos;

/**
 * Palomitas, subtipo de Producto, representa un cartón de palomitas a la venta.
 * La clase incluye campos estáticos con el nombre y precios por tamaño y atributos
 * que definen el Tamaño y el precio del producto instanciado, que varía en función
 * del tamaño elegido. La clase incorpora getters y setters para recuperar el valor
 * de los campos encapsulados del tamaño y precio.
 * 
 * Palomitas hereda de la clase Producto la estructura básica de un producto a la venta.
 * Los tamaños disponibles de Palomitas vienen definidos por el enum Tamaño.
 * 
 * @author Alejandro M. González
 */
public class Palomitas extends Producto {
	
	private final static String NOMBRE = "Cartón de palomitas";
	private final static double PRECIO_MEDIANO = 5.0;
	private final static double PRECIO_GRANDE = 7.0;
	private final static double PRECIO_GIGANTE = 9.0;
	private Tamaño tamaño;
	private double precio = PRECIO_MEDIANO;

	/**
	 * Construye un objeto Palomitas con el tamaño especificado
	 * y establece su precio de acuerdo con los campos estáticos
	 * correspondientes.
	 * 
	 * @param tamaño el tamaño del producto Palomitas
	 */
	public Palomitas(Tamaño tamaño) {
		super(PRECIO_MEDIANO, NOMBRE);
		this.tamaño = tamaño;
		
		if (tamaño.equals(Tamaño.GRANDE)) {
			this.precio = PRECIO_GRANDE;
		} else if (tamaño.equals(Tamaño.GIGANTE)) {
			this.precio = PRECIO_GIGANTE;
		}
		super.setPrecio(precio);			
	}

	@Override
	public String toString() {
		return NOMBRE + " '" + tamaño + "' - precio=" + precio + "]";
	}

	// Getters and setters
	public Tamaño getTamaño() {
		return tamaño;
	}

	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño;
	}

	public double getPrecio() {
		return precio;
	}
}
