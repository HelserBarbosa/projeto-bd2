package br.com.unifacisa.projetobd2.daos.impl;

import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.exceptions.PetShopConnectionException;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

import java.sql.*;
import java.time.LocalDate;

public class FuncionarioDAOImpl implements FuncionarioDAO {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        funcionario.setCpf("12345678910");
        funcionario.setDtAdm(LocalDate.of(2015, 2, 5));
        funcionario.setDtNasc(LocalDate.of(1989, 5, 25));
        funcionario.setEndereço("rua rua rua rua");
        funcionario.setFuncao("atendente");
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
            return connection.prepareStatement(
                    SQLUtils.getExternalQuery("CRIAR_FUNCIONARIO"),
                    Statement.RETURN_GENERATED_KEYS
            );
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
            statement.setString(3, funcionario.getEndereço());
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

}
