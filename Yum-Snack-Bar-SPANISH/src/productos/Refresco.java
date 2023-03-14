package productos;

/**
 * Refresco, subtipo de Producto, representa un vaso de bebidas carbonatadas.
 * La clase incluye campos estáticos con el nombre y precios por tamaño y atributos
 * que definen el Tamaño, el Sabor y el precio del producto instanciado, que varía
 * en función del tamaño elegido. La clase incorpora getters y setters para recuperar
 * el valor de los campos encapsulados del tamaño, sabor y precio.
 * 
 * Refresco hereda de la clase Producto la estructura básica de un producto a la venta.
 * Los tamaños disponibles de Refresco vienen definidos por el enum Tamaño.
 * Los sabores disponibles de Refresco están definidos por el enum interno Sabor.
 * 
 * @author Alejandro M. González
 */
public class Refresco extends Producto {

	public enum Sabor {
		COLA, COLA_LIGHT, NARANJA, LIMON
	}

	private final static String NOMBRE = "Vaso de refresco";
	private final static double PRECIO_MEDIANO = 4.5;
	private final static double PRECIO_GRANDE = 6.0;
	private final static double PRECIO_GIGANTE = 7.5;
	private Tamaño tamaño;
	private Sabor sabor;
	private double precio = PRECIO_MEDIANO;

	/**
	 * Construye un objeto Refresco con el tamaño y sabor especificados
	 * y establece su precio de acuerdo con los campos estáticos correspondientes.
	 * @param tamaño el tamaño del Refresco (MEDIANO, GRANDE o GIGANTE)
	 * @param sabor  el sabor del Refresco (COLA, COLA_LIGHT, NARANJA o LIMON)
	 */
	public Refresco(Tamaño tamaño, Sabor sabor) {
		super(PRECIO_MEDIANO, NOMBRE);
		this.tamaño = tamaño;
		this.sabor = sabor;
		
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

	// Getters y setters
	public Tamaño getTamaño() {
		return tamaño;
	}

	public void setTamaño(Tamaño tamaño) {
		this.tamaño = tamaño;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public double getPrecio() {
		return precio;
	}

}
