
public final class PrimeRobot extends ScienceRobot {

	public PrimeRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}

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

