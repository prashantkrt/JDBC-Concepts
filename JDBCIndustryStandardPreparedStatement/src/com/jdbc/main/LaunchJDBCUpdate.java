package com.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.jdbc.utility.JDBCUtility;

public class LaunchJDBCUpdate {
	public static void main(String[] args) {

		Connection connect = null;
		PreparedStatement statement = null;
		Scanner sc = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				String query = "update studentDetail set Name=? where ID=?";
				statement = connect.prepareStatement(query);
			}
			if (statement != null) {
				
				sc = new Scanner(System.in);
				System.out.println("Welcome to my Application");
				System.out.println();

				System.out.println("Enter your name name to be updated");
				String name = sc.next();				

				System.out.println("Please enter the ID:-");
				int id = sc.nextInt();
				
				
				statement.setInt(2, id);
				statement.setString(1, name);
				
				int noOfRowsAffected = statement.executeUpdate();
				if (noOfRowsAffected != 0) {
					System.out.println("Updation successfull!!");
				} else {
					System.out.println("Failed to update");
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
		      if(sc!=null)
		    	 sc.close();
		}
	}
}
