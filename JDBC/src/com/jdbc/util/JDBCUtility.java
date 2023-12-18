package com.jdbc.util;

import java.sql.*;

public class JDBCUtility{
	
	static 
	{
		try 
		{		
			Class.forName("com.mysql.cj.jdbc.Driver");			
		}
		catch(ClassNotFoundException e)		
		{
			e.printStackTrace();
		}		
	}
	
	public static Connection getDBConnection()
	{
		String url = "jdbc:mysql://localHost:3306/Dev";
		String user="root";
		String password="admin@123";
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return connect;		
	}
	
	public static void closeResources(Connection con, Statement statement, ResultSet st)
	{
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}	
		}
	}
}
