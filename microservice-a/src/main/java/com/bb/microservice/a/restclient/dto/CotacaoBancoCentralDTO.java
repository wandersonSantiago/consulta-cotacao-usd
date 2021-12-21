package com.bb.microservice.a.restclient.dto;

import java.math.BigDecimal;

public class CotacaoBancoCentralDTO {

	private BigDecimal cotacaoCompra;
	private BigDecimal cotacaoVenda;
	private String dataHoraCotacao;
	

	public String getDataHoraCotacao() {
		return dataHoraCotacao;
	}
	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}
	public BigDecimal getCotacaoCompra() {
		return cotacaoCompra;
	}
	public void setCotacaoCompra(BigDecimal cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}
	public BigDecimal getCotacaoVenda() {
		return cotacaoVenda;
	}
	public void setCotacaoVenda(BigDecimal cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

}
