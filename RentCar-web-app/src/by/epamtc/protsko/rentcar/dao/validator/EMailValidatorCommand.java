package by.epamtc.protsko.rentcar.dao.validator;

import java.io.IOException;
import java.util.regex.Pattern;

import by.epamtc.protsko.rentcar.dao.reader.PropertyReader;
import by.epamtc.protsko.rentcar.dao.reader.PropertyReaderFactory;
import by.epamtc.protsko.rentcar.dao.reader.PropertyType;

public class EMailValidatorCommand implements CommandValidator {
	private PropertyReader propertyReader;
	private Pattern pattern;

	@Override
	public boolean execute(String userEMail) throws IOException {
		propertyReader = new PropertyReaderFactory().getPropertyReader(PropertyType.VALIDATOR_REGEX_PROPERTY);
		String eMailValidatorRegex = propertyReader.readProperty().getProperty("email.validator.regex");

		pattern = Pattern.compile(eMailValidatorRegex);

		return pattern.matcher(userEMail).matches();
	}

	@Override
	public String getDataEntryRules() {
		return "";
	}
}
