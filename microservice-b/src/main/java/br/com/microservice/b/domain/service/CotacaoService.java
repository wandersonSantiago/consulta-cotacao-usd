package br.com.microservice.b.domain.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.microservice.b.api.exceptions.CotacaoNaoEncontradaException;
import br.com.microservice.b.api.exceptions.DataNaoPermitidaException;
import br.com.microservice.b.domain.enuns.TipoCotacao;
import br.com.microservice.b.restclient.MicroserviceARest;
import br.com.microservice.b.restclient.dto.CotacaoMicroserviceADTO;

@ApplicationScoped
public class CotacaoService {

	@Inject
	@RestClient
	MicroserviceARest rest;

	
	public List<CotacaoMicroserviceADTO> buscarCotacaoPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Integer top ) {
		var result = rest.buscarCotacaoPorPeriodo(dataInicial, dataFinal, top);		
		return result.getValue();
	}
	
	
	public List<CotacaoMicroserviceADTO> buscarCotacaoPelaData(LocalDate data) {
		validarData(data);
		
		var cotacaoDataConsultada = buscarEConverter(data, TipoCotacao.DATA_ATUAL);
		
		var cotacaoDiaUtilAnterior = buscarUltimoDiaUtil(data.minusDays(1), TipoCotacao.ULTIMA_DATA_UTIL);
		
		return List.of(cotacaoDataConsultada, cotacaoDiaUtilAnterior);
	}
	
		
	/**
	 * Realiza a busca do ultimo dia util antes da data informada, entra em recursividade até encontrar uma válida
	 */	
	private CotacaoMicroserviceADTO buscarUltimoDiaUtil(LocalDate data, TipoCotacao tipoCotacao) {
		
		if (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return buscarUltimoDiaUtil(data.minusDays(1), tipoCotacao);
		}
		var result = rest.buscarCotacaoPelaData(data).findFirst();
		
		if(result == null) {
			return buscarUltimoDiaUtil(data.minusDays(1), tipoCotacao);
		}
		
		result.setTipo(tipoCotacao);
		
		return result;
	}


	/**
	 * Realiza a busca no microservice A e retorna a consulta, se não tiver cotação na data, lança uma exceção
	 */	
	private CotacaoMicroserviceADTO buscarEConverter(LocalDate data, TipoCotacao tipoCotacao) {
		var result = rest.buscarCotacaoPelaData(data).findFirst();
		
		if(result == null) {
			throw new CotacaoNaoEncontradaException("Não foi possivel encontrar uma cotação para esta data!");
		}
		result.setTipo(tipoCotacao);
		return result;
	}
	
	
	private void validarData(LocalDate data) {
		if (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new DataNaoPermitidaException("A data informada não é um dia Útil!");
		}
	}

}
