package library;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import database.DbBookManager;
import database.DbBorrowingManager;
import database.DbLibraryManager;
import database.DbReaderManager;
import model.Book;
import model.Borrowing;
import model.Reader;

/**
 * A class to handle the borrowing and returning of books by interacting with the database.
 * It provides methods for handling book borrowing and returning by users, taking into account
 * the maximum number of borrowings, borrowing period, and late return penalty rules of the library.
 * 
 * The class methods also handle a reader's borrowings count and days of penalty.
 * The user interaction occurs via the console's default input stream.
 * 
 * @author Alejandro M. González
 */
public class BorrowingHandler {
	
    private static final Scanner scanner = new Scanner(System.in);
    private static int maxBorrowings;
    private static int borrowingPeriodDays;
    private static int lateReturnPenaltyDays;

    /**
     * Constructor that initializes the BorrowingHandler object and reads the
     * maximum number of borrowings, borrowing period, and late return penalty
     * from the database. Then, it starts an input loop to handle user input for
     * borrowing or returning books.
     */
    public BorrowingHandler() {
    	maxBorrowings = DbLibraryManager.getMaxBorrowings();
    	borrowingPeriodDays = DbLibraryManager.getBorrowingPeriodDays();
    	lateReturnPenaltyDays = DbLibraryManager.getLateReturnPenaltyDays();
    	
        while (true) {
        	System.out.println("+--------------------------------------------------------------+");
        	System.out.println("| Do you want to borrow or return a book? (Borrow/Return/Exit) |");
        	System.out.println("+--------------------------------------------------------------+");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting program...");
                break;
            } else if (input.equals("borrow")) {
                handleBorrowing();
            } else if (input.equals("return")) {
                handleReturning();
            } else {
                System.err.println("Invalid input, please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Handles the borrowing of books. It prompts the user to input the book ID and reader ID,
     * and checks if the book is available for borrowing and if the reader has not exceeded
     * the maximum number of borrowings or has no late return penalty.
     * If all conditions are met, it creates a borrowing record in the database, updates
     * the book availability to false and increases the borrowed books count of the reader by 1.
     */
    private static void handleBorrowing() {
        System.out.println("Enter book ID:");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter reader ID:");
        int readerId = scanner.nextInt();
        scanner.nextLine();
        
        Book book = DbBookManager.getBookById(bookId);
        Reader reader = DbReaderManager.getReaderById(readerId);

        boolean available = DbBookManager.getBookAvailability(bookId);
        int readerBorrowingCount = DbReaderManager.getReaderBorrowedBooks(readerId);

        if (!available) {
            System.out.println(
            		"The book '" + book.getTitle() + "' is already borrowed.");
        } else if (readerBorrowingCount >= 3 ) {
        	System.out.println(
        			"Reader " + reader.getFirstName() + " " + reader.getLastName() 
        			+ " has already the maximum borrowings.");
        } else if (DbReaderManager.getReaderPenaltyCount(readerId) > 0 || isReaderLate(readerId)) {
        	System.out.println(
        			"Reader " + reader.getFirstName() + " " + reader.getLastName() 
        			+ " has a late return or penalty and can't borrow books.");        	
        } else {
            Timestamp borrowingDate = new Timestamp(System.currentTimeMillis());
            boolean success = DbBorrowingManager.createBorrowing(bookId, readerId, borrowingDate);

            if (success) {
                DbBookManager.setBookAvailability(bookId, false);
                DbReaderManager.updateReaderBorrowedBooks(readerId, 1);
                System.out.println(
                		"Book " + book.getTitle() + " borrowed successfully by " 
        				+ reader.getFirstName() + " " + reader.getLastName() 
                		+ " and set 'unavailable'.");
            } else {
                System.out.println("Failed to borrow book.");
            }
        }
    }

    /**
     * Handles the process of returning a book by prompting the user to enter the book ID and reader ID,
     * verifying that the book is currently borrowed by the specified reader, setting the return date
     * for the borrowing in the database, and updating the availability of the book and the number of
     * borrowed books for the reader if the process was successful.
     * 
     * The method also checks if this is a late return comparing the difference between the current time
     * and the borrowing time and updates de correspondent penalty values in the reader and borrowing tables.
     */
    private static void handleReturning() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter reader ID: ");
        int readerId = scanner.nextInt();
        scanner.nextLine();
        
        Book book = DbBookManager.getBookById(bookId);
        Reader reader = DbReaderManager.getReaderById(readerId);

        boolean available = DbBookManager.getBookAvailability(bookId);
        int borrowingId = DbBorrowingManager.getBorrowingId(bookId, readerId);
        Timestamp returnDate = DbBorrowingManager.getBorrowingReturnDate(borrowingId);

        if (available) {
            System.out.println(
            		"The book '" + book.getTitle() + "' is not currently borrowed.");
        } else if (returnDate != null) {
        	System.out.println(
        			"The book '" + book.getTitle() 
        			+ "' is not currently borrowed by reader " 
					+ reader.getFirstName() + " " + reader.getLastName());
        } else if (borrowingId == -1) {
        	System.out.println("No borrowing found for the specified book and reader IDs.");
        } else {
            returnDate = new Timestamp(System.currentTimeMillis());
            boolean success = DbBorrowingManager.setBorrowingReturnDate(borrowingId, returnDate);

            if (success) {
                DbBookManager.setBookAvailability(bookId, true);
                DbReaderManager.updateReaderBorrowedBooks(readerId, -1);
                System.out.println(
                		"Book '" + book.getTitle() + "' returned successfully and set 'available'.");
                
                Timestamp borrowingDate = DbBorrowingManager.getBorrowingDate(borrowingId);

                long diffInMillies = Math.abs(returnDate.getTime() - borrowingDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                if (diff > borrowingPeriodDays) {
                    int lateDays = (int) (diff - borrowingPeriodDays);
                    int penalty = lateDays * lateReturnPenaltyDays;
                    
                    DbReaderManager.updateReaderPenaltyCount(readerId, penalty);
                    DbBorrowingManager.setBorrowingOverduePenalty(borrowingId, penalty);
                    System.out.println("Late return penalty applied: " + penalty + " days.");
                }
            } else {
                System.out.println("Failed to return book.");
            }
        }
    }
    
    /**
     * Checks if a reader is currently late to return any borrowed books.
     * @param readerId the ID of the reader to check
     * @return true if the reader is late to return any books in possession, false otherwise
     */
    public static boolean isReaderLate(int readerId) {
        List<Borrowing> borrowings = DbBorrowingManager.getBorrowingsByReaderId(readerId);
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getReturnDate() == null) {
                Timestamp borrowingDate = borrowing.getBorrowingDate();
                long diff = System.currentTimeMillis() - borrowingDate.getTime();
                long daysLate = (diff / (1000 * 60 * 60 * 24)) - borrowingPeriodDays;
                if (daysLate > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

