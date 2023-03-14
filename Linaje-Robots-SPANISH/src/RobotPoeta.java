import java.util.Random;

/**
 * Subclase de RobotArtista que recita versos de poesías o canciones. Define dos
 * métodos constructores, uno sin especificación del comportamiento y otro que sí
 * la incluye. Si el comportamiento es definido como NORMAL, el robot recitará de
 * manera ordenada los versos de una de las colecciones almacenadas elegida de manera
 * aleatoria. Si el comportamiento es ALEATORIO, el robot recitará cuatro versos
 * escogidos aleatoriamente de cualquiera de las colecciones almacenadas.
 * 
 * @author Alejandro M. González
 *
 */
public final class RobotPoeta extends RobotArtista {

	private String[] versos1 = {
			"1-1 Ir y quedarse, y con quedar partirse,",
			"1-2 Partir sin alma, y ir con alma ajena,",
			"1-3 Oír la dulce voz de una sirena",
			"1-4 Y no poder del árbol desasirse"
	};
	private String[] versos2 = {
			"2-1 ¿Qué es poesía?, dices mientras clavas",
			"2-2 en mi pupila tu pupila azul.",
			"2-3 ¡Qué es poesía!, ¿Y tú me lo preguntas?",
			"2-4 Poesía... eres tú.",
	};
	private String[] versos3 = {
			"3-1 Tu rencor, tu porqué, tu agonía...",
			"3-2 O tal vez esa sombra",
			"3-3 que se tumba a tu lado en la alfombra",
			"3-4 A esperar que suba la marea."
	};
	private String[][] coleccionVersos = { versos1, versos2, versos3 }; 
	
	/**
	 * Construye un RobotPoeta con el nombre y número de serie especificados.
	 * @param nombre      El nombre del RobotPoeta
	 * @param numeroSerie El número de serie del RobotPoeta
	 */
    public RobotPoeta(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
	}
    
    /**
     * Construye un RobotPoeta con el nombre, número de serie y comportamiento especificados.
     * @param nombre         El nombre del RobotPoeta
     * @param numeroSerie    El número de serie del RobotPoeta
     * @param comportamiento El comportamiento del RobotPoeta, NORMAL o ALEATORIO.
	 *                       Determina la manera de selección de versos del método recitar()
     */
    public RobotPoeta(String nombre, String numeroSerie, Comportamiento comportamiento) {
    	super(nombre, numeroSerie, comportamiento);
    }

    /**
     * Recita versos de acuerdo con el comportamiento del robot. Si el comportamiento es NORMAL,
     * el RobotPoeta recitará los cuatro versos de uno de los arrays predefinidos con canciones
     * o poemas. Si el comportamiento es ALEATORIO, el robot seleccionará y recitará de manera
     * aleatoria 4 versos de cualquiera de los arrays.
     */
    public void recitar() {
    	if (this.comportamiento.equals(RobotArtista.Comportamiento.NORMAL)) {
    		int seleccionAleatoria = (int) (Math.random() * 3);
    		for (String verso : coleccionVersos[seleccionAleatoria]) {
				System.out.println(verso);
			}  		
    	} else if (this.comportamiento.equals(RobotArtista.Comportamiento.ALEATORIO)) {
    		String[] versosMezclados = new String[versos1.length + versos2.length + versos3.length];
    		int indice = 0;
    		
    		for (String verso : versos1) {
    			versosMezclados[indice++] = verso;
    		}
    		for (String verso : versos2) {
    			versosMezclados[indice++] = verso;
    		}
    		for (String verso : versos3) {
    			versosMezclados[indice++] = verso;
    		}
    		
    		Random random = new Random();
    		for (int i = 0; i < 4; i++) {
    			int indiceAleatorio = random.nextInt(versosMezclados.length);
    			System.out.println(versosMezclados[indiceAleatorio]);
    		}	
    	}
    }
}

