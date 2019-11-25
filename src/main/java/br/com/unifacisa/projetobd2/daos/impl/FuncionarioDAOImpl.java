package br.com.unifacisa.projetobd2.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.util.ConnectionFactory;
import br.com.unifacisa.projetobd2.util.SQLUtils;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	@Override
	public Funcionario criarFuncionario(Funcionario funcionario) {
		Connection conn = new ConnectionFactory().getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(SQLUtils.getExternalQuery("CRIAR_FUNCIONARIO"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("12345678910");
		funcionario.setDtAdm(LocalDate.of(2015, 2, 5));
		funcionario.setDtNasc(LocalDate.of(1989, 5, 25));
		funcionario.setEndereço("rua rua rua rua");
		funcionario.setFuncao("adm");
		funcionario.setNome("nome");
		funcionario.setTelefone("333333333");
	}

}
