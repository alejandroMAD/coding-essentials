package products;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * CandyBag class extends the Product class and implements the Measurable interface. 
 * It represents a product that is a bag of gummy candies. The CandyBag class defines
 * a static constant name, a static constant PRICE_PER_100_MG, and an instance variable weight.
 * It also has a constructor that initializes the weight and price of the product,
 * as well as a method that calculates the total price based on the weight of the product.
 * 
 * @author Alejandro M. González
 */
public class CandyBag extends Product implements Measurable {
	
	private final static String NAME = "Gummy candy bag";
	private final static double PRICE_PER_100_MG = 1.10;
	private double weight;
	private double totalPrice;

	/**
	 * Constructs a new CandyBag object with the specified weight. 
	 * 
	 * @param weight                    The weight of the CandyBag product in grams. Must be 20g or higher.
	 * @throws IllegalArgumentException if the weight is less than 20g.
	 */
	public CandyBag(double weight) {
		super(PRICE_PER_100_MG, NAME);
		
	    if (weight < 20) {
	        throw new IllegalArgumentException("CandyBag weight must be 20g or higher");
	    }
		this.weight = weight;
	    this.totalPrice = calculatePrice(weight);
	    
	    super.setPrice(totalPrice);
	}

	/**
	 * Calculates the price of the CandyBag product based on its weight
	 * and formats the return value to have a maximum of two decimal places.
	 * 
	 * @param weightOrAmount The weight of the CandyBag product in grams.
	 * @return The total price of the CandyBag product as a double value of two decimal places.
	 */
	@Override
	public double calculatePrice(double weightOrAmount) {
	    double price = weight * PRICE_PER_100_MG / 100;
	    DecimalFormat df = new DecimalFormat(
	    		"#.##", new DecimalFormatSymbols(Locale.ENGLISH)
		);
	    return Double.parseDouble(df.format(price));
	}

	// Getters
	public double getWeight() {
		return weight;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	
}



