package com.jdbc.main;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.jdbc.utility.JDBCUtility;

public class LaunchJDBCFetch {
	public static void main(String[] args) {

		Connection connect = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Scanner sc = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				String query = "Select * from studentDetail where ID=?";
				statement = connect.prepareStatement(query);
			}
			if (statement != null) {
				sc = new Scanner(System.in);
				System.out.println("Welcome to my world");
				System.out.println();

				System.out.println("Please enter the ID:-");
				int id = sc.nextInt();

				statement.setInt(1, id);
				result = statement.executeQuery();
				System.out.println("ID\tName\tAge\tGender");
				while (result.next()) {
					System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getInt(3) + "\t"
							+ result.getString(4));
				}

			}

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Duplicate ID provided");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtility.closeResources(connect, statement, null);
		}

	}

}
