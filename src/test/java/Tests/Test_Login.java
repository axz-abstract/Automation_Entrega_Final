package Tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;
import pages.SearchResults;

public class Test_Login extends BaseTest{
	
	private LoginPage lp;
  
	@Test(priority = 0)
	public void login() {
		String mail = "cualquiercosas4646467@mail.com";
		String pass = "Hola_1234";
		lp = homepage.SignIn();
		String message = lp.Login(mail, pass);
		Assert.assertEquals("My Account", message);
	}
	
	@Test(priority = 1)
	public void logout() {
		String message = lp.Logout();
		Assert.assertEquals("Account Logout", message);
	}
}
