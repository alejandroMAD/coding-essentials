package tienda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import fichero.TransactionLogger;
import productos.*;
import productos.Refresco.Sabor;

/**
 * Main class responsible for testing the store application by performing
 * purchases and transactions. The class creates multiple transactions with various
 * products such as popcorn, soda, candy, and nuts. Each transaction is stored
 * in an ArrayList of Transactions. The highest transaction is found by using the
 * Collections.max method, and the result is printed to the console.
 * 
 * The class also logs all the transactions by using the TransactionLogger class,
 * which writes the details of each transaction to a log file. The log file is read
 * afterwards using the loadTransactions method of the TransactionLogger class,
 * which prints the contents of the log file to the console.
 * 
 * @author Alejandro M. González
 */
public class Main {

	public static void main(String[] args) {
		
		Tienda.printGreeting();
		
		// ArrayList to store the transactions
		ArrayList<Transaccion> listTransactions = new ArrayList<Transaccion>();

		// First transaction
		Palomitas popcornBox001 = new Palomitas(Tamaño.GRANDE);
		Chocolatina snack001 = new Chocolatina();	
		Transaccion transaction001 = new Transaccion(
				1, Arrays.asList(popcornBox001, snack001));
		listTransactions.add(transaction001);
		System.out.println(transaction001);

		// Second transaction
		try {
			Refresco sodaCup001 = new Refresco(Tamaño.MEDIANO, Sabor.COLA_LIGHT);
			BolsaFrutosSecos mixedNutsBag001 = new BolsaFrutosSecos(400);
			Transaccion transaction002 = new Transaccion(
					2, Arrays.asList(sodaCup001, mixedNutsBag001));
			listTransactions.add(transaction002);
			System.out.println(transaction002);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Third transaction (invalid menu test)
		try {
			Menu menu = new Menu(
					new Refresco(Tamaño.GIGANTE, Sabor.COLA_LIGHT),
					new Palomitas(Tamaño.MEDIANO)
			);
			Transaccion transaction003 = new Transaccion(
					3, Arrays.asList(menu));
			listTransactions.add(transaction003);
		} catch (TamañoIlegalException e) {
			e.printStackTrace();
		}
		
		// Fourth transaction (invalid weight argument)
		try {
			BolsaChucherias candyBag001 = new BolsaChucherias(6);
			Transaccion transaction004 = new Transaccion(
					4, Arrays.asList(candyBag001));
			listTransactions.add(transaction004);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Fifth transaction (anonymous objects or object creation 'on the fly')
		try {
			Transaccion transaction005 = new Transaccion(
					5,
					Arrays.asList(
							new BolsaChucherias(400),
							new Menu(
									new Refresco(Tamaño.GIGANTE, Sabor.NARANJA),
									new Palomitas(Tamaño.GIGANTE)
							)
					)
			);
			listTransactions.add(transaction005);
			System.out.println(transaction005);
		} catch (TamañoIlegalException e) {
			e.printStackTrace();
		}
		
		// Sixth transaction
		try {
			BolsaChucherias candyBag002 = new BolsaChucherias(750);
			Refresco sodaCup002 = new Refresco(Tamaño.GIGANTE, Sabor.COLA);
			Transaccion transaction006 = new Transaccion(
					6, Arrays.asList(candyBag002, sodaCup002));	
			listTransactions.add(transaction006);
			System.out.println(transaction006);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		Transaccion highestTransaction = Collections.max(listTransactions);
		System.out.println("\nThe most expensive transaction (!) is:\n" + highestTransaction);
		
		// Logging and reading transactions log
		TransactionLogger.logTransactions(listTransactions);
		System.out.println("\n==== Transactions in the log file ====");
		TransactionLogger.loadTransactions();
	}
	
}
