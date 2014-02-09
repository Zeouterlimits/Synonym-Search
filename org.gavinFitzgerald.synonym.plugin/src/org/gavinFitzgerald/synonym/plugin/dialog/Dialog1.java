package org.gavinFitzgerald.synonym.plugin.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class Dialog1 extends InputDialog {
	
	private List<Button> checkboxes;
	private Button checkbox;
	
	private boolean finalState;

	public Dialog1(Shell parentShell, String dialogTitle, String dialogMessage,
			String initialValue, IInputValidator validator, List<Button> checkboxes) {
		super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		
		this.checkboxes = checkboxes;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

//		for(Button checkbox : checkboxes) {
//			
//		}
		
		checkbox = new Button((Composite)((Composite)container).getChildren()[0], SWT.CHECK);
		checkbox.setText("test");
		checkbox.setSelection(false);
		
		return container;
	}
	
	public boolean isChecked() {
		return this.finalState;
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
		finalState = this.checkbox.getSelection();
		super.okPressed();
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
