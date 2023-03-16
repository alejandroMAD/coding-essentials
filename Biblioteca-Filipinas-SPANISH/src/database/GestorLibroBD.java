package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;

/**
 * La clase GestorLibroBD gestiona las interacciones con la tabla `libro` en la
 * base de datos. Proporciona métodos para crear, obtener, actualizar y borrar
 * registros de libros, que son mapeados a objetos Libro como en un framework ORM.
 * 
 * (Los métodos de creación y eliminación no se incluyen en el código fuente por
 * no ser necesarios para la solución propuesta en el proyecto).
 * 
 * @author Alejandro M. González
 */
public class GestorLibroBD {

    /**
     * Obtiene una lista de todos los registros en la tabla `libro` de la base de datos.
     * @return Una lista de objetos Libro que representa todos los libros en la base de datos.
     * @throws SQLException si se produce un error en el acceso a la base de datos.
     */
    public static List<Libro> getLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro";

        try (Connection connection = ConexionBD.getDBConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt("libro_id"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getInt("fecha_edicion"),
                        rs.getString("editor"), rs.getString("ISBN"),
                        rs.getInt("numero_paginas"), rs.getBoolean("disponible"));

                libros.add(libro);
            }
        }

        return libros;
    }

    /**
     * Encuentra un libro en la base de datos por su identificador único o ID.
     * @param  id El identificador único o ID del libro buscado.
     * @return el objeto Libro al que corresponde el ID, o null si no es encontrado.
     */
    public static Libro getLibroPorId(int id) {
    	Libro libro = null;
    	String query = "SELECT * FROM libro WHERE libro_id = ?";
    	
        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                libro = new Libro(rs.getInt("libro_id"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getInt("fecha_edicion"),
                        rs.getString("editor"), rs.getString("ISBN"),
                        rs.getInt("numero_paginas"), rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return libro;
    }

    /**
     * Obtiene una lista de libros de la base de datos cuyo autor coincide
     * con el autor especificado.
     * @param  autor El nombre del autor del libro.
     * @return Una lista de objetos Libro del autor especificado.
     */
    public static List<Libro> getBooksByAuthor(String autor) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro WHERE autor = ?";

        try (Connection conexion = ConexionBD.getDBConnection();
             PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, autor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt("libro_id"), rs.getString("titulo"),
                        rs.getString("autor"), rs.getInt("fecha_edicion"),
                        rs.getString("editor"), rs.getString("ISBN"),
                        rs.getInt("numero_paginas"), rs.getBoolean("disponible"));

                libros.add(libro);
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}

        return libros;
    }

    /**
     * Obtiene el valor booleano de disponibilidad de un libro de la base de datos
     * por su ID.
     * @param  libroId El ID del libro cuya disponibilidad es consultada.
     * @return true si el libro está disponible (no está prestado), false en caso contrario.
     */
    public static boolean getDisponibilidadLibro(int libroId) {
        boolean disponible = false;
        String query = "SELECT disponible FROM libro WHERE libro_id = ?"; 
        
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, libroId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    disponible = rs.getBoolean("disponible");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return disponible;
    }
    
    /**
     * Actualiza el valor booleano de disponibilidad de un libro en la base de datos
     * con el ID especificado, estableciendo su estado según el valor pasado como argumento.
     * @param libroId        El ID del libro cuya disponibilidad es objeto de la actualización.
     * @param disponibilidad El nuevo estado de disponibilidad del libro.
     */
    public static void setDisponibilidadLibro(int libroId, boolean disponibilidad) {
    	String query = "UPDATE libro SET disponible = ? WHERE libro_id = ?";
        try (Connection conexion = ConexionBD.getDBConnection();
    		 PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setBoolean(1, disponibilidad);
            statement.setInt(2, libroId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

