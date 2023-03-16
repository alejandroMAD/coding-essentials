package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase ConexionBD proporciona el método estático para establecer una
 * conexión a la base de datos de la biblioteca, que es invocado por las
 * clases específicas de gestión de la información de la base de datos.
 * 
 * @author Alejandro M. González
 */
public class ConexionBD {

    // Driver para la base de datos MySQL, ruta y credenciales de acceso
	// Se asume el uso de la configuración por defecto de una base de datos en servidor local MySQL
    private static final String DRIVER_DB = "com.mysql.cj.jdbc.Driver";
    private static final String RUTA_DB = "jdbc:mysql://localhost:3306/biblioteca_filipinas";
    private static final String USUARIO_DB = "root";
    private static final String CONTRASEÑA_DB = "";

    /**
     * Método estático que establece la conexión a la base de datos de
     * la biblioteca, que es invocado por las clases específicas de gestión
     * de la información de la base de datos.
     * @return un objeto Connection de conexión a la base de datos
     */
    public static Connection getDBConnection() {
        Connection connectionDb = null;
        try {
            Class.forName(DRIVER_DB);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connectionDb = DriverManager.getConnection(RUTA_DB, USUARIO_DB, CONTRASEÑA_DB);
            return connectionDb;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionDb;
    }
}

