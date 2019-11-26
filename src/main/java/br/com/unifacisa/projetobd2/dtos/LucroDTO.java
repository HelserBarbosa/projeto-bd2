package br.com.unifacisa.projetobd2.dtos;

import java.math.BigDecimal;

public class LucroDTO {

	private BigDecimal lucro;

	private String nomeItem;

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	@Override
	public String toString() {
		return "LucroDTO [lucro=" + lucro + ", nomeItem=" + nomeItem + "]";
	}

}
