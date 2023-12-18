package com.jdbc;

import java.sql.*;

public class LaunchJDBC2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create connection
		String url ="jdbc:mysql://localHost:3306/DEV";
		String userName="root";
		String password ="admin@123";
		
		Connection connect = DriverManager.getConnection(url,userName,password);
		
		//create statement		
		Statement statement = connect.createStatement();
		
		//execute query
		String query = "Insert into studentDetail values(23,'Karan',20,'M')";
		int rowAffected = statement.executeUpdate(query);
		
		System.out.println(rowAffected);
		
		
		statement.close();
		connect.close();
		
		
		
		
	}
}
