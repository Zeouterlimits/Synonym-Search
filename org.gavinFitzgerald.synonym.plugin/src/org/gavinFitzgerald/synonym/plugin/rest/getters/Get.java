package org.gavinFitzgerald.synonym.plugin.rest.getters;

import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;

public abstract class Get extends HttpGet {
	
	public Get() {
		this.addHeader(accept, jsonHeader);
	}
	
	public abstract void setSearchTerm(String searchTerm);
	public abstract void buildURLWithRequestParams() throws URISyntaxException;

	public String accept = "accept";
	public String jsonHeader = "application/json";
	
}
