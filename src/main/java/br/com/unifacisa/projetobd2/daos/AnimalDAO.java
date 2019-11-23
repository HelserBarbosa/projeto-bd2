package br.com.unifacisa.projetobd2.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.util.JDBCUtil;

@Repository
public class AnimalDAO {

	public void inserirAnimal(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaça());
			statement.setBigDecimal(7, animal.getPrecoCompra());
			statement.setBigDecimal(8, animal.getPrecoVenda());
			statement.setDate(9, animal.getDtNasc());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void inserirAnimalSemPesoAlturaMedicao(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, raca, preco_compra, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());;
			statement.setString(3, animal.getRaça());
			statement.setBigDecimal(4, animal.getPrecoCompra());
			statement.setBigDecimal(5, animal.getPrecoVenda());
			statement.setDate(6, animal.getDtNasc());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void inserirAnimalSemPrecoVenda(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaça());
			statement.setBigDecimal(7, animal.getPrecoCompra());
			statement.setDate(8, animal.getDtNasc());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void inserirAnimalSemPrecoCompra(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaça());
			statement.setBigDecimal(7, animal.getPrecoVenda());
			statement.setDate(8, animal.getDtNasc());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	
	public void inserirAnimalSemPrecoCompraVenda(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaça());
			statement.setDate(7, animal.getDtNasc());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void inserirAnimalSemDataNasc(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaça());
			statement.setBigDecimal(7, animal.getPrecoCompra());
			statement.setBigDecimal(8, animal.getPrecoVenda());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
