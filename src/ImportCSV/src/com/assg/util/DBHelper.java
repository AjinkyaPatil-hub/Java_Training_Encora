package com.assg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBHelper {

	// Singleton design pattern is used to create object..
	// object is created when application is loaded . static is loaded before object
	// creation
	private static DBHelper helper = new DBHelper();

	// no one can create object from outside. to preserve singleton dp.
	private DBHelper() {

	}

	public static DBHelper getInstance() {
		// extra check if object gets garbage collect new object is created...
		if (helper == null) {
			helper = new DBHelper();
		}
		return helper;
	}

	public Connection getMySQLConnection() throws SQLException {
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3000", "root", "root123");
	}

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
