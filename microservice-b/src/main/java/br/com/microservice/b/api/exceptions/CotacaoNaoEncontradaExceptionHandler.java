package br.com.microservice.b.api.exceptions;

import java.time.OffsetDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CotacaoNaoEncontradaExceptionHandler implements ExceptionMapper<CotacaoNaoEncontradaException> {

	@Override
	public Response toResponse(CotacaoNaoEncontradaException exception) {

		var problem = new Problem();
		problem.type = ProblemType.DADOS_INVALIDOS.uri;
		problem.detail = exception.getMessage();
		problem.timestamp = OffsetDateTime.now();
		problem.status = Status.BAD_REQUEST.getStatusCode();
		problem.title = ProblemType.DADOS_INVALIDOS.title;

		return Response.status(Status.BAD_REQUEST).entity(problem).build();
	}

}
