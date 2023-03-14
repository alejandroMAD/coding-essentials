package productos;

/**
 * Una clase que representa un producto de tipo Menu, que incluye un objeto Refresco
 * y un objeto Palomitas a precio reducido. El precio del Menu varía en función del
 * Tamaño de sus componentes. La clase incluye campos estáticos con el nombre y precios
 * por tamaño y atributos que encapsulan los subproductos de los cuales se compone
 * el menú, además del precio del objeto Menu. El precio varía en función del tamaño.
 * 
 * Una excepción específica previene la creación de objetos de tipo Menu compuestos de
 * objetos Refresco y Palomitas de Tamaño diferente, de acuerdo con las reglas del negocio.
 * 
 * @author Alejandro M. González
 */
public class Menu extends Producto {

	private Refresco refresco;
	private Palomitas palomitas;
	private final static String NOMBRE = "Refresco + Palomitas a precio reducido";
	private final static double PRECIO_MEDIANO = 7.95;
	private final static double PRECIO_GRANDE = 8.95;
	private final static double PRECIO_GIGANTE = 9.95;
	private double precioMenu;

	/**
	 * Construye un objeto Menu con los objetos Refresco y Palomitas especificados.
	 * El precio del Menu es fijado de acuerdo con el tamaño de sus componentes.
	 * Si el tamaño de estos no coincide, se arroja una excepción TamañoIlegalException.
	 * @param refresco               El objeto Refresco incluido en el Menu
	 * @param palomitas              El objeto Palomitas incluido en el Menu
	 * @throws TamañoIlegalException si los tamaños del Refresco y Palomitas componentes no coinciden
	 */
	public Menu(Refresco refresco, Palomitas palomitas) throws TamañoIlegalException {
		super(PRECIO_MEDIANO, NOMBRE);
		if (refresco.getTamaño() != palomitas.getTamaño()) {
			throw new TamañoIlegalException("El Refresco y Palomitas deben ser del mismo tamaño.");
		}
		this.refresco = refresco;
		this.palomitas = palomitas;
		
		if (this.refresco.getTamaño().equals(Tamaño.GRANDE)) {
			this.precioMenu = PRECIO_GRANDE;
		} else if (this.refresco.getTamaño().equals(Tamaño.GIGANTE)) {
			this.precioMenu = PRECIO_GIGANTE;
		}
		super.setPrecio(precioMenu);			
	}

	@Override
	public String toString() {
		return "Menú: Refresco+Palomitas '" + refresco.getTamaño()
				+ "' - precio=" + super.getPrecio();
	}

	public Refresco getRefresco() {
		return refresco;
	}

	public Palomitas getPalomitas() {
		return palomitas;
	}

	public double getPrecioMenu() {
		return precioMenu;
	}
	
}

