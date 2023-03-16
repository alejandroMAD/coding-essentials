package database;

import java.sql.*;

/**
 * This class provides static methods to manage the library data and rules in the database.
 * 
 * @author Alejandro M. González
 */
public class DbLibraryManager {

	/**
	 * Retrieves the maximum number of borrowings allowed from the rules in the library table.
	 * @return an integer representing the maximum number of borrowings allowed.
	 */
	public static int getMaxBorrowings() {
		int maxBorrowings = 0;
		String query = "SELECT max_borrowings FROM library";
		
		try (Connection connection = DatabaseConnection.getDBConnection();
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				maxBorrowings = resultSet.getInt("max_borrowings");
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving max_borrowings from the library table.");
		}
		return maxBorrowings;
	}

	/**
	 * Retrieves the borrowing period in days from the rules in the library table.
	 * @return an integer representing the borrowing period in days.
	 */
	public static int getBorrowingPeriodDays() {
		int borrowingPeriodDays = 0;
		String query = "SELECT borrowing_period_days FROM library";
		
		try (Connection connection = DatabaseConnection.getDBConnection();
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				borrowingPeriodDays = resultSet.getInt("borrowing_period_days");
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving borrowing_period_days from the library table.");
		}
		return borrowingPeriodDays;
	}

	/**
	 * Retrieves the late return penalty period in days from the library.
	 * @return an integer representing the late return penalty period in days.
	 */
	public static int getLateReturnPenaltyDays() {
		int lateReturnPenaltyDays = 0;
		String query = "SELECT late_return_penalty_days FROM library";
		
		try (Connection connection = DatabaseConnection.getDBConnection();
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				lateReturnPenaltyDays = resultSet.getInt("late_return_penalty_days");
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving late_return_penalty_days from the library table.");
		}
		return lateReturnPenaltyDays;
	}

	/**
	 * Sets the maximum number of borrowings that a reader can have at once.
	 * @param maxBorrowings the new maximum number of borrowings allowed per reader
	 */
	public static void setMaxBorrowings(int maxBorrowings) {
		String query = "UPDATE library SET max_borrowings = ?";
		
	    try (Connection conn = DatabaseConnection.getDBConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, maxBorrowings);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error updating the max_borrowings value in the library table.");
	        e.printStackTrace();
	    }
	}

	/**
	 * Sets the borrowing period in days for each library book borrowing.
	 * @param borrowingPeriodDays the new borrowing period in days per library book
	 */
	public static void setBorrowingPeriodDays(int borrowingPeriodDays) {
		String query = "UPDATE library SET borrowing_period_days = ?";
		
	    try (Connection conn = DatabaseConnection.getDBConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, borrowingPeriodDays);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error updating borrowing_period_days in the library table.");
	        e.printStackTrace();
	    }
	}

	/**
	 * Sets the penalty in number of days of suspension for readers with overdue items.
	 * @param lateReturnPenaltyDays the new penalty in number of days for late returns
	 */
	public static void setLateReturnPenaltyDays(int lateReturnPenaltyDays) {
		String query = "UPDATE library SET late_return_penalty_days = ?";
		
	    try (Connection conn = DatabaseConnection.getDBConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, lateReturnPenaltyDays);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	    	System.err.println("Error updating late_return_penalty_days in the library table.");
	        e.printStackTrace();
	    }
	}
}
