
/**
 * La clase RobotCientifico representa un robot especializado en tareas relacionadas con
 * la ciencia. Hereda de Robot y declara el método abstracto procesar() que recibe un valor
 * double numeroInput y devuelve un String, exigiendo de todas las subclases una implementación
 * de este método. RobotCientifico sobreescribe toString() indicando la disciplina a la que
 * pertenece el robot: "Ciencia".
 * 
 * Puede accederse al nombre y número de serie del robot por medio de getters y setters
 * públicos. Esta clase es abstracta y no puede instanciarse por sí misma.
 * 
 * @author Alejandro M. González
 *
 */
public abstract class RobotCientifico extends Robot {
	
	/**
	 * Construye un RobotCientifico con el nombre y número de serie especificados.
	 * @param nombre      El nombre del RobotCientifico
	 * @param numeroSerie El número de serie del RobotCientifico
	 */
	public RobotCientifico(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", disciplina=Ciencia]";
	}

	/**
	 * Procesa el input de tipo double y devuelve un String como resultado.
	 * @param numeroInput El input de tipo double para ser procesado
	 * @return un string que representa el resultado de procesar el valor del input.
     */
	public abstract String procesar(double numeroInput);

}
