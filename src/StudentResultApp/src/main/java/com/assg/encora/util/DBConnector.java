package com.assg.encora.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/*
 *  singleton classsssssss
 */
public class DBConnector {

	public static DBConnector dBConnector = new DBConnector();

	private DBConnector() {

	}

	public static DBConnector getInstance() {
		if (dBConnector == null) {
			dBConnector = new DBConnector();
		}
		return dBConnector;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			DriverManager.registerDriver(new Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3000/emp_db", "root", "root123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}
