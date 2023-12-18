package com.jdbc.main;

import java.sql.*;

import com.jdbc.util.JDBCUtility;

public class JDBCUtilityCall {
	public static void main(String[] args) {
		// resources
		// establish the connect
		// interfaces
		Connection connect = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				statement = connect.createStatement();
			}
			if (statement != null) {

				// for selected query the status will be true like select query
				// for non-selected query the status will be false like for update, delete etc
				boolean status = statement.execute("select * from studentDetail");
				if (status) {
					result = statement.getResultSet();

					if (result != null) {
						System.out.println("ID\tName\tAge\tGender");

						while (result.next()) {
							System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getInt(3)
									+ "\t" + result.getString(4));
						}
					}
				} 
				else {
					int rowsAffected = statement.getUpdateCount();
					System.out.println(rowsAffected);
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
