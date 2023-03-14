import java.util.Random;

/**
 * A subclass of ArtsRobots which that recites verses. It has two constructors,
 * one without a behavior parameter and another one with it. If the behavior
 * is set to REGULAR, the robot will randomly recite one of three stored verses array
 * in an orderly fashion. If the behavior is set to RANDOM, the robot will choose
 * and recite four random verses from any of the stored arrays.
 * 
 * @author Alejandro M. González
 *
 */
public final class PoetRobot extends ArtsRobot {

	private String[] verses1 = {
			"1-1 Ir y quedarse, y con quedar partirse,",
			"1-2 Partir sin alma, y ir con alma ajena,",
			"1-3 Oír la dulce voz de una sirena",
			"1-4 Y no poder del árbol desasirse"
	};
	private String[] verses2 = {
			"2-1 ¿Qué es poesía?, dices mientras clavas",
			"2-2 en mi pupila tu pupila azul.",
			"2-3 ¡Qué es poesía!, ¿Y tú me lo preguntas?",
			"2-4 Poesía... eres tú.",
	};
	private String[] verses3 = {
			"3-1 Tu rencor, tu porqué, tu agonía...",
			"3-2 O tal vez esa sombra",
			"3-3 que se tumba a tu lado en la alfombra",
			"3-4 A esperar que suba la marea."
	};
	private String[][] versesCollection = { verses1, verses2, verses3 }; 
	
	/**
	 * Constructs a PoetRobot object with a given name and serial number.
	 * @param name         The name of the robot.
	 * @param serialNumber The serial number of the robot.
	 */
    public PoetRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
    
    /**
     * Constructs a PoetRobot object with a given name, serial number and behavior.
     * @param name         The name of the robot.
     * @param serialNumber The serial number of the robot.
     * @param behavior     The behavior of the robot (REGULAR or RANDOM).
     */
    public PoetRobot(String name, String serialNumber, Behavior behavior) {
    	super(name, serialNumber, behavior);
    }

    /**
     * Recites verses according to the robot's behavior. If the behavior is set to REGULAR,
     * the robot will recite the four verses of one of the stored pre-defined verses array.
     * If the behavior is set to RANDOM, the robot will choose and recite four random verses
     * from any of the stored arrays.
     */
    public void recite() {
    	if (this.behavior.equals(ArtsRobot.Behavior.REGULAR)) {
    		int randomChoice = (int) (Math.random() * 3);
    		for (String verse : versesCollection[randomChoice]) {
				System.out.println(verse);
			}  		
    	} else if (this.behavior.equals(ArtsRobot.Behavior.RANDOM)) {
    		String[] shuffledVerses = new String[verses1.length + verses2.length + verses3.length];
    		int index = 0;
    		
    		for (String verse : verses1) {
    			shuffledVerses[index++] = verse;
    		}
    		for (String verse : verses2) {
    			shuffledVerses[index++] = verse;
    		}
    		for (String verse : verses3) {
    			shuffledVerses[index++] = verse;
    		}
    		
    		Random random = new Random();
    		for (int i = 0; i < 4; i++) {
    			int randomIndex = random.nextInt(shuffledVerses.length);
    			System.out.println(shuffledVerses[randomIndex]);
    		}	
    	}
    }
}

