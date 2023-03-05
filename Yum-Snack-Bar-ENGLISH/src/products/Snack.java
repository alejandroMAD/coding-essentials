package products;

/**
 * The Snack class represents a chocolate snack product. It extends
 * the Product class and sets the name and price of the product.
 * 
 * @author Alejandro M. González
 */
public class Snack extends Product {
	
	private final static String name = "Chocolate snack";
	private final static double PRICE = 2.0;

	/**
	 * Constructs a Snack object with the name and price specified by the constants.
	 */
	public Snack() {
		super(PRICE, name);
	}
	
}
