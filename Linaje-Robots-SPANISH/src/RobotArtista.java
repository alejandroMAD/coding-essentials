
/**
 * La clase RobotArtista representa un robot especializado en tareas relacionadas con
 * las artes. Hereda de Robot e incorpora una propiedad Comportamiento que indica cómo
 * se comporta el robot al desempeñar sus tareas. La clase incluye también una sobreescritura
 * del método toString() para especificar la disciplina a la que pertenece el robot: "Arte".
 * 
 * Puede accederse al nombre y número de serie del robot por medio de getters y setters
 * públicos. Esta clase es abstracta y no puede instanciarse por sí misma.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class RobotArtista extends Robot {
	
	protected Comportamiento comportamiento;
	
	/**
	 * Enum que representa el comportamiento de un RobotArtista, NORMAL o ALEATORIO.
	 */
	public static enum Comportamiento {
		NORMAL, ALEATORIO
	}

	/**
	 * Construye un RobotArtista con el nombre y número de serie especificados,
	 * estableciendo su comportamiento por defecto como NORMAL.
	 * @param nombre      El nombre del RobotArtista
	 * @param numeroSerie El número de serie del RobotArtista
	 */
	public RobotArtista(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
		this.comportamiento = Comportamiento.NORMAL;
	}
	
	/**
	 * Construye un RobotArtista con el nombre, número de serie y comportamiento
	 * especificados.
	 * @param nombre         El nombre del RobotArtista
	 * @param numeroSerie    El número de serie del RobotArtista
	 * @param comportamiento El comportamiento del RobotArtista
	 */
	public RobotArtista(String nombre, String numeroSerie, Comportamiento comportamiento) {
		super(nombre, numeroSerie);
		this.comportamiento = comportamiento;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", disciplina=Arte]";
	}

}
