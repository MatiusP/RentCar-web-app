package by.epamtc.protsko.rentcar.dao.validator;

import java.io.IOException;
import java.util.regex.Pattern;

import by.epamtc.protsko.rentcar.dao.reader.PropertyReader;
import by.epamtc.protsko.rentcar.dao.reader.PropertyReaderFactory;
import by.epamtc.protsko.rentcar.dao.reader.PropertyType;

public class LoginValidatorCommand implements CommandValidator {
	private PropertyReader propertyReader;
	private Pattern pattern;

	@Override
	public boolean execute(String userLogin) throws IOException {
		propertyReader = new PropertyReaderFactory().getPropertyReader(PropertyType.VALIDATOR_REGEX_PROPERTY);
		String loginValidatorRegex = propertyReader.readProperty().getProperty("login.validator.regex");

		pattern = Pattern.compile(loginValidatorRegex);

		return pattern.matcher(userLogin).matches();
	}

	@Override
	public String getDataEntryRules() {
		return "Логин может содержать латинские либо русские буквы и цифры. Длина логина: от 5 до 45 символов";
	}
}
