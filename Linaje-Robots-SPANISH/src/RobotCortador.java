import java.util.Arrays;

/**
 * Subclase de RobotCientifico que implementa varios métodos para procesar valores
 * recibidos como entrada dividiéndolos por la mitad o separando su parte entera y decimal.
 * 
 * @author Alejandro M. González
 *
 */
public final class RobotCortador extends RobotCientifico {

	/**
	 * Construye un RobotCortador con el nombre y número de serie especificados.
	 * @param nombre      El nombre del RobotCortador
	 * @param numeroSerie El número de serie del RobotCortador
	 */
	public RobotCortador(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
	}

	/**
	 * Procesa el número recibido como input y devuelve un string expresando
	 * por separado su parte entera y su parte decimal.
	 * @param numeroInput El número recibido como entrada para ser procesado
	 * @return un string que expresa por separado la parte entera y decimal del número
	 */
	@Override
	public String procesar(double numeroInput) {
		if ((numeroInput % 1) == 0) {
			return "Parte entera: " + (int) numeroInput + "; Parte decimal: 0.0";
		} else {
			int parteEntera = (int) numeroInput;
			double parteDecimal = numeroInput - parteEntera;
			return "Parte entera: " + parteEntera + "; Parte decimal: " + parteDecimal;
		}
	}

	/**
	 * Procesa el número entero recibido por argumento y lo devuelve dividido por dos
	 * @param numeroInput The input integer to be processed
	 * @return half of the input integer
	 */
	public int procesar(int numeroInput) {
		return numeroInput / 2;
	}

	/**
	 * Divide la cadena recibida por la mitad e imprime las dos mitades separadas por una barra
	 * @param cadena La cadena recibida para ser procesada
	 */
	public void process(String cadena) {
		int mitadLongitud = cadena.length() / 2;
		String primeraMitad = cadena.substring(0, mitadLongitud);
		String segundaMitad = cadena.substring(mitadLongitud);
		System.out.println(primeraMitad + " / " + segundaMitad);
	}

	/**
	 * Divide el array de enteros recibido en dos mitades e imprime en consola cada una de
	 * las dos mitades resultantes como un array.
	 * @param arrayEnteros El array de enteros recibido para ser procesado
	 */
	public void procesar(int[] arrayEnteros) {
		int mitadLongitud = arrayEnteros.length / 2;
		int[] primeraMitad = Arrays.copyOfRange(arrayEnteros, 0, mitadLongitud);
		int[] segundaMitad = Arrays.copyOfRange(arrayEnteros, mitadLongitud, arrayEnteros.length);
		System.out.print("Primera mitad: " + Arrays.toString(primeraMitad) + " / ");
		System.out.println("Segunda mitad: " + Arrays.toString(segundaMitad));
	}

	/**
	 * Divide el array de strings recibido en dos mitades e imprime en consola cada una de
	 * las dos mitades resultantes como un array.
	 * @param arrayStrings El array de strings recibido para ser procesado
	 */
	public void procesar(String[] arrayStrings) {
		int mitadLongitud = arrayStrings.length / 2;
		String[] primeraMitad = Arrays.copyOfRange(arrayStrings, 0, mitadLongitud);
		String[] segundaMitad = Arrays.copyOfRange(arrayStrings, mitadLongitud, arrayStrings.length);
		System.out.print("Primera mitad: " + Arrays.toString(primeraMitad) + " / ");
		System.out.println("Segunda mitad: " + Arrays.toString(segundaMitad));
	}

}
