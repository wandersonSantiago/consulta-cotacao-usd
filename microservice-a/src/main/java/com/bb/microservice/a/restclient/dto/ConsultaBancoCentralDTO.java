package com.bb.microservice.a.restclient.dto;

import java.util.List;

public class ConsultaBancoCentralDTO<T> {
	
	private String link;
	private List<T> value;
	
	
	public int getSize() {
		return value.size();
	}
	
	public T findFirst() {
		return value.isEmpty() ? null :  value.get(0);
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<T> getValue() {
		return value;
	}
	public void setValue(List<T> value) {
		this.value = value;
	}
	
	
	

}
