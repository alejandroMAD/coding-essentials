package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import file.TransactionLogger;
import products.*;
import products.SodaCup.SodaType;

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
		
		Store.printGreeting();
		
		// ArrayList to store the transactions
		ArrayList<Transaction> listTransactions = new ArrayList<Transaction>();

		// First transaction
		PopcornBox popcornBox001 = new PopcornBox(Size.LARGE);
		Snack snack001 = new Snack();	
		Transaction transaction001 = new Transaction(
				1, Arrays.asList(popcornBox001, snack001));
		listTransactions.add(transaction001);
		System.out.println(transaction001);

		// Second transaction
		try {
			SodaCup sodaCup001 = new SodaCup(Size.MEDIUM, SodaType.LIGHT_COLA);
			MixedNutsBag mixedNutsBag001 = new MixedNutsBag(400);
			Transaction transaction002 = new Transaction(
					2, Arrays.asList(sodaCup001, mixedNutsBag001));
			listTransactions.add(transaction002);
			System.out.println(transaction002);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Third transaction (invalid menu test)
		try {
			Menu menu = new Menu(
					new SodaCup(Size.EXTRALARGE, SodaType.LIGHT_COLA),
					new PopcornBox(Size.MEDIUM)
			);
			Transaction transaction003 = new Transaction(
					3, Arrays.asList(menu));
			listTransactions.add(transaction003);
		} catch (IllegalSizeException e) {
			e.printStackTrace();
		}
		
		// Fourth transaction (invalid weight argument)
		try {
			CandyBag candyBag001 = new CandyBag(6);
			Transaction transaction004 = new Transaction(
					4, Arrays.asList(candyBag001));
			listTransactions.add(transaction004);		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		// Fifth transaction (anonymous objects or object creation 'on the fly')
		try {
			Transaction transaction005 = new Transaction(
					5,
					Arrays.asList(
							new CandyBag(400),
							new Menu(
									new SodaCup(Size.EXTRALARGE, SodaType.ORANGE),
									new PopcornBox(Size.EXTRALARGE)
							)
					)
			);
			listTransactions.add(transaction005);
			System.out.println(transaction005);
		} catch (IllegalSizeException e) {
			e.printStackTrace();
		}
		
		// Sixth transaction
		try {
			CandyBag candyBag002 = new CandyBag(750);
			SodaCup sodaCup002 = new SodaCup(Size.EXTRALARGE, SodaType.COLA);
			Transaction transaction006 = new Transaction(
					6, Arrays.asList(candyBag002, sodaCup002));	
			listTransactions.add(transaction006);
			System.out.println(transaction006);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		Transaction highestTransaction = Collections.max(listTransactions);
		System.out.println("\nThe most expensive transaction (!) is:\n" + highestTransaction);
		
		// Logging and reading transactions log
		TransactionLogger.logTransactions(listTransactions);
		System.out.println("\n==== Transactions in the log file ====");
		TransactionLogger.loadTransactions();
	}
	
}
