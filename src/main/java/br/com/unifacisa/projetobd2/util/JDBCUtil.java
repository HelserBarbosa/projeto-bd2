package br.com.unifacisa.projetobd2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static final String URL = "jdbc:postgresql://localhost:5432/petshop;";
	private static final String USER = "postgres";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
