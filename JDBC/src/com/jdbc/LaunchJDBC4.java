package com.jdbc;

import java.sql.*;

//update the table 

public class LaunchJDBC4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load and register
		Class.forName("com.mysql.cj.jdbc.Driver");

		// establish connection
		String url = "jdbc:mysql://localHost:3306/DEV";
		String user = "root";
		String password = "admin@123";

		Connection connect = DriverManager.getConnection(url, user, password);

		// create the statement
		Statement statement = connect.createStatement();

		// execute query
		String query = "update studentDetail set ID=891 where ID=2";
//		String query1 = "delete from studentDetail ID=891";

		int noOfUpdates = statement.executeUpdate(query);

		ResultSet result = statement.executeQuery("select * from studentDetail where ID=890");

		System.out.println(noOfUpdates);

		while (result.next())
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getInt(3) + "\t"
					+ result.getString(4));

		result.close();
		statement.close();
		connect.close();

	}

}
