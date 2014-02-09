package org.gavinFitzgerald.synonym.plugin.validator;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.IInputValidator;

public class InputValidator implements IInputValidator {

	@Override
	public String isValid(String newText) {
		if(StringUtils.isEmpty(newText))  return "Empty String!";
		return null;
	}

}
