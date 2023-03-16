package database;

import java.sql.*;
import java.util.*;

import model.Book;
import model.Borrowing;
import model.Reader;

/**
 * The `DbBorrowingManager` class provides methods for interacting with the database
 * to manage borrowings of books from the borrowing table mapped to Borrowing objects
 * in an ORM-fashion.
 * 
 * The class uses a connection to a MySQL database to execute SQL statements on the
 * `borrowing` table, which stores information about each borrowing, including the
 * borrower reader, the book borrowed, the date borrowed, the return date, and 
 * the overdue penalty for late returns.
 * 
 * The methods in this class use try-with-resources syntax to instantiate a
 * `Connection` object and execute the SQL statements within the try block
 * while conveniently autoclosing the resources after using them.
 * 
 * To use the `DbBorrowingManager` class, you must have a MySQL database running and
 * accessible from your Java application. You must also have the appropriate database
 * driver installed and available on the classpath.
 * 
 * @author Alejandro M. González
 */

public class DbBorrowingManager {

    /**
     * Retrieves all borrowings from the borrowing table in the database.
     * @return a list of Borrowing objects representing all the borrowings in the database.
     * @throws SQLException if there is an error executing the SQL query.
     */
    public static List<Borrowing> getAllBorrowings() throws SQLException {
        List<Borrowing> borrowings = new ArrayList<>();
        String query = "SELECT * FROM borrowing";
        
        try (Connection connection = DatabaseConnection.getDBConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Borrowing borrowing = new Borrowing();
                borrowing.setBorrowingId(resultSet.getInt("borrowing_id"));

                Book borrowedBook = DbBookManager.getBookById(resultSet.getInt("book_id"));
                borrowing.setBook(borrowedBook);
                Reader borrowingReader = DbReaderManager.getReaderById(resultSet.getInt("reader_id"));
                borrowing.setReader(borrowingReader);

                borrowing.setBorrowingDate(resultSet.getTimestamp("borrowing_date"));
                borrowing.setReturnDate(resultSet.getTimestamp("return_date"));
                borrowing.setOverduePenalty(resultSet.getInt("overdue_penalty"));
                borrowings.add(borrowing);
            }
        } 
        return borrowings;
    }

    /**
     * Retrieves all borrowings by a specific reader from the borrowing table in the database.
     * @param readerId the id of the reader whose borrowings are to be retrieved.
     * @return a list of Borrowing objects representing the borrowings by the specified reader.
     */
    public static List<Borrowing> getBorrowingsByReaderId(int readerId) {
        List<Borrowing> borrowings = new ArrayList<>();
        String query = "SELECT * FROM borrowing WHERE reader_id = ?";
        
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, readerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Borrowing borrowing = new Borrowing();
                    borrowing.setBorrowingId(resultSet.getInt("borrowing_id"));

                    Book borrowedBook = DbBookManager.getBookById(resultSet.getInt("book_id"));
                    borrowing.setBook(borrowedBook);
                    Reader borrowingReader = DbReaderManager.getReaderById(resultSet.getInt("reader_id"));
                    borrowing.setReader(borrowingReader);

                    borrowing.setBorrowingDate(resultSet.getTimestamp("borrowing_date"));
                    borrowing.setReturnDate(resultSet.getTimestamp("return_date"));
                    borrowing.setOverduePenalty(resultSet.getInt("overdue_penalty"));
                    borrowings.add(borrowing);
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return borrowings;
    }
 
    /**
     * Returns the borrowing ID for the given book ID and reader ID.
     * This methods queries the database and retrieves the most recent
     * borrowing ID matching the specified book and reader, in order to
     * dismiss other past borrowings of the same book and reader.
     * @param bookId the ID of the book borrowed
     * @param readerId the ID of the borrower reader
     * @return the ID of the last borrowing for the given book ID and reader ID, or -1 if not found
     */
    public static int getBorrowingId(int bookId, int readerId) {
        String query = "SELECT borrowing_id FROM borrowing " 
        				+ "WHERE book_id = ? AND reader_id = ? " 
        				+ "ORDER BY borrowing_id DESC LIMIT 1";
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.setInt(2, readerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("borrowing_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    /**
     * Creates a new borrowing record in the database for the specified book and reader, with the given borrowing date.
     * @param bookId the id of the book being borrowed
     * @param readerId the id of the reader borrowing the book
     * @param borrowingDate the timestamp of the moment the book is being borrowed
     * @return true if the borrowing was successfully created, false otherwise
     */
    public static boolean createBorrowing(int bookId, int readerId, Timestamp borrowingDate) {
        try (Connection connection = DatabaseConnection.getDBConnection();
    		 PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO borrowing (book_id, reader_id, borrowing_date) VALUES (?, ?, ?)")) {
            statement.setInt(1, bookId);
            statement.setInt(2, readerId);
            statement.setTimestamp(3, borrowingDate);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves the borrowing date for the borrowing record with the specified id.
     * @param borrowingId the id of the borrowing record to retrieve the date for
     * @return the borrowing date as a Timestamp object, or null if the borrowing record is not found
     */
    public static Timestamp getBorrowingDate(int borrowingId) {
        try (Connection connection = DatabaseConnection.getDBConnection();
    		 PreparedStatement statement = connection.prepareStatement(
                "SELECT borrowing_date FROM borrowing WHERE borrowing_id = ?")) {
            statement.setInt(1, borrowingId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getTimestamp("borrowing_date");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates the borrowing date for the borrowing record with the specified id.
     * @param borrowingId the id of the borrowing record to update
     * @param borrowingDate the new borrowing date to set
     */
    public static void setBorrowingDate(int borrowingId, Timestamp borrowingDate) {
        try (Connection connection = DatabaseConnection.getDBConnection();
    		 PreparedStatement statement = connection.prepareStatement(
                "UPDATE borrowing SET borrowing_date = ? WHERE borrowing_id = ?")) {
            statement.setTimestamp(1, borrowingDate);
            statement.setInt(2, borrowingId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves the return date of a borrowing by borrowing ID
     * @param borrowingId the ID of the borrowing
     * @return the return date of the borrowing, or null if not found
     */
    public static Timestamp getBorrowingReturnDate(int borrowingId) {
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT return_date FROM borrowing WHERE borrowing_id = ?")) {
            statement.setInt(1, borrowingId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("return_date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Sets the return date of a borrowing by borrowing ID
     *
     * @param borrowingId the ID of the borrowing
     * @param returnDate  the return date to set
     * @return true if the return date was set successfully, false otherwise
     */
    public static boolean setBorrowingReturnDate(int borrowingId, Timestamp returnDate) {
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE borrowing SET return_date = ? WHERE borrowing_id = ?")) {
            statement.setTimestamp(1, returnDate);
            statement.setInt(2, borrowingId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Sets the overdue penalty associated with a borrowing by borrowing ID
     * The penalty in days for late returns depends on the library rules
     * @param borrowingId    the ID of the borrowing
     * @param overduePenalty the overdue penalty to set
     */
    public static void setBorrowingOverduePenalty(int borrowingId, int overduePenalty) {
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE borrowing SET overdue_penalty = ? WHERE borrowing_id = ?")) {
            statement.setInt(1, overduePenalty);
            statement.setInt(2, borrowingId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

