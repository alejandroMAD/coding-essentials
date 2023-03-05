import java.util.Arrays;

public final class CuttingRobot extends ScienceRobot {

	public CuttingRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}

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

	public int process(int inputNumber) {
		return inputNumber / 2;
	}

	public void process(String string) {
		int halfLength = string.length() / 2;
		String firstHalf = string.substring(0, halfLength);
		String secondHalf = string.substring(halfLength);
		System.out.println(firstHalf + " / " + secondHalf);
	}

	public void process(int[] intArray) {
		int halfLength = intArray.length / 2;
		int[] firstHalf = Arrays.copyOfRange(intArray, 0, halfLength);
		int[] secondHalf = Arrays.copyOfRange(intArray, halfLength, intArray.length);
		System.out.print("First half: " + Arrays.toString(firstHalf) + " / ");
		System.out.println("Second half: " + Arrays.toString(secondHalf));
	}

	public void process(String[] sArray) {
		int halfLength = sArray.length / 2;
		String[] firstHalf = Arrays.copyOfRange(sArray, 0, halfLength);
		String[] secondHalf = Arrays.copyOfRange(sArray, halfLength, sArray.length);
		System.out.print("First half: " + Arrays.toString(firstHalf) + " / ");
		System.out.println("Second half: " + Arrays.toString(secondHalf));
	}

}
