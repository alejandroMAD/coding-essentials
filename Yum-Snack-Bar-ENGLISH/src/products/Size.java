package products;

/**
 * The {@code Size} enum type represents the size of certain types of products.
 * It defines three constants representing different sizes: MEDIUM, LARGE and EXTRALARGE.
 * Each constant has an abbreviation that can be used to display the size in a compact way.
 * 
 * @author Alejandro M. González
 */
public enum Size {
	MEDIUM("M"), LARGE("L"), EXTRALARGE("XL");

	private final String abbreviation;

	/**
	 * Constructor for Size enum.
	 * @param abbreviation the abbreviation of the size
	 */
	Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * Gets the abbreviation of the size.
	 * @return the abbreviation of the size
	 */
	public String getAbbreviation() {
		return this.abbreviation;
	}
}
