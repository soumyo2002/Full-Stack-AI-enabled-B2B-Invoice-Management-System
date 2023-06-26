package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static final String URL = "jdbc:mysql://localhost:3306/sys";
	public static final String USER ="root";
	public static final String PASS = "root";
	
	public static Connection connect() throws ClassNotFoundException{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASS);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
