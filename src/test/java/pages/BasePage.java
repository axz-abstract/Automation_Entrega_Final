package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.Constants;
import Utils.wdUtils;

public abstract class BasePage {
	
	public static WebDriver driver;
	protected static wdUtils wd = new wdUtils();
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		driver.manage().timeouts().implicitlyWait(Constants.PAGETIMEOUT, TimeUnit.SECONDS);
	}
	
	public final void isLoaded(String page) throws IllegalAccessException {
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		if(!wdUtils.isElementPresent(driver, this.getPageLoadedLocator())) {
			throw new IllegalAccessException("No es la página "+ page +" de Abstracta Opencart");
		}	
	}
	
	public abstract By getPageLoadedLocator();


}
