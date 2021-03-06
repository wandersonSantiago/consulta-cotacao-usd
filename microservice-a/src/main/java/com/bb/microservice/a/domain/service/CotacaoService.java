package com.bb.microservice.a.domain.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.bb.microservice.a.restclient.CotacaoBancoCentralRest;
import com.bb.microservice.a.restclient.dto.ConsultaBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.CotacaoBancoCentralDTO;
import com.bb.microservice.a.restclient.dto.MoedaBancoCentralDTO;

@ApplicationScoped
public class CotacaoService {
	
	 public static final DateTimeFormatter FORMATADOR_MMDDYYYY = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	 
	@Inject
	@RestClient
	CotacaoBancoCentralRest rest;
		
	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPelaData(LocalDate data){		
		return rest.buscarCotacaoPelaData(formatDate(data), "cotacaoCompra,cotacaoVenda,dataHoraCotacao" );
	}

	public ConsultaBancoCentralDTO<CotacaoBancoCentralDTO> buscarCotacaoPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, String orderBy, Integer top){		
		return rest.buscarCotacaoPorPeriodo(formatDate(dataInicial),formatDate(dataFinal), orderBy , top);
	}
	
	public ConsultaBancoCentralDTO<MoedaBancoCentralDTO> buscarMoedas() {
		return rest.buscarMoedas();
	}
	
	private String formatDate(LocalDate date) {
		return "'" + date.format(FORMATADOR_MMDDYYYY) + "'";
	}

}
