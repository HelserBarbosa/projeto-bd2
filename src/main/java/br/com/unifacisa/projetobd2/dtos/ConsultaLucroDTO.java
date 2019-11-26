package br.com.unifacisa.projetobd2.dtos;

import java.math.BigDecimal;

public class ConsultaLucroDTO {

	private String nome;
	
	private BigDecimal lucro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}
	
}
