package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.util.Date;

public class Item {
	
	private Long codigo;
	private String descricao;
	private String tipo;
	private BigDecimal precoFornecedor;
	private BigDecimal precoLoja;
	private Date validade;
	private Integer quantidade;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecoFornecedor() {
		return precoFornecedor;
	}
	public void setPrecoFornecedor(BigDecimal precoFornecedor) {
		this.precoFornecedor = precoFornecedor;
	}
	public BigDecimal getPrecoLoja() {
		return precoLoja;
	}
	public void setPrecoLoja(BigDecimal precoLoja) {
		this.precoLoja = precoLoja;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
