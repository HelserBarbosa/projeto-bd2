package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.sql.Date;

public class Animal {

	private Long registro;
	private String tipo;
	private BigDecimal peso;
	private BigDecimal altura;
	private Date dtUltMed;
	private String raça;
	private BigDecimal precoCompra = new BigDecimal("0");
	private BigDecimal precoVenda;
	private Date DtNasc;

	public Long getRegistro() {
		return registro;
	}

	public void setRegistro(Long registro) {
		this.registro = registro;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public Date getDtUltMed() {
		return dtUltMed;
	}

	public void setDtUltMed(Date dtUltMed) {
		this.dtUltMed = dtUltMed;
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Date getDtNasc() {
		return DtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		DtNasc = dtNasc;
	}
}
