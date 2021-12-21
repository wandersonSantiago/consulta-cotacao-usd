package br.com.microservice.b.api.dto;

import br.com.microservice.b.restclient.dto.MoedaMicroserviceADTO;

public class MoedaDTO {
	
	private String simbolo;
	private String nomeFormatado;
	private String tipoMoeda;
	
	
	public MoedaDTO(MoedaMicroserviceADTO dto) {
		this.simbolo = dto.getSimbolo();
		this.nomeFormatado = dto.getNomeFormatado();
		this.tipoMoeda = dto.getTipoMoeda();
	}
	
	
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	public String getNomeFormatado() {
		return nomeFormatado;
	}
	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}
	public String getTipoMoeda() {
		return tipoMoeda;
	}
	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}
	
	
	
	
	
}
