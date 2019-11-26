package br.com.unifacisa.projetobd2.dtos;

import java.math.BigDecimal;

public class TotalizacaoDTO {

	private BigDecimal totalizacao;

	private String tipoItem;

	private Integer quantidade;

	public BigDecimal getTotalizacao() {
		return totalizacao;
	}

	public void setTotalizacao(BigDecimal totalizacao) {
		this.totalizacao = totalizacao;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "TotalizacaoDTO [totalizacao=" + totalizacao + ", tipoItem=" + tipoItem + ", quantidade=" + quantidade
				+ "]";
	}

}
