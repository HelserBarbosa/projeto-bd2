package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.util.Date;

public class Funcionario {

	private Long matricula;
	private String nome;
	private String cpf;
	private String endereço;
	private String telefone;
	private BigDecimal salario;
	private Date dtDemi;
	private Date dtNasc;
	private Date dtAdm;
	private String funcao;
	
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Date getDtDemi() {
		return dtDemi;
	}
	public void setDtDemi(Date dtDemi) {
		this.dtDemi = dtDemi;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public Date getDtAdm() {
		return dtAdm;
	}
	public void setDtAdm(Date dtAdm) {
		this.dtAdm = dtAdm;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	} 
}
