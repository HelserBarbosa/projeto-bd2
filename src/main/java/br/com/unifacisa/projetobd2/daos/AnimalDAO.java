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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			;
			statement.setString(3, animal.getRaca());
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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
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
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
			statement.setBigDecimal(7, animal.getPrecoCompra());
			statement.setBigDecimal(8, animal.getPrecoVenda());

			statement.execute();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void updateAnimalPesoAlturaDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setBigDecimal(2, animal.getAltura());
			statement.setDate(3, animal.getDtUltMed());
			statement.setLong(4, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void updateAnimalPesoDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void updateAnimalAlturaDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getAltura());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalPrecoVenda(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_venda=?,");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoVenda());
			statement.setLong(2, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalPrecoCompra(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?,");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setLong(2, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalPrecoCompraVenda(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?, preco_venda=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setBigDecimal(2, animal.getPrecoVenda());
			statement.setLong(3, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalTipo(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET tipo=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getTipo());
			statement.setLong(2, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalRaca(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?,tipo=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setLong(2, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void updateAnimalTipoRaca(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?");
			sql.append("WHERE registro=?;");

			Connection connection = JDBCUtil.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setString(2, animal.getTipo());
			statement.setLong(2, animal.getRegistro());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
