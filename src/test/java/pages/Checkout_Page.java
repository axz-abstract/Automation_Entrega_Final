package pages;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Constants;

public class Checkout_Page extends BasePage{
	
	@FindBy(how = How.ID, using = "button-payment-address")
	WebElement btnPayDir ;
	@FindBy(how = How.ID, using = "button-shipping-address")
	WebElement btnShipDir ;
	@FindBy(how = How.CSS, using = "textarea[name='comment']")
	WebElement textDelivery ;	
	@FindBy(how = How.ID, using = "button-shipping-method")
	WebElement btnDelivery ;
	@FindBy(how = How.CSS, using = "input[type='checkbox']")
	WebElement checkAgree ; 
	@FindBy(how = How.ID, using = "button-payment-method")
	WebElement btnPayment ;
	@FindBy(how = How.ID, using = "button-confirm")
	WebElement btnConfirm ;
	
	public Checkout_Page(WebDriver driver) throws IllegalAccessException {
		super(driver);
		isLoaded("de Checkout");
	}
	
	public View_Order confirmar_pedido() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		page_methods.Confirmar_Pedido.confirmar(js,Arrays.asList(btnPayDir,btnShipDir,textDelivery,btnDelivery,checkAgree,btnPayment,btnConfirm));
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		WebElement history = driver.findElement(By.xpath("//a[text()='history']"));
		history.click();
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		WebElement view = driver.findElement(By.xpath("//a[contains(@class,'info')][1]"));
		view.click();
		return PageFactory.initElements(driver, View_Order.class);
	}
	
	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h1[text()='Checkout']");
	}

}
