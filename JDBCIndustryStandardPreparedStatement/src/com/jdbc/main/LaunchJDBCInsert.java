package com.jdbc.main;

import java.sql.*;
import java.util.Scanner;

import com.jdbc.utility.JDBCUtility;

public class LaunchJDBCInsert {
	public static void main(String[] args) {

		Connection connect = null;
		PreparedStatement statement = null;
		Scanner sc = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				String query = "insert into studentDetail(ID,Name,Age,Gender)" + "values(?,?,?,?)";
				statement = connect.prepareStatement(query);
			}
			if (statement != null) {
				sc = new Scanner(System.in);
				System.out.println("Welcome to my world");
				System.out.println();

				System.out.println("Please enter the ID:-");
				int id = sc.nextInt();

				System.out.println("Enter your name:-");
				String name = sc.next();

				System.out.println("Enter the age");
				int age = sc.nextInt();

				System.out.println("Enter the gender");
				String gender = sc.next();

				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setInt(3, age);
				statement.setString(4, gender);

				int noOfRowsAffected = statement.executeUpdate();
				if (noOfRowsAffected != 0) {
					System.out.println("Registration successfull!!");
				} else {
					System.out.println("Failed to register");
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
