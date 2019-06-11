package page_methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Datos_Producto {
	
	private static String Price_new = "//span[@class='price-new']";
	
	public static String getPrice(List<WebElement> prodPrices) throws Exception {
		
		if (prodPrices.isEmpty())
			throw new Exception("No se encontraron productos con este nombre");
		else if (prodPrices.size() > 1)
			throw new Exception("Se encontró más de un producto con este nombre");
		else {
			WebElement e = prodPrices.get(0);
			List<WebElement> e2 = e.findElements(By.xpath(Price_new));
			if (e2.isEmpty())
				return e.getText();
			else
				return e2.get(0).getText();
		}
	}
	
	public static String getNombre(List<WebElement> prodNames) throws Exception {
		if (prodNames.isEmpty())
			throw new Exception("No se encontraron productos con este nombre");
		else if (prodNames.size() > 1)
			throw new Exception("Se encontró más de un producto con este nombre");
		else {
			return prodNames.get(0).getText();
		}
	}

}
