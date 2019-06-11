package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpSuccess extends BasePage {
	
	@FindBy(how = How.CSS, using = "#content h1")
	private WebElement signUpSuccess;
	
	public SignUpSuccess(WebDriver driver) throws IllegalAccessException {
		super(driver);
		this.isLoaded("de registro exitóso");
	}
	
	public String getMessage() {
		return this.signUpSuccess.getText();
	}

	@Override
	public By getPageLoadedLocator() {
		return By.cssSelector("#content h1");
	}

}
