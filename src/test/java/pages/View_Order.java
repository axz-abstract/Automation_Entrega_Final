package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.wdUtils;

public class View_Order extends BasePage {
	
	private String alertiPhone = "//div[contains(@class,'alert-success')]/a[text()='iPhone']";
	private String btnRemoveiPhone = "//button[contains(@class,'danger')]";
	
	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Order ID')]")
	private WebElement order;
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'primary')]")
	private WebElement btnReorderiPhone;
	@FindBy(how = How.CSS, using = "#cart button[data-toggle='dropdown']")
	private WebElement dropdownCart;
//	@FindBy(how = How.CSS, using = "//td[contains(text(),'HTC')]/following-sibling::td/a[contains(@class,'danger')]")
//	private WebElement btnReturnHTC;
	
	private String btnReturnHTC = "//td[contains(text(),'HTC')]/following-sibling::td/a[contains(@class,'danger')]";
	
	public View_Order(WebDriver driver) throws IllegalAccessException {
		super(driver);
		isLoaded("consulta de pedido");
	}
	
	public String reorder_clean() {
		btnReorderiPhone.click();
		wdUtils.wait(2000);
		dropdownCart.click();
		driver.findElement(By.xpath(btnRemoveiPhone)).click();
		return driver.findElement(By.xpath(alertiPhone)).getText();
	}
	
	public Return_Product devolucion_producto() {
		//btnReturnHTC.click();
		driver.findElement(By.xpath(btnReturnHTC)).click();;
		return PageFactory.initElements(driver, Return_Product.class);
	}
	
	public String assertorder() {
		return order.getText();
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h2[text()='Order Information']");
	}

}
