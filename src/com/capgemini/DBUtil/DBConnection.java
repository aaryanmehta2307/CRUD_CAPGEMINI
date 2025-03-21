package com.capgemini.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	Connection con =null;
	
	public Connection getConnection	() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cuims","root","1234");
		System.out.println("Connection Established");
		return con;
	}
	
}
