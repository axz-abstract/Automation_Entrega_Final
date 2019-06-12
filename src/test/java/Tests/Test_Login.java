package Tests;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.wdUtils;
import junit.framework.Assert;
import pages.LoginPage;
import pages.SearchResults;

public class Test_Login extends BaseTest{
	
	private LoginPage lp;
  
	@Test(dataProvider = "login",priority = 0)
	public void login(String mail,String pass) {
//		String mail = "cualquiercosas4646467@mail.com";
//		String pass = "Hola_1234";
		lp = homepage.SignIn();
		String message = lp.Login(mail, pass);
		Assert.assertEquals("My Account", message);
	}
	
	@Test(priority = 1)
	public void logout() {
		String message = lp.Logout();
		Assert.assertEquals("Account Logout", message);
	}
	
	@DataProvider(name = "login")
	public Iterator<Object []> provider() {
		return wdUtils.getCSV(Constants.LOGIN_CSV_FILE);
	}
}
