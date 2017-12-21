import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTest {

	@Test
	public void testValidEmail() {
		String validEmail = "1net1@naver.com";
		EmailValidator emailValidator = new EmailValidator(validEmail);
		assertEquals(true, emailValidator.isValid());
	}
	
	@Test
	public void testInvalidEmail() {
		String invalidEmail = "IamNotValidEmailAddress@nowhere.co.co.com";
		EmailValidator emailValidator = new EmailValidator(invalidEmail);
		assertEquals(false, emailValidator.isValid());
	}

}
