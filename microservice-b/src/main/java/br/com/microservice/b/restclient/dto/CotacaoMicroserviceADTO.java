package br.com.microservice.b.restclient.dto;

import java.math.BigDecimal;

import br.com.microservice.b.domain.enuns.TipoCotacao;

public class CotacaoMicroserviceADTO {

	private TipoCotacao tipo;
	private String dataHoraCotacao;
	private BigDecimal cotacaoCompra;
	private BigDecimal cotacaoVenda;

	public TipoCotacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoCotacao tipo) {
		this.tipo = tipo;
	}

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
