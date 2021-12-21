package br.com.microservice.b.restclient.dto;

import java.util.List;

public class ConsultaMIcroserviceADTO<T> {
	
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
