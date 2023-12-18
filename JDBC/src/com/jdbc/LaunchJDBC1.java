package com.jdbc;

import java.sql.*;

public class LaunchJDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load and register the java application
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is registered");		
		
		//establish the connection		
		String url = "jdbc:mysql://localhost:3306/DEV";
		String userName ="root";
		String password ="admin@123";
		//constructor is not visible
//		DriverManager dm = new DriverManager();
 
		Connection connect = DriverManager.getConnection(url,userName,password);
		System.out.println("Connection established !!");
		
		//creating the statement
		Statement statement = connect.createStatement();
		System.out.println("Statement object created !!");		
		
		String query = "select * from studentDetail;";
		//executing the query and storing in the resultSet
		ResultSet result = statement.executeQuery(query);
		System.out.println("We have the resultset ready");
		
		System.out.println("ID\tName\tAge\tGender");
	    while (result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+
					"\t"+ result.getInt(3)+"\t"+result.getString(4));			
		}
	    result.close();
	    statement.close();
	    connect.close();		
	}
}
