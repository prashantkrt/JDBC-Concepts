package com.jdbc.main;

import java.sql.*;

import com.jdbc.util.JDBCUtility;

public class JDBCUtilityCall2 {
	public static void main(String[] args) {
		// resources
		// establish the connect 
		// interfaces 
		Connection connect = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			connect = JDBCUtility.getDBConnection();
			if(connect!=null) {
			statement = connect.createStatement();
			}
			if(statement!=null) {
			result = statement.executeQuery("select * from studentDetail");	
			}
			if(result!=null) {
			  System.out.println("ID\tName\tAge\tGender");
			  while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+
						"\t"+ result.getInt(3)+"\t"+result.getString(4));			
			  }
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		finally {
			JDBCUtility.closeResources(connect, statement, result);
		}		
	}
}
