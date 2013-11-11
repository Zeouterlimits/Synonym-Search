package org.gavinFitzgerald.synonym.plugin.page;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.gavinFitzgerald.synonym.plugin.external.api.SearchAPI;

public class SynonymSearchPage extends DialogPage implements ISearchPage  {
	
	public static final String ID = "org.gavinFitzgerald.synonym.plugin.page.SynonymSearchPage";

	private Text searchText;
	
	private Text selectedSynonymRepositoryText;
	
	private ISearchPageContainer pageContainer;
	
	private Composite composite;
	
	@Override
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		// layout.marginHeight = 0;
		// layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);

		//createRepositoryGroup(composite);

		setControl(composite);
		Dialog.applyDialogFont(composite);
		
	}

	@Override
	public boolean performAction() {
		String initialSearchTerm = searchText.getText();
		String selectedSynonymRepository = selectedSynonymRepositoryText.getText();
		
		//if(!StringUtils.isEmpty(initialSearchTerm))
		
		if (initialSearchTerm != null && initialSearchTerm.trim().length() > 0) {
			initialSearchTerm = initialSearchTerm.trim();
			
			List<String> synonyms = SearchAPI.getSynonyms(selectedSynonymRepository, initialSearchTerm);
			
			if (synonyms.size() > 0) {
//				MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
//						Messages.TaskSearchPage_Task_Search, Messages.TaskSearchPage_No_task_found_matching_key_ + key);
				
				MessageDialog.openInformation(null, "Hello", "You Searched for: " + initialSearchTerm);
			} else {
				//TODO: Show no synonyms found screen ?
			}
			return true;
		} else {
			//TODO: show error screen
			return false;
		}
	}

	@Override
	public void setContainer(ISearchPageContainer arg0) {
		this.pageContainer = arg0;
	}

}
