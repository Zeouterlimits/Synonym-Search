package org.gavinFitzgerald.synonym.plugin.external.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.gavinFitzgerald.synonym.plugin.rest.entites.altervista.AltervistaResponse;
import org.gavinFitzgerald.synonym.plugin.rest.entites.altervista.Category;
import org.gavinFitzgerald.synonym.plugin.rest.getters.AlterVistaGet;
import org.gavinFitzgerald.synonym.plugin.rest.getters.Get;

import com.google.gson.Gson;

public class SearchAPI {

	public static List<String> getSynonyms(String selectedSynonymRepository,
			String initialSearchTerm) {
		
		Get getRequest;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		Gson gson = new Gson();
		AltervistaResponse altervistaResponse = null;
		List<String> synonyms = new ArrayList<>();
		
		try {
			getRequest = new AlterVistaGet();
			getRequest.setSearchTerm(initialSearchTerm);
			getRequest.buildURLWithRequestParams();
			
			// Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            
            // Body contains your json stirng
            String responseBody = httpClient.execute(getRequest, responseHandler);
            altervistaResponse = gson.fromJson(responseBody, AltervistaResponse.class);
            
            /*
            List<Category> categoriesWithSynonyms = altervistaResponse.categoriesWithSynonyms;
            
            for(Category categoryOfSynonyms : categoriesWithSynonyms) {
            	List<String> synonymsPerCategory = categoryOfSynonyms.list.getListSynoynms();
            	synonyms.addAll(synonymsPerCategory);
            }
            */
            synonyms = altervistaResponse.getPlainSynonyms();
            //List<String> synonyms = altervistaResponse.response.get(0).list.getListSynoynms();

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
		
		return synonyms;
	}


}

