package by.epamtc.protsko.rentcar.dao.validator;

import java.io.IOException;
import java.util.regex.Pattern;

import by.epamtc.protsko.rentcar.dao.reader.PropertyReader;
import by.epamtc.protsko.rentcar.dao.reader.PropertyReaderFactory;
import by.epamtc.protsko.rentcar.dao.reader.PropertyType;

public class DateOfBirthValidatorCommand implements CommandValidator {
	private PropertyReader propertyReader;
	private Pattern pattern;

	@Override
	public boolean execute(String userDateOfBirth) throws IOException {
		propertyReader = new PropertyReaderFactory().getPropertyReader(PropertyType.VALIDATOR_REGEX_PROPERTY);
		String dateOfBirthValidatorRegex = propertyReader.readProperty().getProperty("dateOfBirth.validator.regex");

		pattern = Pattern.compile(dateOfBirthValidatorRegex);

		return pattern.matcher(userDateOfBirth).matches();
	}

	@Override
	public String getDataEntryRules() {
		return "Ввод даты в формате dd-mm-yyyy";
	}
}
