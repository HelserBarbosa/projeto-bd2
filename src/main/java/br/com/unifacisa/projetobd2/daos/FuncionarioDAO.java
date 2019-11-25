package br.com.unifacisa.projetobd2.daos;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.projetobd2.models.Funcionario;

@Repository
public interface FuncionarioDAO {
	
	Funcionario criarFuncionario(Funcionario funcionario);

}
