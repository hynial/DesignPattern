package com.f708.factoryMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory implements IConnectionFactory {
	@Override
	public Connection create(String serverName, String dbName, String userName, String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		String url = "jdbc:mysql://" + serverName + ":3306/" + dbName
				+ "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
		return DriverManager.getConnection(url, userName, password);
	}

}
