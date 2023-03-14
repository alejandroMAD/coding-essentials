package fichero;

import java.io.*;
import java.util.Collections;
import java.util.List;

import tienda.Transaccion;

/**
 * The TransactionLogger class provides methods to ensure data persistence, logging transactions
 * to a file and loading transactions from a file. The transactions are written to a file with
 * a specific format, including the transaction ID, timestamp, items, and total cost.
 * 
 * The file is stored with a constant file name "log.txt".
 * 
 * @author Alejandro M. González
 */
public class TransactionLogger {
	
	private static final String FILE_NAME = "log.txt";

	/**
	 * Logs the list of transactions to a file. Each transaction is written in a specific format,
	 * including the transaction ID, timestamp, items, and total cost. The most expensive transaction
	 * is marked with the symbol '(!)'. The file is stored with the file name specified by FILE_NAME.
	 * @param transactions The list of transactions to be logged.
	 */
	public static void logTransactions(List<Transaccion> transactions) {
		Transaccion highestTransaction = Collections.max(transactions);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			for (Transaccion transaction : transactions) {
				String line = transaction.getFechaHoraFormateadas() 
						+ " ID=" + transaction.getID() + ", ";
				for (int i = 0; i < transaction.getItems().size(); i++) {
					line += transaction.getItems().get(i).getNombre();
					if (i < transaction.getItems().size() - 1) {
						line += ", ";
					} else {
						line += "; ";
					}
				}
				
				line += "price=" + transaction.getPrecioTotal();
				
				if (transaction.equals(highestTransaction)) {
					line += " (!)";
				}
				bw.write(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the transactions from the log file specified by FILE_NAME and prints
	 * each transaction to the console.
	 */
	public static void loadTransactions() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
