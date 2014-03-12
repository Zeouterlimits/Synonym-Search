package org.gavinFitzgerald.synonym.plugin.search;

import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search2.internal.ui.InternalSearchUI;

public class SynonymSearchUI extends NewSearchUI {
	
	public static void runQueryInBackground(ISearchQuery query) throws IllegalArgumentException {
		if (query == null) {
			throw new IllegalArgumentException("query must not be null"); //$NON-NLS-1$
		}
		runQueryInBackground(query, null);
	}
	
	public static void runQueryInBackground(ISearchQuery query, ISearchResultViewPart view) throws IllegalArgumentException {
		if (query == null) {
			throw new IllegalArgumentException("query must not be null"); //$NON-NLS-1$
		}
		if (query.canRunInBackground())
			InternalSearchUI.getInstance().runSearchInBackground(query, view);
		else
			throw new IllegalArgumentException("Query can not be run in background"); //$NON-NLS-1$
	}
	
	

}
