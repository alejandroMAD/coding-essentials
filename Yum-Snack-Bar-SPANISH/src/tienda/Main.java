package tienda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import fichero.LogTransaccion;
import productos.*;
import productos.Refresco.Sabor;

/**
 * Clase principal destinada a pruebas de la aplicación de la tienda donde
 * se realizan las compras y transacciones. En el método main() se instancian
 * múltiples transacciones compuesta de varios productos de los tipos Palomitas,
 * Refresco, Chocolatina, BolsaChucherias y BolsaFrutosSecos. Cada Transaccion
 * es almacenada en un ArrayList y la Transaccion más cara es hallada por medio
 * del método Collections.max, imprimiéndose el resultado en consola.
 * 
 * Asimismo, en el flujo de ejecución se guardan todas las transacciones en un
 * fichero de log utilizando la clase LogTransaccion, que escribe los detalles
 * de cada Transaccion en el fichero. Finalmente, el fichero de log es leído
 * y su contenido se imprime en consola.
 * 
 * @author Alejandro M. González
 */
public class Main {

	public static void main(String[] args) {
		
		Tienda.imprimirBienvenida();
		
		// ArrayList para almacenar las transacciones de la sesión
		ArrayList<Transaccion> listaTransacciones = new ArrayList<Transaccion>();

		// Primera transacción
		Palomitas palomitas001 = new Palomitas(Tamaño.GRANDE);
		Chocolatina chocolatina001 = new Chocolatina();	
		Transaccion transaccion001 = new Transaccion(
				1, Arrays.asList(palomitas001, chocolatina001));
		listaTransacciones.add(transaccion001);
		System.out.println(transaccion001);

		// Segunda transacción
		try {
			Refresco refresco001 = new Refresco(Tamaño.MEDIANO, Sabor.COLA_LIGHT);
			BolsaFrutosSecos bolsaFrutosSecos001 = new BolsaFrutosSecos(400);
			Transaccion transaccion002 = new Transaccion(
					2, Arrays.asList(refresco001, bolsaFrutosSecos001));
			listaTransacciones.add(transaccion002);
			System.out.println(transaccion002);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Tercera transacción (inválida por Menu prohibido)
		try {
			Menu menu = new Menu(
					new Refresco(Tamaño.GIGANTE, Sabor.COLA_LIGHT),
					new Palomitas(Tamaño.MEDIANO)
			);
			Transaccion transaccion003 = new Transaccion(
					3, Arrays.asList(menu));
			listaTransacciones.add(transaccion003);
		} catch (TamañoIlegalException e) {
			e.printStackTrace();
		}
		
		// Cuarta transacción (inválida por peso prohibido)
		try {
			BolsaChucherias bolsaChucherias001 = new BolsaChucherias(6);
			Transaccion transaccion004 = new Transaccion(
					4, Arrays.asList(bolsaChucherias001));
			listaTransacciones.add(transaccion004);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Quinta transacción (objetos anónimos o instanciación de objetos "al vuelo")
		try {
			Transaccion transaccion005 = new Transaccion(
					5,
					Arrays.asList(
							new BolsaChucherias(400),
							new Menu(
									new Refresco(Tamaño.GIGANTE, Sabor.NARANJA),
									new Palomitas(Tamaño.GIGANTE)
							)
					)
			);
			listaTransacciones.add(transaccion005);
			System.out.println(transaccion005);
		} catch (TamañoIlegalException e) {
			e.printStackTrace();
		}
		
		// Sexta transacción
		try {
			BolsaChucherias bolsaChucherias002 = new BolsaChucherias(750);
			Refresco refresco002 = new Refresco(Tamaño.GIGANTE, Sabor.COLA);
			Transaccion transaccion006 = new Transaccion(
					6, Arrays.asList(bolsaChucherias002, refresco002));	
			listaTransacciones.add(transaccion006);
			System.out.println(transaccion006);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		Transaccion transaccionMasCara = Collections.max(listaTransacciones);
		System.out.println("\nLa transacción más cara de la sesión (!) es:\n" + transaccionMasCara);
		
		// Almacenamiento de las transacciones en un fichero y lectura de las transacciones almacenadas
		LogTransaccion.guardarTransacciones(listaTransacciones);
		System.out.println("\n==== Transacciones en el fichero de log ====");
		LogTransaccion.cargarTransacciones();
	}
	
}
