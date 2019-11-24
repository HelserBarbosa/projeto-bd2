package br.com.unifacisa.projetobd2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;

public class ConnectionFactory {

	public Connection getConnection() {
		Properties properties = PropertiesUtils.getProperties();
		String url = properties.getProperty("url");
		try {
			return DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
	}

}
