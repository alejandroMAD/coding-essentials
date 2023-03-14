import java.util.Arrays;

/**
 * A subclass of ScienceRobot that implements various methods for processing inputs
 * by cutting them in half or extracting whole and decimal parts
 * 
 * @author Alejandro M. González
 *
 */
public final class CuttingRobot extends ScienceRobot {

	/**
	 * Constructs a new CuttingRobot with the specified name and serial number.
	 * @param name         The name of the robot
	 * @param serialNumber The serial number of the robot
	 */
	public CuttingRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}

	/**
	 * Processes the input number and returns a string that describes
	 * its whole part and decimal part.
	 * @param inputNumber The input number to be processed
	 * @return a string that contains the whole and decimal parts of the input number
	 */
	@Override
	public String process(double inputNumber) {
		if ((inputNumber % 1) == 0) {
			return "Whole part: " + (int) inputNumber + "; Decimal part: 0.0";
		} else {
			int wholePart = (int) inputNumber;
			double decimalPart = inputNumber - wholePart;
			return "Whole part: " + wholePart + "; Decimal part: " + decimalPart;
		}
	}

	/**
	 * Processes the input integer and returns half of it.
	 * @param inputNumber The input integer to be processed
	 * @return half of the input integer
	 */
	public int process(int inputNumber) {
		return inputNumber / 2;
	}

	/**
	 * Cuts the input string in half and prints both halves separated by a slash.
	 * @param string The input string to be processed
	 */
	public void process(String string) {
		int halfLength = string.length() / 2;
		String firstHalf = string.substring(0, halfLength);
		String secondHalf = string.substring(halfLength);
		System.out.println(firstHalf + " / " + secondHalf);
	}

	/**
	 * Divides the input integer array into two halves and prints each half as an array.
	 * @param intArray The input integer array to be processed
	 */
	public void process(int[] intArray) {
		int halfLength = intArray.length / 2;
		int[] firstHalf = Arrays.copyOfRange(intArray, 0, halfLength);
		int[] secondHalf = Arrays.copyOfRange(intArray, halfLength, intArray.length);
		System.out.print("First half: " + Arrays.toString(firstHalf) + " / ");
		System.out.println("Second half: " + Arrays.toString(secondHalf));
	}

	/**
	 * Divides the input string array into two halves and prints each half as an array.
	 * @param stringArray the input string array to be processed
	 */
	public void process(String[] stringArray) {
		int halfLength = stringArray.length / 2;
		String[] firstHalf = Arrays.copyOfRange(stringArray, 0, halfLength);
		String[] secondHalf = Arrays.copyOfRange(stringArray, halfLength, stringArray.length);
		System.out.print("First half: " + Arrays.toString(firstHalf) + " / ");
		System.out.println("Second half: " + Arrays.toString(secondHalf));
	}

}
