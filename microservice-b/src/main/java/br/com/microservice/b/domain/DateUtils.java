package br.com.microservice.b.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.microservice.b.api.exceptions.DataNaoPermitidaException;

public class DateUtils {
	
	public static DateTimeFormatter  FORMATADOR_YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static LocalDate converteParaLocalDate(String data) {
		try {
			return LocalDate.parse(data);
		} catch (Exception e) {
			throw new DataNaoPermitidaException("Data Inválida, utilizar o padrão 'yyyy-MM-dd");
		}
	}
	
	public static LocalDateTime converteParaLocalDateTime(String data) {
		try {
			return LocalDateTime.parse(data, FORMATADOR_YYYYMMDD);
		} catch (Exception e) {
			throw new DataNaoPermitidaException("Data Inválida");
		}
	}
	
	

}
