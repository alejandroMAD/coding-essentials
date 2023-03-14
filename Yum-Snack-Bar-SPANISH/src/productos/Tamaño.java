package productos;

/**
 * El tipo enumerado {@code Tamaño} representa el tamaño de determinados productos.
 * Define tres constantes que representan las medidas MEDIANO, GRANDE y GIGANTE.
 * Cada una de las constantes tiene una abreviatura asociada, derivada de las
 * denominaciones en inglés que permite mostrar el Tamaño de una manera concisa.
 * 
 * @author Alejandro M. González
 */
public enum Tamaño {
	MEDIANO("M"), GRANDE("L"), GIGANTE("XL");

	private final String abreviatura;

	/**
	 * Constructor del tipo enumerado Tamaño.
	 * @param abreviatura la abreviatura asociada a este tamaño
	 */
	Tamaño(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	/**
	 * Obtiene la abreviatura asociada a este tamaño.
	 * @return la abreviatura asociada a este tamaño.
	 */
	public String getAbreviatura() {
		return this.abreviatura;
	}
}
