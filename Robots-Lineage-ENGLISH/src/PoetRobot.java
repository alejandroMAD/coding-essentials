import java.util.Random;

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
	
    public PoetRobot(String name, String serialNumber) {
		super(name, serialNumber);
	}
    
    public PoetRobot(String name, String serialNumber, Behavior behavior) {
    	super(name, serialNumber, behavior);
    }

    public void recite() {
    	if (this.behavior.equals(ArtsRobot.Behavior.REGULAR)) {
    		int randomChoice = (int) (Math.random() * 3);
    		for (String verse : versesCollection[randomChoice]) {
				System.out.println(verse);
			}  		
    	} else if (this.behavior.equals(ArtsRobot.Behavior.RANDOM)) {
    		String[] verses = new String[verses1.length + verses2.length + verses3.length];
    		int index = 0;
    		
    		for (String verse : verses1) {
    			verses[index++] = verse;
    		}
    		for (String verse : verses2) {
    			verses[index++] = verse;
    		}
    		for (String verse : verses3) {
    			verses[index++] = verse;
    		}
    		
    		Random random = new Random();
    		for (int i = 0; i < 4; i++) {
    			int randomIndex = random.nextInt(verses.length);
    			System.out.println(verses[randomIndex]);
    		}	
    	}
    }
}

