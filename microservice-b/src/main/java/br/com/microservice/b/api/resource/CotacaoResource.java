package br.com.microservice.b.api.resource;

import java.util.List;
import java.util.stream.Collectors;

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
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.microservice.b.api.dto.CotacaoDTO;
import br.com.microservice.b.api.exceptions.Problem;
import br.com.microservice.b.domain.DateUtils;
import br.com.microservice.b.domain.service.CotacaoService;

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
	@Operation(summary = "Cotação do Dólar atraves da data informada", description = "Realiza a busca de uma cotação pela data informada. retornando a cotação da data e do dia útil anterior")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = CotacaoDTO[].class))),
            @APIResponse(responseCode = "400", description="Data não permitida para a consulta",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Problem.class))),
            @APIResponse(responseCode = "404", description="Cotação não encontrada",
            		content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Problem.class)))
    })
	public List<CotacaoDTO> buscarCotacaoPelaData(
			 @Parameter(description = "Data tem que seguir o padrão 'yyyy-MM-dd'", required = true)
			 @PathParam(value = "dataCotacao") String dataCotacao) {

		return service.buscarCotacaoPelaData(DateUtils.converteParaLocalDate(dataCotacao)).stream()
				.map(cotacao -> new CotacaoDTO(cotacao)).collect(Collectors.toList());
	}

	@GET
	@Path(value = "/periodo/data-inicial/{dataInicial}/data-final/{dataFinal}")
	@Operation(summary = "Cotação do Dólar por periodo", description = "Realiza a busca de uma cotação pela data informada.")
	public List<CotacaoDTO> buscarCotacaoPorPeriodo(
			@Parameter(description = "Data tem que seguir o padrão 'yyy-MM-dd'", required = true)
			@PathParam(value = "dataInicial") String dataInicial,
			@Parameter(description = "Data tem que seguir o padrão 'yyy-MM-dd'", required = true)
			@PathParam(value = "dataFinal") String dataFinal, 
			@Parameter(description = "Quantidade de itens na consulta exemplo = '10'", required = true)
			@QueryParam(value = "top") Integer top) {
		
		return service.buscarCotacaoPorPeriodo(
				DateUtils.converteParaLocalDate(dataInicial),
				DateUtils.converteParaLocalDate(dataFinal),
				top)
				.stream()
				.map(cotacao -> new CotacaoDTO(cotacao)).collect(Collectors.toList());
	}

}