package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Utils.Constants;

public class SearchResults extends BasePage{
	
	@FindBy(how = How.XPATH, using = "//p[@class = 'price']" )
	List<WebElement> prodPrices;
	
	@FindBy(how = How.XPATH, using = "//div[@class = 'caption']/h4/a" )
	List<WebElement> prodNames;

	public SearchResults(WebDriver driver) throws IllegalAccessException {
		super(driver);
		//System.out.println("paso!!!");
		isLoaded("de  resultados de búsqueda");
	}
	
	public String getPrecio() throws Exception {
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		return page_methods.Datos_Producto.getPrice(prodPrices);
	}
	
	public String getNombre() throws Exception {
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		return page_methods.Datos_Producto.getNombre(prodNames);
	}

	@Override
	public By getPageLoadedLocator() {
		return By.xpath("//h2[text()='Products meeting the search criteria']");
	}

}
