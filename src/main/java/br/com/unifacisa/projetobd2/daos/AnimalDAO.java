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

import br.com.unifacisa.projetobd2.dtos.ConsultaLucroDTO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

@Repository
public class AnimalDAO {

	public Animal inserirAnimal(Animal animal) {
		PreparedStatement statement = null;
		Connection connection = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO animal(tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda, dat_nasc)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
		try {
			statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, animal.getTipo());
			statement.setBigDecimal(2, animal.getPeso());
			statement.setBigDecimal(3, animal.getAltura());
			statement.setDate(4, animal.getDtUltMed());
			statement.setString(5, animal.getRaca());
			statement.setBigDecimal(6, animal.getPrecoCompra());
			statement.setBigDecimal(7, animal.getPrecoVenda());
			statement.setDate(8, animal.getDtNasc());
			statement.execute();
			setGeneratedKey(animal, statement);
			statement.close();
			connection.close();
			return animal;
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
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, raca, preco_compra, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?);");
			PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setLong(1, animal.getRegistro());
			statement.setString(2, animal.getTipo());
			statement.setString(3, animal.getRaca());
			statement.setBigDecimal(4, animal.getPrecoCompra());
			statement.setBigDecimal(5, animal.getPrecoVenda());
			statement.setDate(6, animal.getDtNasc());
			statement.execute();
			statement.close();
			connection.close();
			return setGeneratedKey(animal, statement);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Animal inserirAnimalSemPrecoVenda(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

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
			connection.close();
			return setGeneratedKey(animal, statement);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemPrecoCompra(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_venda, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

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
			connection.close();
			return setGeneratedKey(animal, statement);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemPrecoCompraVenda(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, dat_nasc)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?);");

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
			connection.close();
			return setGeneratedKey(animal, statement);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public Animal inserirAnimalSemDataNasc(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder(
					"INSERT INTO animal(registro, tipo, peso, altura, dat_ult_med, raca, preco_compra, preco_venda)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?);");

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
			connection.close();
			return setGeneratedKey(animal, statement);
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPesoAlturaDtaMed(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setBigDecimal(2, animal.getAltura());
			statement.setDate(3, animal.getDtUltMed());
			statement.setLong(4, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPesoDtaMed(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET peso=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPeso());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalAlturaDtaMed(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET altura=?, dat_ult_med=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getAltura());
			statement.setDate(2, animal.getDtUltMed());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoVenda(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_venda=?,");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoVenda());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoCompra(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?,");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalPrecoCompraVenda(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET preco_compra=?, preco_venda=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setBigDecimal(1, animal.getPrecoCompra());
			statement.setBigDecimal(2, animal.getPrecoVenda());
			statement.setLong(3, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalTipo(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET tipo=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getTipo());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalRaca(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?,tipo=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void updateAnimalTipoRaca(Animal animal) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("UPDATE animal SET raca=?");
			sql.append("WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, animal.getRaca());
			statement.setString(2, animal.getTipo());
			statement.setLong(2, animal.getRegistro());

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void DeletarAnimalPorRegistro(Long registro) {
		Connection connection = new ConnectionFactory().getConnection();

		try {

			StringBuilder sql = new StringBuilder("DELETE FROM animal WHERE registro=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setLong(1, registro);

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public void DeletarAnimalPorTipo(String tipo) {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder("DELETE FROM animal WHERE tipo=?;");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, tipo);

			statement.execute();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}

	}

	public List<Animal> listar() {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal;");

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
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal WHERE tipo=?;");

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
		Connection connection = new ConnectionFactory().getConnection();
		try {

			StringBuilder sql = new StringBuilder("SELECT * FROM animal WHERE preco_venda <=?;");

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

	public List<ConsultaLucroDTO> consultaLucro() {
		Connection connection = new ConnectionFactory().getConnection();
		try {

			String sql = "SELECT nome,(animal.preco_venda - animal.preco_compra) as lucro FROM animal";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			List<ConsultaLucroDTO> resultado = new ArrayList<>();
			while (resultSet.next()) {

				ConsultaLucroDTO consultaLucro = new ConsultaLucroDTO();
				consultaLucro.setNome(resultSet.getString("nome"));
				consultaLucro.setLucro(resultSet.getBigDecimal("lucro"));

				resultado.add(consultaLucro);

			}
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

	public Animal buscarAnimalPorRegistro(long registro) {
		Connection connection = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder("SELECT * FROM animal WHERE registro = ?");
		try (PreparedStatement statement = connection.prepareStatement(sql.toString())){
			statement.setLong(1, registro);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				Animal animal = new Animal();
				animal.setRegistro(rs.getLong("registro"));
				animal.setTipo(rs.getString("tipo"));
				animal.setPeso(rs.getBigDecimal("peso"));
				animal.setAltura(rs.getBigDecimal("altura"));
				animal.setDtUltMed(rs.getDate("dat_ult_med"));
				animal.setRaca(rs.getString("raca"));
				animal.setPrecoCompra(rs.getBigDecimal("preco_compra"));
				animal.setPrecoVenda(rs.getBigDecimal("preco_venda"));
				animal.setDtNasc(rs.getDate("dat_nasc"));
				return animal;
			}
			
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		throw new PetShopConnectionException("Animal não encontrado");
	}
}
