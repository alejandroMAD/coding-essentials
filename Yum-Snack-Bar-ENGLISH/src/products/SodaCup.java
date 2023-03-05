package products;

/**
 * Represents a soda beverage product, which can have three different sizes
 * and four different soda flavors.
 * 
 * Inherits from Product class, which provides the basic structure for product items.
 * 
 * @author Alejandro M. González
 */
public class SodaCup extends Product {

	public enum SodaType {
		COLA, LIGHT_COLA, ORANGE, LEMON
	}

	private final static String name = "Soda beverage cup";
	private final static double MEDIUM_PRICE = 4.5;
	private final static double LARGE_PRICE = 6.0;
	private final static double EXTRALARGE_PRICE = 7.5;
	private Size size;
	private SodaType sodaType;
	private double price = MEDIUM_PRICE;

	/**
	 * Creates a new SodaCup with a given size and soda type.
	 * @param size     the size of the soda cup (medium, large, extra large)
	 * @param sodaType the type or flavor of the beverage (cola, light cola, orange, lemon)
	 */
	public SodaCup(Size size, SodaType sodaType) {
		super(MEDIUM_PRICE, name);
		this.size = size;
		this.sodaType = sodaType;
		
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

	public SodaType getSodaType() {
		return sodaType;
	}

	public void setSodaType(SodaType sodaType) {
		this.sodaType = sodaType;
	}

	public double getPrice() {
		return price;
	}

}
