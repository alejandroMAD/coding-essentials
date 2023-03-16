package database;

import java.sql.*;

/**
 * Esta clase proporciona métodos estáticos para gestionar la información
 * y reglas de funcionamiento de la biblioteca en la base de datos.
 * 
 * @author Alejandro M. González
 */
public class GestorBibliotecaBD {

	/**
	 * Obtiene el número máximo de préstamos simultáneos permitidos de las reglas
	 * en la tabla `biblioteca` de la base de datos.
	 * @return un entero que representa el número máximo de préstamos simultáneos permitidos.
	 */
	public static int getPrestamosSimultaneos() {
		int prestamosSimultaneos = 0;
		String query = "SELECT prestamos_simultaneos FROM biblioteca";
		
		try (Connection conexion = ConexionBD.getDBConnection();
			 PreparedStatement statement = conexion.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				prestamosSimultaneos = resultSet.getInt("prestamos_simultaneos");
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener prestamos_simultaneos de la tabla `biblioteca`");
		}
		return prestamosSimultaneos;
	}

	/**
	 * Obtiene el periodo máximo en días de un préstamo de las reglas en la tabla
	 * `biblioteca` de la base de datos.
	 * @return un entero que representa el periodo máximo de días de un préstamo.
	 */
	public static int getDiasPrestamo() {
		int diasPrestamo = 0;
		String query = "SELECT dias_prestamo FROM biblioteca";
		
		try (Connection conexion = ConexionBD.getDBConnection();
			 PreparedStatement statement = conexion.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				diasPrestamo = resultSet.getInt("dias_prestamo");
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener dias_prestamo de la tabla `biblioteca`");
		}
		return diasPrestamo;
	}

	/**
	 * Obtiene el número de días de penalización por devolución tardía de
	 * las reglas en la tabla `biblioteca` de la base de datos.
	 * @return un entero que representa los días de penalización por devolución tardía.
	 */
	public static int getDiasPenalizacion() {
		int diasPenalizacion = 0;
		String query = "SELECT dias_penalizacion FROM biblioteca";
		
		try (Connection conexion = ConexionBD.getDBConnection();
			 PreparedStatement statement = conexion.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				diasPenalizacion = resultSet.getInt("dias_penalizacion");
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener dias_penalizacion de la tabla `biblioteca`");
		}
		return diasPenalizacion;
	}

	/**
	 * Establece el número máximo de préstamos que un lector puede disfrutar simultáneamente.
	 * @param prestamosSimultaneos el nuevo número máximo de préstamos
	 *                             simultáneos por lector permitidos.
	 */
	public static void setPrestamosSimultaneos(int prestamosSimultaneos) {
		String query = "UPDATE biblioteca SET prestamos_simultaneos = ?";
		
	    try (Connection conexion = ConexionBD.getDBConnection();
	         PreparedStatement statement = conexion.prepareStatement(query)) {
	        statement.setInt(1, prestamosSimultaneos);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar prestamos_simultaneos en la tabla `biblioteca`");
	        e.printStackTrace();
	    }
	}

	/**
	 * Establece el periodo máximo en días de un préstamo de la biblioteca.
	 * @param diasPrestamo el nuevo periodo máximo en días de un préstamo de la biblioteca.
	 */
	public static void setDiasPrestamo(int diasPrestamo) {
		String query = "UPDATE biblioteca SET dias_prestamo = ?";
		
	    try (Connection conexion = ConexionBD.getDBConnection();
	         PreparedStatement statement = conexion.prepareStatement(query)) {
	        statement.setInt(1, diasPrestamo);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar dias_prestamo en la tabla `biblioteca`");
	        e.printStackTrace();
	    }
	}

	/**
	 * Establece el número de días de penalización por devolución tardía de un libro
	 * en las reglas de la biblioteca almacenadas en la base de datos.
	 * @param diasPenalizacion el nuevo número de días de penalización por devolución tardía.
	 */
	public static void setDiasPenalizacion(int diasPenalizacion) {
		String query = "UPDATE biblioteca SET dias_penalizacion = ?";
		
	    try (Connection conexion = ConexionBD.getDBConnection();
	         PreparedStatement statement = conexion.prepareStatement(query)) {
	        statement.setInt(1, diasPenalizacion);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error al actualizar dias_penalizacion en la tabla `biblioteca`");
	        e.printStackTrace();
	    }
	}
}
