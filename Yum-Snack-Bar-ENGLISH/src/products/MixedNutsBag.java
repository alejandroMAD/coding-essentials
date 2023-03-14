package products;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Represents a mixed nuts bag product that implements the Measurable interface.
 * The price is calculated based on the weight in grams. The class defines
 * a static constant name, a static constant PRICE_PER_100_MG, and an instance
 * variable weight.
 * 
 * @author Alejandro M. González
 */
public class MixedNutsBag extends Product implements Measurable {

	private final static String NAME = "Mixed nuts bag";
	private final static double PRICE_PER_100_MG = 1.80;
	private double weight;
	private double totalPrice;

	/**
	 * Constructs a MixedNutsBag object with a given weight.
	 * @param weight                    the weight in grams of the MixedNutsBag product.
	 * @throws IllegalArgumentException if the given weight is less than 20g.
	 */
	public MixedNutsBag(double weight) {
		super(PRICE_PER_100_MG, NAME);
		
	    if (weight < 20) {
	        throw new IllegalArgumentException("MixedNutsBag weight must be 20g or higher");
	    }
		this.weight = weight;
		this.totalPrice = calculatePrice(weight);

		super.setPrice(totalPrice);
	}

	/**
	 * Calculates the total price of the MixedNutsBag product based on the given weight
	 * and formats the return value to have a maximum of two decimal places.
	 * @param weightOrAmount the weight in grams of the MixedNutsBag product.
	 * @return the total price of the Mixed Nuts Bag product as a double value with 2 decimal places.
	 */
	@Override
	public double calculatePrice(double weightOrAmount) {
	    double price = weight * PRICE_PER_100_MG / 100;
	    DecimalFormat df = new DecimalFormat(
	    		"#.##", new DecimalFormatSymbols(Locale.ENGLISH)
		);
	    return Double.parseDouble(df.format(price));
	}

}
