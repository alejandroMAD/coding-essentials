import java.util.Arrays;

/**
 * Main class responsible for testing the application by instantiating Robot objects
 * and invoking their methods. It demonstrates the functionality of the CuttingRobot,
 * PrimeRobot, PainterRobot, and PoetRobot specialized classes. The main method creates
 * and prints various Robot objects with their respective names and serial numbers,
 * and then invokes different methods from them for processing numbers or strings,
 * drawing shapes, and reciting verses.
 * 
 * @author Alejandro M. González
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Instantiating objects
		CuttingRobot cuttingRobot = new CuttingRobot("Bender", "1010011010BU22");
		PrimeRobot primeRobot = new PrimeRobot("Euclid", "E213002248G");
		PainterRobot painterRobot1 = new PainterRobot("Frida", "K15019071954L");
		PainterRobot painterRobot2 = new PainterRobot("Salvador", "D1904858585A", ArtsRobot.Behavior.RANDOM);
		PoetRobot poetRobot1 = new PoetRobot("Byron", "E18091849AP");
		PoetRobot poetRobot2 = new PoetRobot("3DG4R-4LL4N-P03", "E18091849AP", ArtsRobot.Behavior.RANDOM);
		
		// Printing objects' information
		System.out.println(cuttingRobot);
		System.out.println(primeRobot);
		System.out.println(painterRobot1);
		System.out.println(painterRobot2);
		System.out.println(poetRobot1);
		System.out.println(poetRobot2);
		
		// Invoking robots methods
    	System.out.println("\n+--------------------+");
		System.out.println("|     Operations     |");
		System.out.println("+--------------------+");
		
		System.out.println(primeRobot.process(11));
		System.out.println(
				"Primes between 1-50:\n"
				+ Arrays.toString(PrimeRobot.printPrimesInterval(1, 50))
		);
		
		painterRobot1.draw(PainterRobot.Shape.TRIANGLE, 8, '$');
		painterRobot2.draw(PainterRobot.Shape.TRIANGLE, 0, '?');
		
		System.out.println(cuttingRobot.process(0.285714));
		System.out.println(cuttingRobot.process(4.0));
		cuttingRobot.process("acurruca");
		cuttingRobot.process(new int[] {5, 5, 45, 66, 1001, 2, 3, 11});
		cuttingRobot.process(new String[] 
				{"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"}
		);
		
		poetRobot1.recite();
		poetRobot2.recite();
		
		// Printing the count of instantiated robots
		System.out.println("===== Built robots total: [" + Robot.getRobotCount() + "] =====");

	}
}
