package br.com.unifacisa.projetobd2.models;

import java.math.BigDecimal;

public class VendaItem {

    private Long notaFiscal;
    private Long iteCod;
    private Long matFunc;
    private String dia;
    private String mes;
    private String ano;
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
