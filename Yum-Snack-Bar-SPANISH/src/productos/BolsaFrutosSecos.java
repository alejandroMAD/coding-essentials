package productos;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * BolsaFrutosSecos hereda de Producto e implementa la interfaz Pesable.
 * Representa una bolsa de frutos secos vendidos al peso, cuyo precio
 * se calcula a partir del peso del objeto en gramos. La clase define
 * constantes estáticas para el nombre y precio por 100 mg del producto,
 * y variables para el peso y precio total del objeto.
 * 
 * @author Alejandro M. González
 */
public class BolsaFrutosSecos extends Producto implements Pesable {

	private final static String NOMBRE = "Bolsa de frutos secos";
	private final static double PRECIO_POR_100_MG = 1.80;
	private double peso;
	private double precioTotal;

	/**
	 * Construye un objeto BolsaFrutosSecos con el peso especificado.
	 * Prohíbe la construcción de objetos con peso inferior a 20 g arrojando
	 * una excepción.
	 * @param pesaje                    el peso del producto medido en gramos.
	 *                                  Debe ser 20 g o superior.
	 * @throws IllegalArgumentException si el peso es inferior a 20 g.
	 */
	public BolsaFrutosSecos(double pesaje) {
		super(PRECIO_POR_100_MG, NOMBRE);
		
	    if (pesaje < 20) {
	        throw new IllegalArgumentException("El precio del objeto debe ser 20 g o superior");
	    }
		this.peso = pesaje;
		this.precioTotal = calcularPrecio(pesaje);

		super.setPrecio(precioTotal);
	}

	/**
	 * Calcula el peso del objeto BolsaFrutosSecos basado en su peso y da formato
	 * al valor resultante estableciendo un máximo de dos decimales.
	 * @param pesaje El peso del objeto BolsaFrutosSecos medido en gramos
	 * @return El precio total del producto BolsaFrutosSecos como double con dos decimales como máximo
	 */
	@Override
	public double calcularPrecio(double pesaje) {
	    double precio = peso * PRECIO_POR_100_MG / 100;
	    DecimalFormat df = new DecimalFormat(
	    		"#.##", new DecimalFormatSymbols(Locale.ENGLISH)
		);
	    return Double.parseDouble(df.format(precio));
	}

}
