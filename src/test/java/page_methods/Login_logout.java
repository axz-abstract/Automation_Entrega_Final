package page_methods;

import java.util.List;

import org.openqa.selenium.WebElement;;

public class Login_logout {
	
	public static void login(String mail, String pass, List<WebElement> lista) {
		lista.get(0).sendKeys(mail);
		lista.get(1).sendKeys(pass);
		lista.get(2).click();
	}
	
	public static String assertLogin(WebElement e) {
		return e.getText();
	}
	
	public static void logout(List<WebElement> lista) {
		lista.get(0).click();
		lista.get(1).click();
	}
	
	public static String assertLogout(WebElement e) {
		return e.getText();
	}

}
