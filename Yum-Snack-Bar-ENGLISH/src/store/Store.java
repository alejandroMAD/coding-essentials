package store;

import java.time.LocalDate;
import java.time.Period;

/**
 * The {@code Store} class represents a snack bar store, with a fixed name,
 * address, foundation date, and a static method to print a greeting message.
 * 
 * @author Alejandro M. González
 */
public class Store {
	
    private static final String NAME = "Yum Snack Bar";
    private static final String ADDRESS = "Puerta del Sol, Km. 0, 28013 Madrid, Spain";
    private static final LocalDate FOUNDATION_DATE = LocalDate.of(1986, 1, 1);

    /**
     * Prints a formatted greeting message with the name, address, and years of service of the store.
     */
    public static void printGreeting() {
        String decoration = "+------------------------+";
        LocalDate now = LocalDate.now();
        int years = Period.between(FOUNDATION_DATE, now).getYears();

        System.out.println(decoration);
        System.out.printf("| Welcome to the %-12s|\n", NAME);
        System.out.printf("| %-24s|\n", ADDRESS);
        System.out.printf("| Serving popcorn, cholesterol, and joy for %-3d years. |\n", years);
        System.out.println(decoration);
    }
    
    // Getters
    public static String getNAME() {
        return NAME;
    }

    public static String getADDRESS() {
        return ADDRESS;
    }

    public static LocalDate getFOUNDATION_DATE() {
        return FOUNDATION_DATE;
    }
}


