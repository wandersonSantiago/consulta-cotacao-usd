package br.com.microservice.b.api.exceptions;

import java.io.Serializable;

public class DataNaoPermitidaException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public DataNaoPermitidaException() {
		super();
	}

	public DataNaoPermitidaException(String msg) {
		super(msg);
	}

}
