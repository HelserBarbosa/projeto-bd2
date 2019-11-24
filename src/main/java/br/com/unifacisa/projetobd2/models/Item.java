package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item {

	private Long codigo;
	private String descricao;
	private String tipo;
	private BigDecimal precoFornecedor;
	private BigDecimal precoLoja;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return new java.sql.Date(sdf.parse(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(validade)).getTime());
	}


	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", descricao=" + descricao + ", tipo=" + tipo + ", precoFornecedor="
				+ precoFornecedor + ", precoLoja=" + precoLoja + ", validade=" + validade + ", quantidade=" + quantidade
				+ "]";
	}


}
