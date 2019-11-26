package br.com.unifacisa.projetobd2.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.models.Funcionario;

@Repository
public interface FuncionarioDAO {
	
	Funcionario criarFuncionario(Funcionario funcionario);

	Funcionario criarFuncionarioSemSalario(Funcionario funcionario);
	
	Funcionario criarFuncionarioSemTelefone(Funcionario funcionario);
	
	Funcionario updateNomePorMatricula(Funcionario funcionario);
	
	Funcionario updateNomePorCpf(Funcionario funcionario);
	
	Funcionario updateEnderecoPorMatricula(Funcionario funcionario);
	
	Funcionario updateFuncaoPorMatricula(Funcionario funcionario);
	
	Funcionario updateDemisaoPorMatricula(Funcionario funcionario);
	
	Funcionario demisaoPorMatricula(Funcionario funcionario);
	
	List<Funcionario> listar();
	
	List<Funcionario> listarPorDescricao(String descricao);

	Funcionario buscarFuncionarioPorMatricula(long matricula);
	
	List<Funcionario> listarPorNome(String nome);
}
