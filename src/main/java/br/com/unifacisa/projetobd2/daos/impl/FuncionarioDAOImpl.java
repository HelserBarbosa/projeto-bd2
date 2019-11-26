package br.com.unifacisa.projetobd2.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;

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
		String sql = "insert into funcionario (nome, cpf, endereco, telefone, funcao,dat_nasc, dat_adm) values (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setString(1, funcionario.getNome());
			statement.setString(2, funcionario.getCpf());
			statement.setString(3, funcionario.getEndereco());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getFuncao());
			statement.setDate(6, funcionario.getSqlDtNasc());
			statement.setDate(7, funcionario.getSqlDtAdm());
			statement.execute();
			conn.commit();
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
		String sql = "insert into funcionario (nome, cpf, endereco, telefone,da_nasc, dat_adm) values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "insert into funcionario (nome, cpf, endereco, salario ,da_nasc, dat_adm) values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "UPDATE funcionario set nome=? where matricula = ?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "UPDATE funcionario set nome=? where cpf=?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "UPDATE funcionario set endereco=? where matricula=?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "UPDATE funcionario set funcao=? where matricula=?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "UPDATE funcionario set dtDemi=? where matricula=?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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
		String sql = "DELETE funcionario WHERE matricula=?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
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

	public List<Funcionario> listar() {
		Connection conn = getConnection();
		try {
			PreparedStatement statement = createStatement(conn, "SELECT * FROM funcionario");

			ResultSet resultado = statement.executeQuery();

			List<Funcionario> funcionarios = new ArrayList<>();

			mapper(resultado, funcionarios);

			return funcionarios;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}

		return null;
	}

	public List<Funcionario> listarPorDescricao(String descricao) {
		Connection conn = getConnection();
		try {
			PreparedStatement statement = createStatement(conn, "SELECT * FROM funcionario WHERE descricao=?");
			statement.setString(1, descricao);
			ResultSet resultado = statement.executeQuery();

			List<Funcionario> funcionarios = new ArrayList<>();

			while (resultado.next()) {

				Funcionario func = new Funcionario();

				func.setMatricula(resultado.getLong("matricula"));

				funcionarios.add(func);
			}

			return funcionarios;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}

		return null;
	}

	@Override
	public Funcionario buscarFuncionarioPorMatricula(long matricula) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM funcionario WHERE matricula= ?";
		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setLong(1, matricula);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				Funcionario func = mapperFunc(rs);
				return func;
			}
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}

	private Funcionario mapperFunc(ResultSet rs) throws SQLException {
		Funcionario func = new Funcionario();
		func.setMatricula(rs.getLong("matricula"));
		func.setCpf(rs.getString("cpf"));
		func.setDtAdm(rs.getDate("dat_adm").toLocalDate());
		func.setDtDemi(rs.getDate("dat_demissao").toLocalDate());
		func.setDtNasc(rs.getDate("dat_nasc").toLocalDate());
		func.setEndereço(rs.getString("endereco"));
		func.setFuncao(rs.getString("funcao"));
		func.setNome(rs.getString("nome"));
		func.setSalario(rs.getBigDecimal("salario"));
		func.setTelefone(rs.getString("telefone"));
		return func;
	}

	private void mapper(ResultSet resultado, List<Funcionario> funcionarios) throws SQLException {
		while (resultado.next()) {
			funcionarios.add(mapperFunc(resultado));
		}
	}

	@Override
	public List<Funcionario> listarPorNome(String nome) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM funcionario WHERE nome= ?";

		try (PreparedStatement statement = createStatement(conn, sql)) {
			statement.setString(1, nome);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			List<Funcionario> funcionarios = new ArrayList<>();
			mapper(rs, funcionarios);
			return funcionarios;
		} catch (SQLException e) {
			rollback(conn, e);
			PetShopConnectionException.handlePetShopConnectionException(e);
		}
		return null;
	}
}
