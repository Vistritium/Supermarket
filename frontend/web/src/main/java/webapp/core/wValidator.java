package webapp.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class wValidator {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	
	
	public wValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	public boolean isEmailValid(String Email) {
		matcher = pattern.matcher(Email);
		return matcher.matches();
	}
	
	public String isValid(String Name, String Surname, String City, String Email, String Text) {
		boolean error = false;
		String output = new String();
		
		if(Name == null || Name.isEmpty()) {
			output += "Pole wymagane: imię</br>";
			error = true;
		}
		if(Email == null || Email.isEmpty()) {
			output += "Pole wymagane: e-mail </br>";
			error = true;
		} else {
			if(!isEmailValid(Email)) {
				output += "Wprowadzono błędny adres e-mail</br>";
				error = true;
			}
		}
		if(Text == null || Text.isEmpty()) {
			output += "Musisz wpisać wiadomość</br>";
			error = true;
		}
		
		if(error) {
			return output;
		} else {
			return "valid";
		}
	}
}
