package fichero;

import java.io.*;
import java.util.Collections;
import java.util.List;

import tienda.Transaccion;

/**
 * La clase LogTransaccion proporciona métodos para garantizar la persistencia de información
 * guardando transacciones de tipo Transaccion en un fichero y cargando transacciones desde
 * el fichero. Las transacciones se escriben en el fichero en un formato predeterminado, que
 * incluye el ID de la Transaccion, su fecha y hora, los productos que la componen y precio total.
 * 
 * El fichero se guarda bajo el nombre definido por una constante estática: "log.txt".
 * 
 * @author Alejandro M. González
 */
public class LogTransaccion {
	
	private static final String NOMBRE_FICHERO = "log.txt";

	/**
	 * Guarda la lista de transacciones en un fichero. Cada Transaccion se escribe en un
	 * formato predeterminado, que incluye su ID, su fecha y hora, los productos que la
	 * componen y el precio total. La Transaccion más cara es marcada con el símbolo "(!)".
	 * El fichero es guardado con el nombre especificado por la constante NOMBRE_FICHERO.
	 * @param transacciones la lista de transacciones que serán guardadas
	 */
	public static void guardarTransacciones(List<Transaccion> transacciones) {
		Transaccion transaccionMasCara = Collections.max(transacciones);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_FICHERO, true))) {
			for (Transaccion transaccion : transacciones) {
				String linea = transaccion.getFechaHoraFormateadas() 
						+ " ID=" + transaccion.getID() + ", ";
				for (int i = 0; i < transaccion.getItems().size(); i++) {
					linea += transaccion.getItems().get(i).getNombre();
					if (i < transaccion.getItems().size() - 1) {
						linea += ", ";
					} else {
						linea += "; ";
					}
				}
				
				linea += "precio=" + transaccion.getPrecioTotal();
				
				if (transaccion.equals(transaccionMasCara)) {
					linea += " (!)";
				}
				bw.write(linea + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga las transacciones del fichero de log especificado en NOMBRE_FICHERO
	 * e imprime cada línea de transacción en la consola.
	 */
	public static void cargarTransacciones() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
