package br.com.unifacisa.projetobd2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;

public class ConnectionFactory {
	
	private static Connection conn;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				Properties properties = PropertiesUtils.getProperties();
				String url = properties.getProperty("url");
				System.out.println(properties);
				System.out.println(url);
				conn = DriverManager.getConnection(url, properties);
			}
			return conn;
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		} 
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new PetShopConnectionException(e.getMessage());
			}
		}
	}

	public static void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new PetShopConnectionException(e.getMessage());
			}
		}
	}
	
}
