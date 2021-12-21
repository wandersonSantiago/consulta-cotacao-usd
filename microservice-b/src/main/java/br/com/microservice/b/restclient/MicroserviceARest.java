package br.com.microservice.b.restclient;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.microservice.b.restclient.dto.ConsultaMIcroserviceADTO;
import br.com.microservice.b.restclient.dto.CotacaoMicroserviceADTO;

@Path("/v1")
@RegisterRestClient(configKey="br.com.microservice.a")
public interface MicroserviceARest {
	
	
	@GET
	@Path("/cotacoes/data/{dataCotacao}")
	public ConsultaMIcroserviceADTO<CotacaoMicroserviceADTO> buscarCotacaoPelaData(@PathParam(value = "dataCotacao") LocalDate data);
	
	
	@GET
	@Path(value = "/cotacoes/periodo/data-inicial/{dataInicial}/data-final/{dataFinal}")
	public ConsultaMIcroserviceADTO<CotacaoMicroserviceADTO> buscarCotacaoPorPeriodo(
			@PathParam(value = "dataInicial") LocalDate dataInicial,
			@PathParam(value = "dataFinal") LocalDate dataFinal, 
			@QueryParam(value = "top") Integer top);


	
}
