package org.gavinFitzgerald.synonym.plugin.external.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.gavinFitzgerald.synonym.plugin.rest.entites.altervista.Responses;
import org.gavinFitzgerald.synonym.plugin.rest.getters.AlterVistaGet;
import org.gavinFitzgerald.synonym.plugin.rest.getters.Get;

import com.google.gson.Gson;

public class SearchAPI {

	public static List<String> getSynonyms(String selectedSynonymRepository,
			String initialSearchTerm) {
		
		Get getRequest;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		Gson gson = new Gson();
		Responses response = null;
		int count = 1;
		try {
			getRequest = new AlterVistaGet();
			getRequest.setSearchTerm(initialSearchTerm);
			getRequest.buildURLWithRequestParams();
			
			// Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            
            // Body contains your json stirng
            String responseBody = httpClient.execute(getRequest, responseHandler);
            response = gson.fromJson(responseBody, Responses.class);
            
            //ArrayList<String> words = (ArrayList<String>) response.response.get(0).list.getListSynoynms();
            List<String> strings = response.response.get(0).list.getListSynoynms();
            
            System.out.println("Count: " + count);
            System.out.println(responseBody);
            count++;

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (HttpResponseException e) {
		    System.err.println(e);
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			httpClient.getConnectionManager().shutdown();
		}
		
		return response.response.get(0).list.getListSynoynms();
	}


}

