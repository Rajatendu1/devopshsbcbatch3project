package com.hsbc;

import java.sql.*;

public class DBConnection {
    static Connection conn = null;

	public static void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}// end finally try
	}// end try
	

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/ass12";
		try {
			if (conn == null) {
				DriverManager.registerDriver (new com.mysql.cj.jdbc.Driver());
				conn = DriverManager.getConnection (url, "root", "qwerty@1234");
				System.out.println("conn : " + conn);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}


}
