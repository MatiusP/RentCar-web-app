package by.epamtc.protsko.rentcar.dao.validator;

import java.io.IOException;
import java.util.regex.Pattern;

import by.epamtc.protsko.rentcar.dao.reader.PropertyReader;
import by.epamtc.protsko.rentcar.dao.reader.PropertyReaderFactory;
import by.epamtc.protsko.rentcar.dao.reader.PropertyType;

public class PhoneValidatorCommand implements CommandValidator {
	private PropertyReader propertyReader;
	private Pattern pattern;

	@Override
	public boolean execute(String userPhone) throws IOException {
		propertyReader = new PropertyReaderFactory().getPropertyReader(PropertyType.VALIDATOR_REGEX_PROPERTY);
		String phoneValidatorRegex = propertyReader.readProperty().getProperty("phone.validator.regex");

		pattern = Pattern.compile(phoneValidatorRegex);

		return pattern.matcher(userPhone).matches();
	}

	@Override
	public String getDataEntryRules() {
		return "";
	}
}
