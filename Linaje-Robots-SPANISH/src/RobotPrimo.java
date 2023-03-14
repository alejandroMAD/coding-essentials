
/**
 * Subclase de RobotCientifico que proporciona métodos para evaluar si un número
 * es o no primo y para imprimir la lista de números primos en determinado intervalo.
 * 
 * @author Alejandro M. González
 *
 */
public final class RobotPrimo extends RobotCientifico {

	/**
	 * Construye un RobotPrimo con el nombre y número de serie especificados.
	 * @param nombre         The name of the PrimeRobot
	 * @param numeroSerie The serial number of the PrimeRobot
	 */
	public RobotPrimo(String nombre, String numeroSerie) {
		super(nombre, numeroSerie);
	}

	/**
	 * Devuelve un mensaje indicando si el número recibido es primo o no.
	 * @param numeroInput El número para ser evaluado por el método
	 * @return un mensaje indicando si el número recibido es o no primo
	 */
	@Override
    public String procesar(double numeroInput) {
        if (numeroInput <= 1) {
            return "Sólo los enteros mayores que 1 pueden ser números primos.";
        } else if (numeroInput % 1 != 0) {
        	return "Los números no naturales con decimales no pueden ser primos.";  	
        }
        
        if (esPrimo((int) numeroInput)) {
        	return (int) numeroInput + " es un número primo.";        	
        } else {
        	return (int) numeroInput + " no es un número primo.";        	
        }
    }
	
	/**
	 * Devuelve un array de números primos en el intervalo especificado
	 * (principio y fin incluidos). Devuelve null si no hay números primos
	 * en el intervalo o si el valor del principio es mayor que el fin.
	 * @param principio El valor de inicio del intervalo
	 * @param fin       El valor del final del intervalo
	 * @return Un array de números primos en el intervalo especificado o null
	 *         si no hay números primos en dicho intervalo o el valor del principio
	 *         es mayor que el valor del fin
	 */
	public static int[] mostrarPrimosEnIntervalo(int principio, int fin) {
	    if (principio > fin) {
	        return null;
	    }

	    int contadorPrimos = 0;
	    for (int i = principio; i <= fin; i++) {
	        if (esPrimo(i)) {
	            contadorPrimos++;
	        }
	    }

	    if (contadorPrimos == 0) {
	        return null;
	    }

	    int[] arrayPrimos = new int[contadorPrimos];
	    int indice = 0;
	    for (int i = principio; i <= fin; i++) {
	        if (esPrimo(i)) {
	            arrayPrimos[indice] = i;
	            indice++;
	        }
	    }

	    return arrayPrimos;
	}

	/**
	 * Evalúa si el número recibido por argumento es primo o no.
	 * Se trata de un método auxiliar empleado por otros métodos
	 * de la clase {@link RobotPrimo}.
	 * @param numero El número para ser evaluado
	 * @return true si el número es primo, false en caso contrario
	 */
	private static boolean esPrimo(int numero) {
	    if (numero <= 1) {
	        return false;
	    }
	    for (int i = 2; i <= Math.sqrt(numero); i++) {
	        if (numero % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}

