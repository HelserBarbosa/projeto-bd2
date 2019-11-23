package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;

public class VendaAnimal {
	
	private Long notaFiscal;
	private Long regAnimal;
	private Long matFunc;
	private String dia;
	private String mes;
	private String ano;
	private BigDecimal comissao;
	private BigDecimal desconto;
	private BigDecimal valorFinal;

	public Long getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Long getRegAnimal() {
		return regAnimal;
	}
	public void setRegAnimal(Long regAnimal) {
		this.regAnimal = regAnimal;
	}
	public Long getMatFunc() {
		return matFunc;
	}
	public void setMatFunc(Long matFunc) {
		this.matFunc = matFunc;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
}
