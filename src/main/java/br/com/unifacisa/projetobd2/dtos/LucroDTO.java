package br.com.unifacisa.projetobd2.dtos;

import java.math.BigDecimal;

public class LucroDTO {

	private BigDecimal lucro;

	private Integer codigo;

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "LucroDTO [lucro=" + lucro + ", nomeItem=" + codigo + "]";
	}

}
