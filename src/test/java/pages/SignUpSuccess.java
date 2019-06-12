package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class SignUpSuccess extends BasePage {
	
	@FindBy(how = How.CSS, using = "#content h1")
	private WebElement signUpSuccess;
	
	private String alertdanger = ".alert-danger";
	
	public SignUpSuccess(WebDriver driver) throws IllegalAccessException {
		super(driver);
		this.isLoaded("de registro exitóso");
	}
	
	public String getMessage() {
		try {
			driver.findElement(By.cssSelector(alertdanger));
			Assert.fail("Correo electrónico en uso");
		} catch (Exception e) {
			return this.signUpSuccess.getText();
		}
		return null;			
		
	}

	@Override
	public By getPageLoadedLocator() {
		return By.cssSelector("#content h1");
	}

}
