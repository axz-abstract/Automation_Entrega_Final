package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Constants;
import page_methods.Registrar_Usuario;

public class SignUpPage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'input')]")
	List<WebElement> fieldList;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'newsletter') and @value='1']")
	WebElement btnSubscribe;
	
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement checkPolicy;

	public SignUpPage() throws IllegalAccessException {
		super(driver);
		this.isLoaded("de registro");
	}
	
	public String RegistrarUsuario(List<String> datos) {
		Registrar_Usuario.SignUp(fieldList,datos,btnSubscribe,checkPolicy);
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		SignUpSuccess sp = PageFactory.initElements(driver, SignUpSuccess.class);
		return sp.getMessage();
	}
	
	public By getPageLoadedLocator() {
		return By.xpath("//div[@id='content']/h1");
	}
	
}
