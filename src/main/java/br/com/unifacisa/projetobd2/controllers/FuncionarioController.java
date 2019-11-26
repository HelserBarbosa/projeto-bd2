package br.com.unifacisa.projetobd2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.projetobd2.models.Funcionario;
import br.com.unifacisa.projetobd2.services.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@PostMapping("completo")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.criarFuncionario(funcionario),HttpStatus.CREATED);
	}
	
	@PostMapping("salario")
	public ResponseEntity<Funcionario> criarFuncionarioSemSalario(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.criarFuncionarioSemSalario(funcionario),HttpStatus.CREATED);
	}
	
	@PostMapping("telefone")
	public ResponseEntity<Funcionario> criarFuncionarioSemTelefone(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.criarFuncionarioSemTelefone(funcionario),HttpStatus.CREATED);
	}
	
	@PutMapping("nome-matricula")
	public ResponseEntity<Funcionario> updateNomePorMatricula(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.updateNomePorMatricula(funcionario),HttpStatus.OK);
	}
	
	@PutMapping("nome-cpf")
	public ResponseEntity<Funcionario> updateNomePorCpf(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.updateNomePorCpf(funcionario),HttpStatus.OK);
	}
	
	@PutMapping("endereco-matricula")
	public ResponseEntity<Funcionario> updateEnderecoPorMatricula(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.updateEnderecoPorMatricula(funcionario),HttpStatus.OK);
	}
	
	@PutMapping("funcao-matricula")
	public ResponseEntity<Funcionario> updateFuncaoPorMatricula(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.updateFuncaoPorMatricula(funcionario),HttpStatus.OK);
	}
	
	@PutMapping("demissao-matricula")
	public ResponseEntity<Funcionario> updateDemisaoPorMatricula(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.updateDemisaoPorMatricula(funcionario),HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Funcionario> demisaoPorMatricula(@RequestBody Funcionario funcionario) {
		return new ResponseEntity<>(service.demisaoPorMatricula(funcionario),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listar(){
		return new ResponseEntity<>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping("descricao")
	public ResponseEntity<List<Funcionario>> listarPorDescricao(@RequestParam("descricao") String descricao){
		return new ResponseEntity<>(service.listarPorDescricao(descricao),HttpStatus.OK);
	}
	
	@GetMapping("matricula")
	public  ResponseEntity<Funcionario> buscarFuncionarioPorMatricula(@RequestParam("matricula") long matricula) {
		return new ResponseEntity<>(service.buscarFuncionarioPorMatricula(matricula),HttpStatus.OK);
	}
	
	@GetMapping("nome")
	public ResponseEntity<List<Funcionario>> listarPorNome(@RequestParam("nome") String nome){
		return new ResponseEntity<>(service.listarPorNome(nome),HttpStatus.OK);
	}

}
