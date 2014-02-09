package org.gavinFitzgerald.synonym.plugin.dialog;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SearchTermInput extends ApplicationWindow {

	public SearchTermInput() {
		super(null);
	}
	
	public SearchTermInput(Shell parentShell) {
		super(parentShell);
	}
	
	/**
	   * Runs the application
	   */
	  public void run() {
	    // Don't return from open() until window closes
	    setBlockOnOpen(true);

	    // Open the main window
	    open();

	    // Dispose the display
	    Display.getCurrent().dispose();
	  }

	  /**
	   * Configures the shell
	   * 
	   * @param shell the shell
	   */
	  protected void configureShell(Shell shell) {
	    super.configureShell(shell);

	    // Set the title bar text
	    shell.setText("Get Input");
	  }

	  /**
	   * Creates the main window's contents
	   * 
	   * @param parent the main window
	   * @return Control
	   */
	  protected Control createContents(Composite parent) {
	    Composite composite = new Composite(parent, SWT.NONE);
	    composite.setLayout(new GridLayout(1, false));

	    // Create a label to display what the user typed in
	    final Label label = new Label(composite, SWT.NONE);
	    label.setText("This will display the user input from InputDialog");
	    
	    SearchTermSelectionWindow selectionWindow = new SearchTermSelectionWindow();
	    Dialog1 dialog = new Dialog1(Display.getCurrent().getActiveShell(),
	            "", "Enter 5-8 characters", label.getText(), new LengthValidator(), null);
	    dialog.open();
	    //selectionWindow.getFrame().setVisible(true);
	    
	    // Create the button to launch the error dialog
	    Button show = new Button(composite, SWT.PUSH);
	    show.setText("Get Input");
	    show.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
	            "", "Enter 5-8 characters", label.getText(), new LengthValidator());
	        if (dlg.open() == Window.OK) {
	          // User clicked OK; update the label with the input
	          label.setText(dlg.getValue());
	        }
	      }
	    });

	    parent.pack();
	    return composite;
	  }

	  /**
	   * The application entry point
	   * 
	   * @param args the command line arguments
	   */
	  public static void main(String[] args) {
	    new SearchTermInput().run();
	  }
	}

	/**
	 * This class validates a String. It makes sure that the String is between 5 and 8
	 * characters
	 */
	class LengthValidator implements IInputValidator {
	  /**
	   * Validates the String. Returns null for no error, or an error message
	   * 
	   * @param newText the String to validate
	   * @return String
	   */
	  public String isValid(String newText) {
	    int len = newText.length();

	    // Determine if input is too short or too long
	    if (len < 5) return "Too short";
	    if (len > 8) return "Too long";

	    // Input must be OK
	    return null;
	  }
	}
