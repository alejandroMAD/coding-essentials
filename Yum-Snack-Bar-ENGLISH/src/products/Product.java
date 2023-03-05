package products;

/**
 * The Product class represents a generic product with a name and a price. It provides
 * methods to get and set the name and price of the product. It is intended to be a
 * superclass that other product classes can inherit from.
 * 
 * @author Alejandro M. González
 */
public abstract class Product {
	
	private double price;
	private final String name;

	/**
	 * Constructs a new Product object with a given price and name.
	 * @param price the price of the product
	 * @param name  the name of the product
	 */
	public Product(double price, String name) {
		this.price = price;
		this.name = name;
	}

	/**
	 * Returns a String representation of the Product object, including its name and price.
	 * @return a String representation of the Product object
	 */
	@Override
	public String toString() {
		return "Product: '" + name + "' - price=" + price;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
