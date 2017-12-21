import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailAddrExtracter {
	public static void main(String[] args) {
		String domainRegEx = "\\w+.\\w+.?\\w*";
		String emailRegEx = "\\w+@" + domainRegEx;
		String inputEmail = "1net1@naver.com";
		String invalidEmail_noDomain  = "IVALIDEMAIL";
		Pattern emailRegPattern = Pattern.compile(emailRegEx);
		boolean emailValid = Pattern.matches(emailRegEx, inputEmail);
		boolean emailInValid = Pattern.matches(emailRegEx, invalidEmail_noDomain);
		System.out.println(emailValid);
		System.out.println(emailInValid);
		System.out.println(emailRegPattern.matcher(inputEmail).group());
	}
}
