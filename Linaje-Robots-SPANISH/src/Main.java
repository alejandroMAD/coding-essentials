import java.util.Arrays;

/**
 * Clase principal destinada a pruebas de la aplicación mediante la instanciación
 * de objetos de tipo Robot e invocación de sus métodos. Permite demostrar la
 * funcionalidad de las clases concretas RobotCortador, RobotPrimo, RobotPintor
 * y RobotPoeta. El método main() crea e imprime varios objetos de Robot dándoles
 * nombres y números de serie, y posteriormente invoca métodos de sus clases para
 * procesar números o cadenas, dibujar figuras o recitar versos.
 * 
 * @author Alejandro M. González
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Instanciación de los objetos
		RobotCortador robotCortador = new RobotCortador("Bender", "1010011010BU22");
		RobotPrimo robotPrimo = new RobotPrimo("Euclid", "E213002248G");
		RobotPintor robotPintor1 = new RobotPintor("Frida", "K15019071954L");
		RobotPintor robotPintor2 = new RobotPintor("Salvador", "D1904858585A", RobotArtista.Comportamiento.ALEATORIO);
		RobotPoeta robotPoeta1 = new RobotPoeta("Byron", "E18091849AP");
		RobotPoeta robotPoeta2 = new RobotPoeta("3DG4R-4LL4N-P03", "E18091849AP", RobotArtista.Comportamiento.ALEATORIO);
		
		// Impresión de la información de los objetos
		System.out.println(robotCortador);
		System.out.println(robotPrimo);
		System.out.println(robotPintor1);
		System.out.println(robotPintor2);
		System.out.println(robotPoeta1);
		System.out.println(robotPoeta2);
		
		// Llamadas a los métodos de los robots
    	System.out.println("\n+---------------------+");
		System.out.println("|     Operaciones     |");
		System.out.println("+---------------------+");
		
		System.out.println(robotPrimo.procesar(11));
		System.out.println(
				"Números primos entre 1 y 50:\n"
				+ Arrays.toString(RobotPrimo.mostrarPrimosEnIntervalo(1, 50))
		);
		
		robotPintor1.dibujar(RobotPintor.Figura.TRIANGULO, 8, '$');
		robotPintor2.dibujar(RobotPintor.Figura.TRIANGULO, 0, '?');
		
		System.out.println(robotCortador.procesar(0.285714));
		System.out.println(robotCortador.procesar(4.0));
		robotCortador.process("acurruca");
		robotCortador.procesar(new int[] {5, 5, 45, 66, 1001, 2, 3, 11});
		robotCortador.procesar(new String[] 
				{"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"}
		);
		
		robotPoeta1.recitar();
		robotPoeta2.recitar();
		
		// Impresión del contador de robots instanciados
		System.out.println("===== Robots construidos en total: [" + Robot.getRobotCount() + "] =====");

	}
}
