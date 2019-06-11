package pages;

import java.awt.im.InputContext;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utils.wdUtils;

public class Return_Product extends BasePage{
	
	@FindBy(how = How.ID, using = "input-quantity")
	private WebElement inputQuantity;
	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value=4]")
	private WebElement inputReason;
	@FindBy(how = How.XPATH, using = "//input[@value='1' and @name='opened']")
	private WebElement inputOpened;
	@FindBy(how = How.ID, using = "input-comment")
	private WebElement textComment;
	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement inputSubmit;
	
	private String returnHeader = "//h1[text()='Product Returns']";
	private String btnContinue = "//a[contains(text(),'Continue')]";
	
	
	public Return_Product(WebDriver driver) throws IllegalAccessException {
		super(driver);
		isLoaded("de devolución de producto");
	}
	
	public String devolucion() {
		page_methods.Devolver_Producto.devolver(Arrays.asList(inputQuantity,inputReason,inputOpened,textComment,inputSubmit));
		wdUtils.wait(1000);
		String message = driver.findElement(By.xpath(returnHeader)).getText();
		driver.findElement(By.xpath(btnContinue)).click();
		return message;
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h1[text()='Product Returns']");
	}

	
}
