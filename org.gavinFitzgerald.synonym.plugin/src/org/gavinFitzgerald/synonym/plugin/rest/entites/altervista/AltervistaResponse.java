package org.gavinFitzgerald.synonym.plugin.rest.entites.altervista;

import java.util.ArrayList;
import java.util.List;

public class AltervistaResponse {
	
	public List<Category> response; // name matches Altervista object, necessary
	
	public List<String> getPlainSynonyms() {
		List<String> plainSynonyms = new ArrayList<String>();
		for(Category categoryOfSynonyms : response) {
        	List<String> synonymsPerCategory = categoryOfSynonyms.list.getListSynoynms();
        	plainSynonyms.addAll(synonymsPerCategory);
        }
        
		return plainSynonyms;
	}

}
