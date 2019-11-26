package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;

public class VendaAnimal {

	private Long notaFiscal;
	private Animal animal;
	private Funcionario funcionario;
	private Integer dia;
	private Integer mes;
	private Integer ano;
	private BigDecimal comissao;
	private BigDecimal desconto;
	private BigDecimal valorFinal;

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Long getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

	@Override
	public String toString() {
		return "VendaAnimal [notaFiscal=" + notaFiscal + ", animal=" + animal + ", funcionario=" + funcionario
				+ ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + ", comissao=" + comissao + ", desconto=" + desconto
				+ ", valorFinal=" + valorFinal + "]";
	}

}
