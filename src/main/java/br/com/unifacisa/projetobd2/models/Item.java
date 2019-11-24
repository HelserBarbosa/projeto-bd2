package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {

	private Long codigo;
	private String descricao;
	private String tipo;
	private BigDecimal precoFornecedor;
	private BigDecimal precoLoja;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate validade;
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

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getSqlDate() throws ParseException {
		return Date.valueOf(validade); 
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", descricao=" + descricao + ", tipo=" + tipo + ", precoFornecedor="
				+ precoFornecedor + ", precoLoja=" + precoLoja + ", validade=" + validade + ", quantidade=" + quantidade
				+ "]";
	}

}
