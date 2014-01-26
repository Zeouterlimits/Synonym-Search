package org.gavinFitzgerald.synonym.plugin.rest.getters;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.client.utils.URLEncodedUtils;

public class AlterVistaGet extends Get {
	
	private static String INITIAL_URL = "http://thesaurus.altervista.org/thesaurus/v1";
	
	public AlterVistaGet() throws URISyntaxException {
		super();
	}
	
	private String key = "np0AkrjRBctza7ThKsRj";
	private String language = "en_US";
	private String output = "json";
	private String word;
	
	@Override
	public void setSearchTerm(String searchTerm) {
		this.word = searchTerm;
	}
	
	public void buildParams() {
		HttpParams params = new BasicHttpParams();
		params.setParameter("key", key);
		params.setParameter("language", language);
		params.setParameter("output", output);
		params.setParameter("word", word);
		this.params = params;
		this.setParams(params);
	}
	
	public void buildURLWithRequestParams() throws URISyntaxException{
		String urlWithParams = INITIAL_URL;
	    if(!urlWithParams.endsWith("?"))
	    	urlWithParams += "?";

	    List<NameValuePair> params = new LinkedList<NameValuePair>();

	    params.add(new BasicNameValuePair("key", key));
		params.add(new BasicNameValuePair("language", language));
		params.add(new BasicNameValuePair("output", output));
		params.add(new BasicNameValuePair("word", word));

	    String paramString = URLEncodedUtils.format(params, "utf-8");

	    urlWithParams += paramString;
	    
	    URI uri = new URI(urlWithParams);
		this.setURI(uri);
	}

	@Override
	public String toString() {
		return "AlterVistaGet [key=" + key + ", language=" + language
				+ ", output=" + output + ", word=" + word + ", accept="
				+ accept + ", jsonHeader=" + jsonHeader + ", headergroup="
				+ headergroup + ", params=" + params + ", getMethod()="
				+ getMethod() + ", getProtocolVersion()="
				+ getProtocolVersion() + ", getURI()=" + getURI()
				+ ", getRequestLine()=" + getRequestLine() + ", isAborted()="
				+ isAborted() + ", getAllHeaders()="
				+ Arrays.toString(getAllHeaders()) + ", headerIterator()="
				+ headerIterator() + ", getParams()=" + getParams()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

}
