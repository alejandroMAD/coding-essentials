
/**
 * A subclass of ScienceRobot that provides methods for checking if a number
 * is prime and printing a list of primes within a given interval.
 * 
 * @author Alejandro M. González
 *
 */
public final class PrimeRobot extends ScienceRobot {

	/**
	 * Constructs a new PrimeRobot object with the given name and serial number.
	 * @param name         The name of the PrimeRobot
	 * @param serialNumber The serial number of the PrimeRobot
	 */
	public PrimeRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}

	/**
	 * Returns a message indicating whether the input number is prime or not.
	 * @param inputNumber The number to be checked
	 * @return a message indicating whether the input number is prime or not
	 */
	@Override
    public String process(double inputNumber) {
        if (inputNumber <= 1) {
            return "Only whole numbers greater than 1 can be primes.";
        } else if (inputNumber % 1 != 0) {
        	return "Non natural numbers with decimals cannot be primes.";  	
        }
        
        if (isPrime((int) inputNumber)) {
        	return (int) inputNumber + " is a prime number.";        	
        } else {
        	return (int) inputNumber + " is not a prime number.";        	
        }
    }
	
	/**
	 * Returns an array of prime numbers within the given interval (inclusive).
	 * Returns null if there are no prime numbers within the interval
	 * or if the start value is greater than the end value.
	 * @param start The start value of the interval
	 * @param end   The end value of the interval
	 * @return an array of prime numbers within the given interval, or null
	 *         if there are no prime numbers within the interval or if
	 *         the start value is greater than the end value.
	 */
	public static int[] printPrimesInterval(int start, int end) {
	    if (start > end) {
	        return null;
	    }

	    int primesCount = 0;
	    for (int i = start; i <= end; i++) {
	        if (isPrime(i)) {
	            primesCount++;
	        }
	    }

	    if (primesCount == 0) {
	        return null;
	    }

	    int[] primesArray = new int[primesCount];
	    int arrayPosition = 0;
	    for (int i = start; i <= end; i++) {
	        if (isPrime(i)) {
	            primesArray[arrayPosition] = i;
	            arrayPosition++;
	        }
	    }

	    return primesArray;
	}

	/**
	 * Checks whether the input number is prime or not.
	 * This is an auxiliary method to be used by other methods
	 * in the {@link PrimeRobot} class.
	 * @param num The number to be checked
	 * @return true if the number is prime, false otherwise
	 */
	private static boolean isPrime(int num) {
	    if (num <= 1) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}

