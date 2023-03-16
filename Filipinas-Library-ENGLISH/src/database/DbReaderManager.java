package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Reader;

/**
 * The `DbReaderManager` class handles the database operations related to the entries
 * in the reader table mapped to Reader objects in an ORM-fashion.
 * 
 * (Methods for creation and deletion of books are not provided because they are not
 * required by the project requirements).
 * 
 * @author Alejandro M. González
 */
public class DbReaderManager {

    /**
     * Gets all the readers in the reader table from the database.
     * @return A list of Reader objects representing all the readers in the database.
     */
    public static List<Reader> getAllReaders() {
        List<Reader> readers = new ArrayList<>();
        String query = "SELECT * FROM reader";
        
        try (Connection dbConnection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = dbConnection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Reader reader = new Reader();
                reader.setReaderId(resultSet.getInt("reader_id"));
                reader.setFirstName(resultSet.getString("first_name"));
                reader.setLastName(resultSet.getString("last_name"));
                reader.setEmail(resultSet.getString("email"));
                reader.setPhoneNumber(resultSet.getString("phone_number"));
                reader.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                reader.setBorrowedBooks(resultSet.getInt("borrowed_books"));
                reader.setPenaltyCount(resultSet.getInt("penalty_count"));
                readers.add(reader);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readers;
    }

    /**
     * Gets a Reader object retrieving its information from the database by its readerId.
     * @param  readerId The id of the reader to retrieve.
     * @return A Reader object representing the reader with the given readerId, or null if no such reader exists.
     */
    public static Reader getReaderById(int readerId) {
        Reader reader = null;
        String query = "SELECT * FROM reader WHERE reader_id = ?";
        
        try (Connection dbConnection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setInt(1, readerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reader = new Reader();
                reader.setReaderId(resultSet.getInt("reader_id"));
                reader.setFirstName(resultSet.getString("first_name"));
                reader.setLastName(resultSet.getString("last_name"));
                reader.setEmail(resultSet.getString("email"));
                reader.setPhoneNumber(resultSet.getString("phone_number"));
                reader.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                reader.setBorrowedBooks(resultSet.getInt("borrowed_books"));
                reader.setPenaltyCount(resultSet.getInt("penalty_count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reader;
    }
    
    /**
     * Returns the count of the number of books borrowed by a reader.
     * @param  readerId the ID of the reader
     * @return the number of books borrowed by the reader
     */
    public static int getReaderBorrowedBooks(int readerId) {
        int borrowedBooks = 0;
        String query = "SELECT borrowed_books FROM reader WHERE reader_id = ?";
        
        try (Connection connection = DatabaseConnection.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, readerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                borrowedBooks = resultSet.getInt("borrowed_books");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowedBooks;
    }
    
    /**
     * Updates the number of books borrowed by a reader with an increment
     * or decrement by the positive or negative integer passed as argument
     * @param readerId the ID of the reader
     * @param delta the change, increment or decrement in the number of borrowed books
     */
    public static void updateReaderBorrowedBooks(int readerId, int delta) {
    	String query = "UPDATE reader SET borrowed_books = borrowed_books + ? WHERE reader_id = ?";
    	
    	try (Connection connection = DatabaseConnection.getDBConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, delta);
            statement.setInt(2, readerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Gets the penalty days count of a reader given their reader ID.
     * @param  readerId the ID of the reader
     * @return the penalty days count of the reader
     */
    public static int getReaderPenaltyCount(int readerId) {
        int penaltyCount = 0;
        String query = "SELECT penalty_count FROM reader WHERE reader_id = ?";
        
        try (Connection dbConnection = DatabaseConnection.getDBConnection();
    		 PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setInt(1, readerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                penaltyCount = resultSet.getInt("penalty_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penaltyCount;
    }

    /**
     * Updates the penalty days count of a reader given their reader ID.
     * @param readerId     the ID of the reader
     * @param delta the change, increment or decrement in the penalty count of the reader
     */
    public static void updateReaderPenaltyCount(int readerId, int delta) {
        String query = "UPDATE reader SET penalty_count = penalty_count + ? WHERE reader_id = ?";
        
        try (Connection dbConnection = DatabaseConnection.getDBConnection();
    		 PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setInt(1, delta);
            statement.setInt(2, readerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

