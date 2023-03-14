package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Libro;

/**
 * The `DbBookManager` class handles the interaction with the book table in the database,
 * It provides methods for retrieving, creating, updating, and deleting books, mapped to
 * Book objects in an ORM-fashion.
 * 
 * @author Alejandro M. González
 */
public class GestorLibroBD {

    /**
     * Get a list of all books in the book table from the database.
     * @return A list of Book objects representing all the books in the database.
     */
    public static List<Libro> getAllBooks() throws SQLException {
        List<Libro> books = new ArrayList<>();
        String query = "SELECT * FROM book";

        try (Connection connection = ConexionBD.getDBConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Libro book = new Libro(rs.getInt("book_id"), rs.getString("title"),
                        rs.getString("author"), rs.getInt("publication_year"),
                        rs.getString("publisher"), rs.getString("ISBN"),
                        rs.getInt("number_of_pages"), rs.getBoolean("available"));

                books.add(book);
            }
        }

        return books;
    }

    /**
     * Get a book from the database by its ID.
     * @param  id The ID of the book.
     * @return The Book object with the given ID, or null if not found.
     */
    public static Libro getBookById(int id) {
    	Libro book = null;
    	String query = "SELECT * FROM book WHERE book_id = ?";
    	
        try (Connection connection = ConexionBD.getDBConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                book = new Libro(rs.getInt("book_id"), rs.getString("title"),
                        rs.getString("author"), rs.getInt("publication_year"),
                        rs.getString("publisher"), rs.getString("ISBN"),
                        rs.getInt("number_of_pages"), rs.getBoolean("available"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
    }

    /**
     * Gets a list of books from the database by the author's name.
     * @param  author The author's name.
     * @return A list of Book objects by the given author.
     */
    public static List<Libro> getBooksByAuthor(String author) {
        List<Libro> books = new ArrayList<>();
        String query = "SELECT * FROM book WHERE author = ?";

        try (Connection connection = ConexionBD.getDBConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Libro book = new Libro(rs.getInt("book_id"), rs.getString("title"),
                        rs.getString("author"), rs.getInt("publication_year"),
                        rs.getString("publisher"), rs.getString("ISBN"),
                        rs.getInt("number_of_pages"), rs.getBoolean("available"));

                books.add(book);
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}

        return books;
    }

    /**
     * Get the available boolean status of a book from the database by its book ID
     * @return true if the book is available (not borrowed), false otherwise
     */
    public static boolean getBookAvailability(int bookId) {
        boolean available = false;
        String query = "SELECT available FROM book WHERE book_id = ?"; 
        
        try (Connection conn = ConexionBD.getDBConnection();
    		 PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    available = rs.getBoolean("available");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return available;
    }
    
    /**
    * Updates the available boolean status of a book with the given bookId in the database.
    * @param bookId       The id of the book to update the availability of.
    * @param availability The new availability value to set for the book.
    */
    public static void setBookAvailability(int bookId, boolean availability) {
    	String query = "UPDATE book SET available = ? WHERE book_id = ?";
        try (Connection connection = ConexionBD.getDBConnection();
    		 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1, availability);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

