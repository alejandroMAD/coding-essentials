package products;

/**
 * A class representing a Menu product that includes a SodaCup and a PopcornBox
 * at a reduced price. The price of the Menu varies depending on the Size of its components.
 * 
 * An exception prevents the creation of Menu objects composed by SodaCup and PopcornBox
 * objects of different Size according to the business logic.
 * 
 * @author Alejandro M. González
 */
public class Menu extends Product {

	private SodaCup sodaCup;
	private PopcornBox popcornBox;
	private final static String NAME = "Soda cup + Popcorn box at menu price";
	private final static double MEDIUM_PRICE = 7.95;
	private final static double LARGE_PRICE = 8.95;
	private final static double EXTRALARGE_PRICE = 9.95;
	private double menuPrice;

	/**
	 * Constructs a Menu object with a given SodaCup and PopcornBox. The price of the menu
	 * will be set according to the size of its components. If their sizes don't match,
	 * an IllegalSizeException will be thrown.
	 * @param sodaCup               The SodaCup object to include in the menu
	 * @param popcornBox            The PopcornBox object to include in the menu
	 * @throws IllegalSizeException if the sizes of the given SodaCup and PopcornBox don't match
	 */
	public Menu(SodaCup sodaCup, PopcornBox popcornBox) throws IllegalSizeException {
		super(MEDIUM_PRICE, NAME);
		if (sodaCup.getSize() != popcornBox.getSize()) {
			throw new IllegalSizeException("Soda cup and popcorn box must be of the same size.");
		}
		this.sodaCup = sodaCup;
		this.popcornBox = popcornBox;
		
		if (this.sodaCup.getSize().equals(Size.LARGE)) {
			this.menuPrice = LARGE_PRICE;
		} else if (this.sodaCup.getSize().equals(Size.EXTRALARGE)) {
			this.menuPrice = EXTRALARGE_PRICE;
		}
		super.setPrice(menuPrice);			
	}

	@Override
	public String toString() {
		return "Menu: Soda+Popcorn '" + sodaCup.getSize()
				+ "' - price=" + super.getPrice();
	}

	public SodaCup getSodaCup() {
		return sodaCup;
	}

	public PopcornBox getPopcornBox() {
		return popcornBox;
	}

	public double getMenuPrice() {
		return menuPrice;
	}
	
}

