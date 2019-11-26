package br.com.unifacisa.projetobd2.daos.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import br.com.unifacisa.projetobd2.daos.AnimalDAO;
import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.daos.VendaAnimalDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Animal;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.models.VendaAnimal;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

public class VendaAnimalDAOImpl implements VendaAnimalDAO {

	public static void main(String[] args) {
		VendaAnimal va = new VendaAnimal();
		Animal animal = new Animal();
		AnimalDAO animalDao = new AnimalDAO();
		FuncionarioDAO fdao = new FuncionarioDAOImpl();
		VendaAnimalDAO vdao = new VendaAnimalDAOImpl();

		animal.setAltura(new BigDecimal("15"));
		animal.setPeso(new BigDecimal("15"));
		animal.setPrecoCompra(new BigDecimal("150"));
		animal.setPrecoCompra(new BigDecimal("130"));
		animal.setRaca("raca");
		animal.setTipo("tipo");
		animalDao.inserirAnimal(animal);

		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("12345678910");
		funcionario.setDtAdm(LocalDate.of(2015, 2, 5));
		funcionario.setDtNasc(LocalDate.of(1989, 5, 25));
		funcionario.setEndereço("rua rua rua rua");
		funcionario.setFuncao("atendente");
		funcionario.setNome("nome");
		funcionario.setTelefone("333333333");
		fdao.criarFuncionario(funcionario);

		va.setAnimal(animal);
		va.setFuncionario(funcionario);
		va.setAno(2019);
		va.setComissao(new BigDecimal("5"));
		va.setValorFinal(new BigDecimal("50"));
		va.setMes(03);
		va.setDia(14);
		vdao.insertSemInformarDesconto(va);
		vdao.deleteVendaPorNotaFiscal(va.getNotaFiscal());
	}

	@Override
	public VendaAnimal insertComTodosOsDados(VendaAnimal vendaAnimal) {
		if (vendaAnimal.getAnimal() == null || vendaAnimal.getFuncionario() == null) {
			throw new PetShopConnectionException("Venda possui campos invalidos");
		}
		Connection conn = getConnection();
		String sql = "insert into venda_animal (reg_animal, mat_func, dia, mes, ano, comissao_a, desconto, valor_final) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setLong(1, vendaAnimal.getAnimal().getRegistro());
			statement.setLong(2, vendaAnimal.getFuncionario().getMatricula());
			statement.setInt(3, vendaAnimal.getDia());
			statement.setInt(4, vendaAnimal.getMes());
			statement.setInt(5, vendaAnimal.getAno());
			statement.setBigDecimal(6, vendaAnimal.getComissao());
			statement.setBigDecimal(7, vendaAnimal.getDesconto());
			statement.setBigDecimal(8, vendaAnimal.getValorFinal());
			statement.execute();
			conn.commit();
			setGeneratedKey(vendaAnimal, statement);
			conn.close();
			return vendaAnimal;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public VendaAnimal insertSemInformarDesconto(VendaAnimal vendaAnimal) {
		if (vendaAnimal.getAnimal() == null || vendaAnimal.getFuncionario() == null) {
			throw new PetShopConnectionException("Venda possui campos invalidos");
		}
		Connection conn = getConnection();
		String sql = "INSERT INTO venda_animal (reg_animal, mat_func, dia, mes, ano, comissao_a, valor_final) values (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setLong(1, vendaAnimal.getAnimal().getRegistro());
			statement.setLong(2, vendaAnimal.getFuncionario().getMatricula());
			statement.setInt(3, vendaAnimal.getDia());
			statement.setInt(4, vendaAnimal.getMes());
			statement.setInt(5, vendaAnimal.getAno());
			statement.setBigDecimal(6, vendaAnimal.getComissao());
			statement.setBigDecimal(7, vendaAnimal.getValorFinal());
			statement.execute();
			conn.commit();
			setGeneratedKey(vendaAnimal, statement);
			conn.close();
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	@Override
	public void deleteVendaPorNotaFiscal(Long notaFiscal) {
		Connection conn = getConnection();
		String sql = "DELETE FROM venda_animal WHERE nota_fiscal = ?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setLong(1, notaFiscal);
			statement.execute();
			conn.commit();
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

	@Override
	public boolean updateNotaFiscalPelaNotaFiscal(Long antigaNotaFiscal, Long novaNotaFiscal) {
		Connection connection = getConnection();
		String sql = "UPDATE venda_animal SET nota_fiscal = ? WHERE nota_fiscal = ?";
		try (PreparedStatement statement = createStatement(connection, sql)) {
			statement.setLong(1, antigaNotaFiscal);
			statement.setLong(2, novaNotaFiscal);
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			return rowsAffected > 0;
		} catch (SQLException e) {
			rollback(connection, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return false;
	}

	@Override
	public boolean updateRegAnimalPorNotaFiscal(VendaAnimal vendaAnimal) {
		Connection connection = getConnection();
		if (vendaAnimal.getAnimal() == null) {
			throw new PetShopConnectionException("Registro de animal invalido");
		}
		String sql = "UPDATE venda_animal SET reg_animal = ? WHERE nota_fiscal = ?";
		try (PreparedStatement statement = createStatement(connection, sql)) {
			statement.setLong(1, vendaAnimal.getAnimal().getRegistro());
			statement.setLong(2, vendaAnimal.getNotaFiscal());
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			return rowsAffected > 0;
		} catch (SQLException e) {
			rollback(connection, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return false;
	}

	@Override
	public boolean updateMatFuncPorNotaFiscal(VendaAnimal vendaAnimal) {
		if (vendaAnimal.getFuncionario() == null) {
			throw new PetShopConnectionException("Registro de funcionario invalido");
		}
		Connection connection = getConnection();
		String sql = "UPDATE venda_animal SET mat_func = ? where nota_fiscal = ?";
		try (PreparedStatement statement = createStatement(connection, sql)) {
			statement.setLong(1, vendaAnimal.getFuncionario().getMatricula());
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			return rowsAffected > 0;
		} catch (SQLException e) {
			rollback(connection, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return false;
	}

	@Override
	public boolean updateDiaMesAnoPorNotaFiscal(VendaAnimal vendaAnimal) {
		Connection connection = getConnection();
		String sql = "UPDATE venda_animal SET dia = ?, mes = ?, ano = ? WHERE nota_fiscal = ?";
		try (PreparedStatement statement = createStatement(connection, sql)) {
			statement.setInt(1, vendaAnimal.getDia());
			statement.setInt(2, vendaAnimal.getMes());
			statement.setInt(3, vendaAnimal.getAno());
			statement.setLong(4, vendaAnimal.getNotaFiscal());
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			return rowsAffected > 0;
		} catch (SQLException e) {
			rollback(connection, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return false;
	}

	@Override
	public boolean updateDisconto(BigDecimal novoDesconto) {
		Connection connection = getConnection();
		String sql = "UPDATE venda_animal SET desconto = ?";
		try (PreparedStatement statement = createStatement(connection, sql)) {
			statement.setBigDecimal(1, novoDesconto);
			int rowsAffected = statement.executeUpdate();
			connection.commit();
			return rowsAffected > 0;
		} catch (SQLException e) {
			rollback(connection, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return false;
	}

	private VendaAnimal setGeneratedKey(VendaAnimal vendaAnimal, PreparedStatement statement) {
		try (ResultSet rs = statement.getGeneratedKeys()) {
			while (rs.next()) {
				vendaAnimal.setNotaFiscal(rs.getLong("nota_fiscal"));
				return vendaAnimal;
			}
		} catch (SQLException e) {
			throw new PetShopConnectionException(e.getMessage());
		}
		return null;
	}

	private Connection getConnection() {
		Connection conn = new ConnectionFactory().getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return conn;
	}

	private void rollback(Connection connection, Exception e) {
		try {
			connection.rollback();
		} catch (SQLException ex) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

	private PreparedStatement createStatement(Connection connection, String sql) {
		try {
			return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

}
