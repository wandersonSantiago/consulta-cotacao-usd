package br.com.microservice.b.api.exceptions;

import java.io.Serializable;

public class CotacaoNaoEncontradaException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public CotacaoNaoEncontradaException() {
		super();
	}

	public CotacaoNaoEncontradaException(String msg) {
		super(msg);
	}

}
