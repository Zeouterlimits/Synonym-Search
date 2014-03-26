package org.gavinFitzgerald.synonym.plugin.rest.entites.altervista;

import java.util.ArrayList;
import java.util.List;

public class Synonyms {
	
	public String synonyms;
	public String category;

	private static String SYNONYMS_SEPARATOR = "\\|";
	private static String DESCRIPTION_SEPARATOR = " ";
	
	public List<String> getListSynoynms() {
		String[] listOfSynonymsWithDescriptions = synonyms.split(SYNONYMS_SEPARATOR);
		List<String> synonymsWithoutDescriptions = new ArrayList<>();
		
		for(String synonymWithDescription : listOfSynonymsWithDescriptions) {
			String[] wordsSplitOnNonAlphanNumerics = synonymWithDescription.split(DESCRIPTION_SEPARATOR);
			
			String synonym = wordsSplitOnNonAlphanNumerics[0];
			synonymsWithoutDescriptions.add(synonym);
		}
		
		return synonymsWithoutDescriptions;
	}
}
