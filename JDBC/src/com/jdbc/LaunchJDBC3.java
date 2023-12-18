package com.jdbc;
import java.sql.*;
//revision
public class LaunchJDBC3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// build connection 
		String url ="jdbc:mysql://localHost:3306/DEV";
		String user="root";
		String password="admin@123";
		
		Connection connect = DriverManager.getConnection(url, user, password);
		
		
		// write statement
		Statement statement = connect.createStatement();
		
		//execute query
		ResultSet result = statement.executeQuery("select * from studentDetail");
		System.out.println("ID\tName\tAge\tGender");
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+
		      result.getInt(3)+"\t"+result.getString(4));
		}
		
		result.close();
		statement.close();
		connect.close();	
		
	}
}
