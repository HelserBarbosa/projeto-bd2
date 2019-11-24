package br.com.unifacisa.projetobd2.daos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

@Repository
public class AnimalDAO {

	public Animal inserirAnimal(Animal animal) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;

		StringBuilder sql = new StringBuilder(
				"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda, dat_nasc)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
		try {
			statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
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
			ConnectionFactory.closeConnection();
			return setGeneratedKey(animal, statement);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		} 

	}

	private Animal setGeneratedKey(Animal animal, PreparedStatement statement) {
		try {
			ResultSet rs = statement.getGeneratedKeys();
			while (rs.next()) {
				animal.setRegistro(rs.getLong("registro"));
				return animal;
			}
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		return null;
	}

	public Animal inserirAnimalSemPesoAlturaMedicao(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, raca, preco_compra, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?);");

			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setString(3, animal.getRaca());
			statement.setBigDecimal(4, animal.getPrecoCompra());
			statement.setBigDecimal(5, animal.getPrecoVenda());
			statement.setDate(6, animal.getDtNasc());
			statement.execute();
			statement.close();
			return setGeneratedKey(animal, statement);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection();
		}

	}

	public Animal inserirAnimalSemPrecoVenda(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

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
			ConnectionFactory.closeConnection();
			return setGeneratedKey(animal, statement); 
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemPrecoCompra(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

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
			
			ConnectionFactory.closeConnection();
			return setGeneratedKey(animal, statement); 
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemPrecoCompraVenda(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?);");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setBigDecimal(3, animal.getPeso());
			statement.setBigDecimal(4, animal.getAltura());
			statement.setDate(5, animal.getDtUltMed());
			statement.setString(6, animal.getRaca());
			statement.setDate(7, animal.getDtNasc());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
			return setGeneratedKey(animal, statement); 
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemDataNasc(Animal animal) {
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

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
			ConnectionFactory.closeConnection();
			return setGeneratedKey(animal, statement); 
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPesoAlturaDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setBigDecimal(2, animal.getAltura());
			statement.setDate(3, animal.getDtUltMed());
			statement.setLong(4, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPesoDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalAlturaDtaMed(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getAltura());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoVenda(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_venda=?,");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoVenda());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoCompra(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?,");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoCompraVenda(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?, preco_venda=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setBigDecimal(2, animal.getPrecoVenda());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalTipo(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET tipo=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getTipo());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalRaca(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?,tipo=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalTipoRaca(Animal animal) {

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?");
			sql.append("WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setString(2, animal.getTipo());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void DeletarAnimalPorRegistro(Long registro) {

		try {

			StringBuilder sql = new StringBuilder("DELETE FROM animal WHERE registro=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setLong(1, registro);

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void DeletarAnimalPorTipo(String tipo) {
		try {

			StringBuilder sql = new StringBuilder("DELETE FROM animal WHERE tipo=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, tipo);

			statement.execute();

			statement.close();
			ConnectionFactory.closeConnection();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public List<Animal> listar() {
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			ResultSet resultSet = statement.executeQuery();

			List<Animal> resultado = new ArrayList<>();

			mapper(resultSet, resultado);

			return resultado;
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public List<Animal> listarPorTipo(String tipo) {
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal WHERE tipo=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setString(1, tipo);

			ResultSet resultSet = statement.executeQuery();

			List<Animal> resultado = new ArrayList<>();

			mapper(resultSet, resultado);

			return resultado;
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public List<Animal> listarPorPrecoVenda(BigDecimal precoVenda) {
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal WHERE preco_venda <=?;");

			Connection connection = ConnectionFactory.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			statement.setBigDecimal(1, precoVenda);

			ResultSet resultSet = statement.executeQuery();

			List<Animal> resultado = new ArrayList<>();

			mapper(resultSet, resultado);

			return resultado;
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	private void mapper(ResultSet resultSet, List<Animal> resultado) throws SQLException {
		while (resultSet.next()) {
			Animal animal = new Animal();

			animal.setRegistro(resultSet.getLong("registro"));
			animal.setTipo(resultSet.getString("tipo"));
			animal.setPeso(resultSet.getBigDecimal("peso"));
			animal.setAltura(resultSet.getBigDecimal("altura"));
			animal.setDtUltMed(resultSet.getDate("dat_ult_med"));
			animal.setRaca(resultSet.getString("raca"));
			animal.setPrecoCompra(resultSet.getBigDecimal("preco_compra"));
			animal.setPrecoVenda(resultSet.getBigDecimal("preco_venda"));
			animal.setDtNasc(resultSet.getDate("dat_nasc"));

			resultado.add(animal);
		}
	}
}
