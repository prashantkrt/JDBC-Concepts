package com.jdbc.main;

import java.sql.*;
import com.jdbc.util.JDBCUtility;

public class LaunchMainBatch {
	public static void main(String[] args) {

		// Resources needed
		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				String query = "Update studentDetail set Name=? where ID=?";
				statement = connect.prepareStatement(query);
			}
			if (statement != null) {

				statement.setString(1, "Kumar");
				statement.setInt(2, 1);
				statement.addBatch();
				statement.setString(1, "Rajni");
				statement.setInt(2, 0);
				statement.addBatch();
				statement.setString(1, "Suraj");
				statement.setInt(2, 3);

				int[] rowsAffected = statement.executeBatch();
				if (rowsAffected.length != 0) {
					System.out.print("Number of rows updated successfully :-  ");
					System.out.print(rowsAffected.length);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtility.closeResources(connect, statement, result);
		}
	}

}
