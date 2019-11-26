package br.com.unifacisa.projetobd2.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO dao = new FuncionarioDAOImpl();
		funcionario.setCpf("12345678910");
		funcionario.setDtAdm(LocalDate.of(2015, 2, 5));
		funcionario.setDtNasc(LocalDate.of(1989, 5, 25));
		funcionario.setEndereço("rua rua rua rua");
		funcionario.setFuncao("adm");
		funcionario.setNome("nome");
		funcionario.setTelefone("333333333");
		dao.criarFuncionario(funcionario);
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

	private PreparedStatement createStatement(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("CRIAR_FUNCIONARIO"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatementSemSalario(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("INSERIR_FUNCIONARIO_SEM_SALARIO"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatementSemTelefone(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("INSERIR_FUNCIONARIO_SEM_TELEFONE"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatementUpdate(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("UPDATE_NOME_POR_MATRICULA"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatementUpdateNomePorCpf(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("UPDATE_NOME_POR_CPF"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatementUpdateEnderecoPormatricula(Connection connection) {
		try {
			return connection.prepareStatement(SQLUtils.getExternalQuery("UPDATE_ENDERECO_POR_MATRICULA"),
					Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	private PreparedStatement createStatement(Connection connection, String query) {
		try {
			return connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		throw new PetShopConnectionException("Algo quebrou no prepare statement");
	}

	@Override
	public Funcionario criarFuncionario(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatement(conn)) {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getEndereco());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getFuncao());
			statement.setDate(6, funcionario.getSqlDtNasc());
			statement.setDate(7, funcionario.getSqlDtAdm());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	private void setFuncionarioKey(PreparedStatement statement, Funcionario funcionario) {
		try (ResultSet rs = statement.getGeneratedKeys()) {
			if (rs.next()) {
				funcionario.setMatricula(rs.getLong("matricula"));
			}
		} catch (SQLException e) {
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
	}

	public Funcionario criarFuncionarioSemSalario(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatementSemSalario(conn)) {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getEndereco());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getFuncao());
			statement.setDate(6, funcionario.getSqlDtNasc());
			statement.setDate(7, funcionario.getSqlDtAdm());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public Funcionario criarFuncionarioSemTelefone(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatementSemTelefone(conn)) {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getEndereco());
			statement.setString(4, funcionario.getFuncao());
			statement.setDate(5, funcionario.getSqlDtNasc());
			statement.setDate(6, funcionario.getSqlDtAdm());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public Funcionario updateNomePorMatricula(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatementUpdate(conn)) {
			statement.setString(1, funcionario.getNome());
			statement.setLong(2, funcionario.getMatricula());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public Funcionario updateNomePorCpf(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatementUpdateNomePorCpf(conn)) {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public Funcionario updateEnderecoPorMatricula(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatementUpdateEnderecoPormatricula(conn)) {
			statement.setString(1, funcionario.getEndereco());
			statement.setLong(2, funcionario.getMatricula());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	public Funcionario updateFuncaoPorMatricula(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatement(conn,
				SQLUtils.getExternalQuery("UPDATE_FUNCAO_POR_MATRICULA"))) {
			statement.setString(1, funcionario.getFuncao());
			statement.setLong(2, funcionario.getMatricula());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}
	
	public Funcionario updateDemisaoPorMatricula(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatement(conn,
				SQLUtils.getExternalQuery("UPDATE_DEMISSAO_POR_MATRICULA"))) {
			statement.setDate(1, funcionario.getSqlDtDemi());
			statement.setLong(2, funcionario.getMatricula());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}
	
	public Funcionario demisaoPorMatricula(Funcionario funcionario) {
		Connection conn = getConnection();
		try (PreparedStatement statement = createStatement(conn,
				SQLUtils.getExternalQuery("DELECAO_POR_MATRICULA"))) {
			statement.setLong(1, funcionario.getMatricula());
			statement.execute();
			setFuncionarioKey(statement, funcionario);
			return funcionario;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}
}
