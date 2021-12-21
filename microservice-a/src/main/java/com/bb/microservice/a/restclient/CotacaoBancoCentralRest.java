package com.bb.microservice.a.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.bb.microservice.a.restclient.dto.ConsultaBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.CotacaoBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.MoedaBancoCentralDTO;

@Path("/v1/odata")
@RegisterRestClient(configKey = "olinda.bcb.gov.br")
public interface CotacaoBancoCentralRest {

	@GET
	@Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPelaData(
			@QueryParam(value = "@dataCotacao") String data, @QueryParam(value = "$select") String filtros);

	@GET
	@Path("/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)")
	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPorPeriodo(
			@QueryParam(value = "@dataInicial") String dataInicial,
			@QueryParam(value = "@dataFinalCotacao") String dataFinal, 
			@QueryParam(value = "$orderby") String orderby,
			@QueryParam(value = "$top") Integer top);

	@GET
	@Path("/Moedas")
	public ConsultaBancoCentralDTO<MoedaBancoCentralDTO> buscarMoedas();

}
