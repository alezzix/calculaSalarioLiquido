package br.com.ccee.rh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionManager {


	public Connection getConnection() {
		Connection connection = null;
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/rh", "postgres", "a123456*");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;

	}

}