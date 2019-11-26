package br.com.unifacisa.projetobd2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.projetobd2.daos.FuncionarioDAO;
import br.com.unifacisa.projetobd2.models.Funcionario;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioDAO dao;
	
	public Funcionario criarFuncionario(Funcionario funcionario) {
		return dao.criarFuncionario(funcionario);
	}
	
	public Funcionario criarFuncionarioSemSalario(Funcionario funcionario) {
		return dao.criarFuncionarioSemSalario(funcionario);
	}
	public Funcionario criarFuncionarioSemTelefone(Funcionario funcionario) {
		return dao.criarFuncionarioSemTelefone(funcionario);
	}
	
	public Funcionario updateNomePorMatricula(Funcionario funcionario) {
		return dao.updateNomePorMatricula(funcionario);
	}
	
	public Funcionario updateNomePorCpf(Funcionario funcionario) {
		return dao.updateNomePorCpf(funcionario);
	}
	
	public Funcionario updateEnderecoPorMatricula(Funcionario funcionario) {
		return dao.updateEnderecoPorMatricula(funcionario);
	}
	
	public Funcionario updateFuncaoPorMatricula(Funcionario funcionario) {
		return dao.updateFuncaoPorMatricula(funcionario);
	}
	
	public Funcionario updateDemisaoPorMatricula(Funcionario funcionario) {
		return dao.updateDemisaoPorMatricula(funcionario);
	}
	
	public Funcionario demisaoPorMatricula(Funcionario funcionario) {
		return dao.demisaoPorMatricula(funcionario);
	}
	
	public List<Funcionario> listar(){
		return dao.listar();
	}
	
	public List<Funcionario> listarPorDescricao(String descricao){
		return dao.listarPorDescricao(descricao);
	}
	
	public Funcionario buscarFuncionarioPorMatricula(long matricula) {
		return dao.buscarFuncionarioPorMatricula(matricula);
	}
	
	public List<Funcionario> listarPorNome(String nome){
		return dao.listarPorNome(nome);
	}
}
