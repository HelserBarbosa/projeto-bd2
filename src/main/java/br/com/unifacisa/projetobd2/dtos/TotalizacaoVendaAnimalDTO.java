package br.com.unifacisa.projetobd2.dtos;

import java.math.BigDecimal;

public class TotalizacaoVendaAnimalDTO {

	private BigDecimal totalizacao;

	private Long matricula;

	private String tipo;

	public BigDecimal getTotalizacao() {
		return totalizacao;
	}

	public void setTotalizacao(BigDecimal totalizacao) {
		this.totalizacao = totalizacao;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TotalizacaoVendaAnimalDTO [totalizacao=" + totalizacao + ", matricula=" + matricula + ", tipo=" + tipo
				+ "]";
	}

}
