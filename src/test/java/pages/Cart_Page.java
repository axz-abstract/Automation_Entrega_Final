package pages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Constants;
import Utils.wdUtils;

public class Cart_Page extends BasePage{
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'collapse-ship')]" )
	private WebElement dropdownShipping;
	@FindBy(how = How.ID , using = "button-quote")
	private WebElement btnQuotes;
	@FindBy(how = How.XPATH , using = "//input[@name='shipping_method']")
	private WebElement radioShipping;
	@FindBy(how = How.ID , using = "button-shipping")
	private WebElement btnShipping;
//	@FindBy(how = How.XPATH , using = "//a[text()='Checkout']")
//	private WebElement btnCheckout;
//	@FindBy(how = How.CSS , using = "div[class='alert alert-danger']")
//	private WebElement alertMessage;
	@FindBy(how = How.XPATH , using = "//span[contains(text(),'***')]/ancestor::td/following::td/div/span/button[contains(@class,'danger')]")
	private WebElement btnDanger_Samsung;
//	@FindBy(how = How.XPATH , using = "//table[@class='table table-bordered']//td/a[text()='iPhone']/ancestor::td/following-sibling::td//button[contains(@class,'primary')]")
//	private WebElement btnUpdate_iPhone;
//	@FindBy(how = How.XPATH , using = "//table[@class='table table-bordered']//td/a[text()='iPhone']/ancestor::td/following-sibling::td//input")
//	private WebElement inputUpdate_iPhone;
	
	private String btnCheckout = "//div/a[contains(@href,'/checkout')]";
	private String alertMessage = "div[class='alert alert-danger']";
	private String btnUpdate_iPhone = "//table[@class='table table-bordered']//td/a[text()='iPhone']/ancestor::td/following-sibling::td//button[contains(@class,'primary')]";
	private String inputUpdate_iPhone = "//table[@class='table table-bordered']//td/a[text()='iPhone']/ancestor::td/following-sibling::td//input";

	public Cart_Page(WebDriver driver) throws IllegalAccessException {
		super(driver);
		isLoaded("del carrito de compras");
	}
	
	public String ordenar_productos() {
		page_methods.Realizar_Pedido.pedido(driver,Arrays.asList(dropdownShipping,btnQuotes,radioShipping,btnShipping));
		wdUtils.wait(2000);
		WebElement btn = driver.findElement(By.xpath(btnCheckout));
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		page_methods.Realizar_Pedido.mensaje_pedido(btn,js);
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		WebElement alert = driver.findElement(By.cssSelector(alertMessage));
		return alert.getText();
	}
	
	public Checkout_Page checkout() {
		btnDanger_Samsung.click();
		wdUtils.wait(2000);
		WebElement inputUpdate_iPhone = driver.findElement(By.xpath(this.inputUpdate_iPhone));
		inputUpdate_iPhone.clear();
		inputUpdate_iPhone.sendKeys("3");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		WebElement btnUpdate_iPhone = driver.findElement(By.xpath(this.btnUpdate_iPhone));
		btnUpdate_iPhone.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		WebElement btnCheckout = driver.findElement(By.xpath(this.btnCheckout));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btnCheckout);
		btnCheckout.click();
		return PageFactory.initElements(driver, Checkout_Page.class);
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h1[contains(text(),'Shopping Cart')]");
	}
	
	

}
