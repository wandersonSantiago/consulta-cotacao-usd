package br.com.microservice.b.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import br.com.microservice.b.domain.DateUtils;
import br.com.microservice.b.domain.enuns.TipoCotacao;
import br.com.microservice.b.restclient.dto.CotacaoMicroserviceADTO;

@Schema(name="CotacaoDto", description="Representação da cotação.")
public class CotacaoDTO {

	@Schema(name="tipo", description="Tipo da cotação, se é da data pesquisada ou do ultimo dia util anterior a data pesquisada.")
	private TipoCotacao tipo;
	@Schema(name="data", description="Data da cotação.")
	private LocalDateTime data;
	@Schema(name="valor compra", description="Valor de compra.")
	private BigDecimal cotacaoCompra;
	@Schema(name="valor venda", description="Valor de venda.")
	private BigDecimal cotacaoVenda;
	
	
	
	public CotacaoDTO(CotacaoMicroserviceADTO model) {
		this.tipo = model.getTipo();
		this.data = DateUtils.converteParaLocalDateTime(model.getDataHoraCotacao());
		this.cotacaoCompra = model.getCotacaoCompra();
		this.cotacaoVenda = model.getCotacaoVenda();
	}
	
	
	public TipoCotacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoCotacao tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
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
