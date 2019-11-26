package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;

public class VendaItem {

    private Long notaFiscal;
    private Long iteCod;
    private Long matFunc;
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private BigDecimal comissaItem;
    private BigDecimal desconto;
    private BigDecimal valoFinal;

    public Long getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Long getIteCod() {
        return iteCod;
    }

    public void setIteCod(Long iteCod) {
        this.iteCod = iteCod;
    }

    public Long getMatFunc() {
        return matFunc;
    }

    public void setMatFunc(Long matFunc) {
        this.matFunc = matFunc;
    }


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

	public BigDecimal getComissaItem() {
        return comissaItem;
    }

    public void setComissaItem(BigDecimal comissaItem) {
        this.comissaItem = comissaItem;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValoFinal() {
        return valoFinal;
    }

    public void setValoFinal(BigDecimal valoFinal) {
        this.valoFinal = valoFinal;
    }

}
