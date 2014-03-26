package org.gavinFitzgerald.synonym.plugin.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class SearchTermDialog extends Dialog {
	
	private List<Button> checkboxes;
	private List<String> inputSynonyms;
	private List<String> selectedSynonyms;
	
	private boolean atLeastOneSelection;

	public SearchTermDialog(Shell parentShell) {
		super(parentShell);
		
		atLeastOneSelection = false;
		inputSynonyms = new ArrayList<String>();
		selectedSynonyms = new ArrayList<String>();
		checkboxes = new ArrayList<Button>();
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		buildCheckboxes(container);
		
		return container;
	}

	private void buildCheckboxes(Composite container) {
		try {
			for(String checkboxText : inputSynonyms) {
				Button checkbox = new Button(container, SWT.CHECK);
				checkbox.setText(checkboxText);
				checkbox.setSelection(false);
				
				checkboxes.add(checkbox);
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean hasAtLeastOneSelection() {
		return this.atLeastOneSelection;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	protected void okPressed() {
		this.setSelectedSynonyms(buildSelectedSynonyms());
		
		if(!selectedSynonyms.isEmpty()) atLeastOneSelection = true;
		
		super.okPressed();
	}
	
	private List<String> buildSelectedSynonyms() {
		List<String> selectedSynonyms = new ArrayList<>();
		for(Button button : this.checkboxes) {
			if(button.getSelection()) {
				selectedSynonyms.add(button.getText());
			}
		}
		return selectedSynonyms;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public List<String> getInputSynonyms() {
		return inputSynonyms;
	}

	public void setInputSynonyms(List<String> synonyms) {
		this.inputSynonyms = synonyms;
	}

	public List<String> getSelectedSynonyms() {
		return selectedSynonyms;
	}

	public void setSelectedSynonyms(List<String> selectedSynonyms) {
		this.selectedSynonyms = selectedSynonyms;
	}

}
