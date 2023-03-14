
/**
 * La clase abstracta Robot representa un objeto de robot con un nombre, número de serie
 * y un contador estático de cuántos robots han sido creados. Esta clase no puede instanciarse
 * directamente, sino que sirve como superclase o modelo genérico para las clases concretas de robots.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class Robot {
	
	private String nombre;
	private String numeroSerie;
	private static int contadorRobots = 0;
	
	/**
	 * Contruye un nuevo objeto de tipo Robot con el nombre y número de serie especificados,
	 * a incrementa el contador contadorRobots.
	 * @param nombre      El nombre del robot.
	 * @param numeroSerie El número de serie del robot.
	 * */
	public Robot(String nombre, String numeroSerie) {
		this.nombre = nombre;
		this.numeroSerie = numeroSerie;
		contadorRobots++;
	}

	/**
	 * Devuelve la representación en String del objeto Robot.
	 * */
	@Override
	public String toString() {
		return "Soy un Robot de: [nombre=" + nombre + ", numeroSerie=" + numeroSerie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	/**
	 * Devuelve el número total de objetos de tipo Robot que han sido creados.
	 * @return el número total de objetos de tipo Robot que han sido creados.
	 */
	public static int getRobotCount() {
		return contadorRobots;
	}
	
}
