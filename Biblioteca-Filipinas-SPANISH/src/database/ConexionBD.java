package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnection class provides a static method to establish a connection 
 * to the library database to be used by the specific database managing classes.
 * 
 * @author Alejandro M. González
 */
public class ConexionBD {

    // Driver for the MySQL database, path and credentials.
	// Default MySQL configurations and a local database server are assumed for this program
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_PATH = "jdbc:mysql://localhost:3306/filipinas_library";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    /**
     * Static method which establishes a connection to the library database
     * to be used by the specific database managing classes
     * @return a connection object to the library database
     */
    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

