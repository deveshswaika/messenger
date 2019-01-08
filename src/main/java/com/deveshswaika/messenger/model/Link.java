package com.deveshswaika.messenger.model;
//for implementing hateoas - providing links in response
//completely restfull webservices
public class Link {
	private String link;
	private String rel;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	

}
