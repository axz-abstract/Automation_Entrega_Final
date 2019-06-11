package pages;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utils.Constants;
import Utils.wdUtils;

public class LoginPage extends BasePage {
	
	@FindBy(how = How.ID, using = "input-email")
	private WebElement inputEmail;
	@FindBy(how = How.ID, using = "input-password")
	private WebElement inputPass;
	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement btnSubmit;
	@FindBy(how = How.XPATH, using = "//li/a[contains(@href,'/logout')]")
	private WebElement btnLogout;
	@FindBy(how = How.XPATH, using = "//a[@title='My Account' and contains(@class,'dropdown')]")
	private WebElement dropdown;
	
	
	
	private String loginSuccess = "#content h2";
	private String logoutSuccess = "#content h1";
	
	public LoginPage(WebDriver driver) throws IllegalAccessException{
		super(driver);
		this.isLoaded("de login");
	}
	
	public String Login(String mail, String pass) {
		page_methods.Login_logout.login(mail,pass,Arrays.asList(inputEmail,inputPass,btnSubmit));
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		try { 
			String result = page_methods.Login_logout.assertLogin(driver.findElement(By.cssSelector(loginSuccess)));
			wdUtils.logged = true;
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String Logout() {
		try {
			page_methods.Login_logout.logout(Arrays.asList(dropdown,btnLogout));
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebElement logout = driver.findElement(By.cssSelector(logoutSuccess));
			wdUtils.logged = false;
			return page_methods.Login_logout.assertLogout(logout);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h2[text()='Returning Customer']");
	}

}
