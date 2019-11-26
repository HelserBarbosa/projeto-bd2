package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Funcionario {

	private Long matricula;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private BigDecimal salario;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtDemi;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNasc;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtAdm;
	private String funcao;

	public Date getSqlDtDemi() {
		return Date.valueOf(dtDemi);
	}

	public Date getSqlDtNasc() {
		return Date.valueOf(dtNasc);
	}

	public Date getSqlDtAdm() {
		return Date.valueOf(dtAdm);
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
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

	public LocalDate getDtDemi() {
		return dtDemi;
	}

	public void setDtDemi(LocalDate dtDemi) {
		this.dtDemi = dtDemi;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public LocalDate getDtAdm() {
		return dtAdm;
	}

	public void setDtAdm(LocalDate dtAdm) {
		this.dtAdm = dtAdm;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
