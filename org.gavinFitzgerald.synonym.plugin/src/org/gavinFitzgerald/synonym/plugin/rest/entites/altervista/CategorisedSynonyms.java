package org.gavinFitzgerald.synonym.plugin.rest.entites.altervista;

import java.util.Arrays;
import java.util.List;

public class CategorisedSynonyms {
	
	public String synonyms;
	public String category;

	private static String SEPARATOR = "\\|";
	
	public List<String> getListSynoynms() {
		String[] listOfSynonyms = synonyms.split(SEPARATOR);
		return Arrays.asList(listOfSynonyms);
	}
}
