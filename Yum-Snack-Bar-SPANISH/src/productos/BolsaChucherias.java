package productos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * BolsaChucherias hereda de Producto e implementa la interfaz Pesable. Representa
 * el producto de una bolsa de chucherías. Esta clase define un nombre estático,
 * un precio estático por 100 mg de producto y variables con el peso y precio total
 * del objeto. Además contiene un método constructor que inicializa el peso y precio
 * además de un método para calcular el precio total basado en el peso del producto.
 * 
 * @author Alejandro M. González
 */
public class BolsaChucherias extends Producto implements Pesable {
	
	private final static String NOMBRE = "Bolsa de chucherías";
	private final static double PRECIO_POR_100_MG = 1.10;
	private double peso;
	private double precioTotal;

	/**
	 * Construye un nuevo objeto BolsaChucherias con el peso especificado.
	 * Prohíbe la construcción de objetos con peso inferior a 20 g arrojando
	 * una excepción.
	 * @param pesaje                    El peso del producto medido en gramos.
	 *                                  Debe ser 20 g o superior.
	 * @throws IllegalArgumentException si el peso es inferior a 20 g.
	 */
	public BolsaChucherias(double pesaje) {
		super(PRECIO_POR_100_MG, NOMBRE);
		
	    if (pesaje < 20) {
	        throw new IllegalArgumentException("El precio del objeto debe ser 20 g o superior");
	    }
		this.peso = pesaje;
	    this.precioTotal = calcularPrecio(pesaje);
	    
	    super.setPrecio(precioTotal);
	}

	/**
	 * Calcula el peso del objeto BolsaChucherias basado en su peso y da formato
	 * al valor resultante estableciendo un máximo de dos decimales.
	 * @param pesaje El peso del objeto BolsaChucherias medido en gramos
	 * @return El precio total del producto BolsaChucherias como valor double con dos decimales como máximo
	 */
	@Override
	public double calcularPrecio(double pesaje) {
	    double precio = peso * PRECIO_POR_100_MG / 100;
	    DecimalFormat df = new DecimalFormat(
	    		"#.##", new DecimalFormatSymbols(Locale.ENGLISH)
		);
	    return Double.parseDouble(df.format(precio));
	}

	// Getters
	public double getPeso() {
		return peso;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	
}



