package com.bb.microservice.a.core;

import java.time.LocalDate;

import javax.ws.rs.ext.ParamConverter;

public class LocalDateConverter implements ParamConverter<LocalDate> {

	@Override
	public LocalDate fromString(String value) {
		if (value == null)
			return null;
		return LocalDate.parse(value);
	}

	@Override
	public String toString(LocalDate value) {
		if (value == null)
			return null;
		return value.toString();
	}

}
