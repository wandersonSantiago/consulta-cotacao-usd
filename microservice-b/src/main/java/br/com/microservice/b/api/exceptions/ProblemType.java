package br.com.microservice.b.api.exceptions;

public enum ProblemType {

	RECURSO_NAO_ENCONTRADO("recurso-nao-encontrado", "Recurso não encontrado"),
	DADOS_INVALIDOS("dados-invalidos", "Dados inválidos");
	
	public String title;
	public String uri;

	ProblemType(String path, String title) {
		this.uri = "http://localhost:9091/" + path;
		this.title = title;
	}
}
