package products;

/**
 * PopcornBox class represents a type of Product, specifically a box of popcorn.
 * It has a static name, a size, and a price which varies depending on the size chosen.
 * The class provides getters and setters for the size and price properties.
 * 
 * Inherits from Product class, which provides the basic structure for product items.
 * 
 * @author Alejandro M. González
 */
public class PopcornBox extends Product {
	
	private final static String name = "Popcorn box";
	private final static double MEDIUM_PRICE = 5.0;
	private final static double LARGE_PRICE = 7.0;
	private final static double EXTRALARGE_PRICE = 9.0;
	private Size size;
	private double price = MEDIUM_PRICE;

	/**
	 * Constructs a new PopcornBox with the specified size a sets the price
	 * according to the static fields for each size.
	 * 
	 * @param size The size of the PopcornBox.
	 */
	public PopcornBox(Size size) {
		super(MEDIUM_PRICE, name);
		this.size = size;
		
		if (size.equals(Size.LARGE)) {
			this.price = LARGE_PRICE;
		} else if (size.equals(Size.EXTRALARGE)) {
			this.price = EXTRALARGE_PRICE;
		}
		super.setPrice(price);			
	}

	@Override
	public String toString() {
		return name + " '" + size + "' - price=" + price + "]";
	}

	// Getters and setters
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}
}
