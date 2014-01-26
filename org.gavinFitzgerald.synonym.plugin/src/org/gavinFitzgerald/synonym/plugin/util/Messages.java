package org.gavinFitzgerald.synonym.plugin.util;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	
	private static final String BUNDLE_NAME= "org.gavinFitzgerald.synonym.plugin.util.Messages";//$NON-NLS-1$

	private Messages() {
		// Do not instantiate
	}

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

	public static String TextSearchPage_replace_searchproblems_title;
	public static String TextSearchPage_replace_searchproblems_message;

}
