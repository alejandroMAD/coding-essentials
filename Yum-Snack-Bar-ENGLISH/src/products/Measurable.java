package products;

/**
 * The Measurable interface defines the behavior of objects that can calculate
 * their price based on a given weight or amount.
 * 
 * This interface requires that implementing classes provide a {@code calculatePrice()} method
 * that takes a weight or amount as a parameter and returns a double value representing
 * the calculated price. Implementing classes may use any formula or logic to calculate the price
 * based on the weight or amount parameter.
 * 
 * @author Alejandro M. González
 */
public interface Measurable {
	
	/**
	 * Calculates the price of the object based on a given weight or amount.
	 * 
	 * @param weightOrAmount the weight or amount to base the price calculation on
	 * @return a double value representing the calculated price
	 */
	public double calculatePrice(double weightOrAmount);

}
