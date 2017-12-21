import java.util.regex.Pattern;
public class EmailValidator {
	private String idRegEx = "\\w+";
	private String domainRegEx = "\\w+.\\w+.?\\w*";
	private String emailRegEx = idRegEx + "@" + domainRegEx;
	private String inputEmail;
	private boolean isValid;
	EmailValidator(String inputEmail){
		this.inputEmail = inputEmail;
		this.setValid(this.getValidation());
	}
	
	boolean getValidation() {
		return Pattern.matches(emailRegEx, this.inputEmail);
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
		
}
