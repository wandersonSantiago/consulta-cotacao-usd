package com.bb.microservice.a.api.resource;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.bb.microservice.a.domain.service.CotacaoService;
import com.bb.microservice.a.restclient.dto.ConsultaBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.CotacaoBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.MoedaBancoCentralDTO;

@RequestScoped
@Path("/v1/cotacoes")
@Tag(name = "Serviço de Cotações", description = "Serviço de consulta de cotação Dolar compra e venda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CotacaoResource {

	@Inject
	CotacaoService service;

	@GET
	@Path(value = "/data/{dataCotacao}")
	@Operation(summary = "Cotação do Dólar atraves da data informada", description = "Realiza a busca de uma cotação pela data informada.")
	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPelaData(
			@PathParam(value = "dataCotacao") LocalDate data) {
		return service.buscarCotacaoPelaData(data);
	}

	@GET
	@Path(value = "/periodo/data-inicial/{dataInicial}/data-final/{dataFinal}")
	@Operation(summary = "Cotação do Dólar por periodo", description = "Realiza a busca de uma cotação pela data informada.")
	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPorPeriodo(
			@PathParam(value = "dataInicial") LocalDate dataInicial,
			@PathParam(value = "dataFinal") LocalDate dataFinal, @QueryParam(value = "orderBy") String orderBy,
			@QueryParam(value = "top") Integer top) {
		return service.buscarCotacaoPorPeriodo(dataInicial, dataFinal, orderBy, top);
	}

	@GET
	@Path(value = "/moedas")
	@Operation(summary = "Moedas Simbolos e nome", description = "Realiza a busca das moedas com simbolos e nomes.")
	public ConsultaBancoCentralDTO<MoedaBancoCentralDTO> buscarMoedas() {
		return service.buscarMoedas();
	}
}