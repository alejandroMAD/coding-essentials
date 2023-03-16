package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import modelo.Lector;

/**
 * La clase GestorLectorBD gestiona las interacciones con la tabla `lector` en la
 * base de datos. Proporciona métodos para crear, obtener, actualizar y borrar
 * registros de lectores, que son mapeados a objetos Lector como en un framework ORM.
 * 
 * (Los métodos de creación y eliminación no se incluyen en el código fuente por
 * no ser necesarios para la solución propuesta en el proyecto).
 * 
 * @author Alejandro M. González
 */
public class GestorLectorBD {

    /**
     * Obtiene una lista con todos los lectores de la tabla `lector` de la base de datos.
     * @return Una lista de objetos Lector que representa todos los lectores en la base de datos.
     */
    public static List<Lector> getLectores() {
        List<Lector> lectores = new ArrayList<>();
        String query = "SELECT * FROM lector";
        
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Lector lector = new Lector();
                lector.setLectorId(resultSet.getInt("lector_id"));
                lector.setNombre(resultSet.getString("nombre"));
                lector.setApellido(resultSet.getString("apellido"));
                lector.setEmail(resultSet.getString("email"));
                lector.setTelefono(resultSet.getString("telefono"));
                lector.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
                lector.setLibrosPrestados(resultSet.getInt("libros_prestados"));
                lector.setDiasPenalizacion(resultSet.getInt("dias_penalizacion"));
                lectores.add(lector);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lectores;
    }

    /**
     * Obtiene un objeto Lector recuperando los datos de un registro de lector
     * de la base de datos a partir del ID del lector.
     * @param  lectorId El ID del lector buscado.
     * @return un objeto Lector que representa al lector cuyo identificador coincide
     *         con el ID especificado, o null si no se encuentra el lector.
     */
    public static Lector getLectorPorId(int lectorId) {
        Lector lector = null;
        String query = "SELECT * FROM lector WHERE lector_id = ?";
        
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lectorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lector = new Lector();
                lector.setLectorId(resultSet.getInt("lector_id"));
                lector.setNombre(resultSet.getString("nombre"));
                lector.setApellido(resultSet.getString("apellido"));
                lector.setEmail(resultSet.getString("email"));
                lector.setTelefono(resultSet.getString("telefono"));
                lector.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
                lector.setLibrosPrestados(resultSet.getInt("libros_prestados"));
                lector.setDiasPenalizacion(resultSet.getInt("dias_penalizacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lector;
    }
    
    /**
     * Devuelve el número de libros que tiene en préstamo el lector especificado.
     * @param  lectorId el ID del lector.
     * @return el número de libros que tiene en préstamo el lector especificado.
     */
    public static int getLibrosPrestados(int lectorId) {
        int librosPrestados = 0;
        String query = "SELECT libros_prestados FROM lector WHERE lector_id = ?";
        
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lectorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                librosPrestados = resultSet.getInt("libros_prestados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return librosPrestados;
    }
    
    /**
     * Actualiza el contador de libros prestados de un lector con un incremento
     * o disminución según el entero positivo o negativo pasado como argumento.
     * @param lectorId el ID del lector.
     * @param delta el incremento o disminución del número de libros prestados.
     */
    public static void actualizarLibrosPrestados(int lectorId, int delta) {
    	String query = "UPDATE lector SET libros_prestados = libros_prestados + ? WHERE lector_id = ?";
    	
    	try (Connection conexion = ConexionBD.getDBConnection();
	         PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, delta);
            statement.setInt(2, lectorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Obtiene el contador de días de penalización del lector de ID especificado.
     * @param  lectorId el ID del lector.
     * @return el contador de días de penalización del lector.
     */
    public static int getDiasPenalizacion(int lectorId) {
        int diasPenalizacion = 0;
        String query = "SELECT dias_penalizacion FROM lector WHERE lector_id = ?";
        
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, lectorId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                diasPenalizacion = resultSet.getInt("dias_penalizacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diasPenalizacion;
    }

    /**
     * Actualiza el contador de días de penalización del lector de ID especificado con 
     * un incremento o disminución según el entero positivo o negativo pasado como argumento.
     * @param lectorId     el ID del lector.
     * @param delta el incremento o disminución de los días de penalización del lector.
     */
    public static void actualizarDiasPenalizacion(int lectorId, int delta) {
        String query = "UPDATE lector SET dias_penalizacion = dias_penalizacion + ? WHERE lector_id = ?";
        
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, delta);
            statement.setInt(2, lectorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

