package com.bb.microservice.a.core;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;


@OpenAPIDefinition(
	    info = @Info(
	        title="Api teste de integração com o Banco Central",
	        version = "0.0.1",
	        contact = @Contact(	        		
	            name = "Teste de integração com o Banco Central",
	            url = "https://github.com/wandersonSantiago",
	            email = "wandersonsantiago86@gmail.com"),
	        license = @License(
	            name = "Proprietário",
	            url = "https://github.com/wandersonSantiago"))	   
	)
public class ApiApplication extends Application{

}
