
/**
 * Subclase de RobotArtista que implementa métodos para dibujar diversas figuras
 * como un cuadrado, un rombo o un triángulo en consola. Define dos constructores:
 * uno que recibe el nombre y número de serie por parámetros y otro que, además,
 * recibe el comportamiento. La clase asimismo incorpora un tipo enumerado Figura
 * que define las figuras disponibles para ser dibujadas.
 * 
 * @author Alejandro M. González
 *
 */
public final class RobotPintor extends RobotArtista {

	/**
	 * Construye un RobotPintor con el nombre y número de serie especificados.
	 * @param nombre      El nombre del RobotPintor
	 * @param numeroSerie El número de serie del RobotPintor
	 */

	public RobotPintor(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
	}
	
	/**
	 * Creates a new PainterRobot object with the specified name, serial number, and behavior.
	 * @param nombre         El nombre del RobotPintor
	 * @param numeroSerie    El número de serie del RobotPintor
	 * @param comportamiento El comportamiento del RobotPintor, NORMAL o ALEATORIO.
	 *                       Determina la salida del método dibujar()
	 */
	public RobotPintor(String nombre, String numeroSerie, Comportamiento comportamiento) {
		super(nombre, numeroSerie, comportamiento);
	}
	
	/**
	 * Tipo enumerado que representa todas las figuras geométricas susceptibles de ser
	 * dibujadas por un RobotPintor: CUADRADO, ROMBO y TRIANGULO.
	 */
	public static enum Figura {
	    CUADRADO, ROMBO, TRIANGULO
	}

	/**
	 * Dibuja en consola una figura geométrica con la altura y carácter especificados.
	 * El tipo de figura dibujada depende del comportamiento del robot. Si el comportamiento
	 * es NORMAL, el método dibuja la figura especificada con la altura y carácter indicados.
	 * Si el comportamiento es ALEATORIO, el método ignora los argumentos y dibuja una figura
	 * aleatoriamente con una altura aleatoria entre 2 y 12 líneas y un carácter aleatorio.
	 * @param figura     The shape to be drawn (SQUARE, RHOMBUS, or TRIANGLE)
	 * @param altura    The height of the shape to be drawn in lines of console output
	 */
	public void dibujar(Figura figura, int altura, char caracter) {
		if (this.comportamiento.equals(RobotArtista.Comportamiento.NORMAL)) {
		    switch(figura) {
	        	case TRIANGULO:
	        		dibujarTriangulo(altura, caracter);
	        		break;
		        case CUADRADO:
		            dibujarCuadrado(altura, caracter);
		            break;
		        case ROMBO:
		            dibujarRombo(altura, caracter);
		            break;
		        default:
		            System.out.println("La figura no es válida");
		            break;
		    }
		} else if (this.comportamiento.equals(RobotArtista.Comportamiento.ALEATORIO)) {
			int figuraAleatoria = (int) (Math.random() * 3 + 1);
			int alturaAleatoria = (int) (Math.random() * 12 + 2);
			int caracterAsciiAleatorio = (int) (Math.random() * 95 + 33); 
			
	        switch (figuraAleatoria) {
	            case 1:
	        		dibujarTriangulo(alturaAleatoria, (char) caracterAsciiAleatorio);
	        		break;
	            case 2:
		            dibujarCuadrado(alturaAleatoria, (char) caracterAsciiAleatorio);
		            break;
	            case 3:
		            dibujarRombo(alturaAleatoria, (char) caracterAsciiAleatorio);
		            break;
	        }
		}
	}
	
	/**
	 * Dibuja una figura TRIANGULO con la altura y carácter especificados.
	 * @param altura   La altura del triángulo dibujado en líneas de salida en consola
	 * @param caracter El carácter de repetición usado para dibujar el triángulo
	 */
	private void dibujarTriangulo(int altura, char caracter) {
		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(caracter);
			}
			System.out.println();
		}
	}

	/**
	 *  Dibuja una figura CUADRADO con la altura y carácter especificados.
	 *  @param altura   La altura del cuadrado dibujado en líneas de salida en consola
	 *  @param caracter El carácter de repetición usado para dibujar el cuadrado
	 */
	private void dibujarCuadrado(int altura, char caracter) {
	    for (int i = 0; i < altura; i++) {
	        for (int j = 0; j < altura; j++) {
	            System.out.print(caracter + " ");
	        }
	        System.out.println();
	    }
	}
	
	/**
	 *  Dibuja una figura ROMBO con la altura y carácter especificados.
	 *  @param altura   La altura del rombo dibujado en líneas de salida en consola
	 *  @param caracter El carácter de repetición usado para dibujar el rombo
	 */
	private void dibujarRombo(int altura, char caracter) {
	    int alturaRombo = altura % 2 == 0 ? altura + 1 : altura;
	    
	    for (int i = 1; i <= alturaRombo / 2 + 1; i++) {
	        for (int j = alturaRombo / 2 + 1 - i; j > 0; j--) {
	            System.out.print(" ");
	        }
	        for (int j = 1; j <= 2 * i - 1; j++) {
	            System.out.print(caracter);
	        }
	        System.out.println();
	    }
	    for (int i = alturaRombo / 2; i >= 1; i--) {
	        for (int j = alturaRombo / 2 + 1 - i; j > 0; j--) {
	            System.out.print(" ");
	        }
	        for (int j = 1; j <= 2 * i - 1; j++) {
	            System.out.print(caracter);
	        }
	        System.out.println();
	    }
	}
}
