package org.gavinFitzgerald.synonym.plugin.external.api;

import java.util.ArrayList;
import java.util.List;

public class SearchAPI {

	public static List<String> getSynonyms(String selectedSynonymRepository,
			String initialSearchTerm) {
		//TODO: Implement Network connection
		List<String> toBeOverwritten = new ArrayList<String>();
		toBeOverwritten.add("temp");
		return toBeOverwritten;
	}

}
