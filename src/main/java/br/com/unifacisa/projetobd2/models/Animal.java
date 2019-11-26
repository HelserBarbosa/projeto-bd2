package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Animal {

	private Long registro;
	private String tipo;
	private BigDecimal peso;
	private BigDecimal altura;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtUltMed;
	private String raca;
	private BigDecimal precoCompra = new BigDecimal("0");
	private BigDecimal precoVenda;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate DtNasc;

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

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raça) {
		this.raca = raça;
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

	public LocalDate getDtUltMed() {
		return dtUltMed;
	}

	public void setDtUltMed(LocalDate dtUltMed) {
		this.dtUltMed = dtUltMed;
	}

	public LocalDate getDtNasc() {
		return DtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		DtNasc = dtNasc;
	}

	@Override
	public String toString() {
		return "Animal [registro=" + registro + ", tipo=" + tipo + ", peso=" + peso + ", altura=" + altura
				+ ", dtUltMed=" + dtUltMed + ", raca=" + raca + ", precoCompra=" + precoCompra + ", precoVenda="
				+ precoVenda + ", DtNasc=" + DtNasc + "]";
	}

}
