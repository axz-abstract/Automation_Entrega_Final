package page_methods;

import org.openqa.selenium.WebElement;

public class Buscar_Producto {
	
	public static void buscar_producto(WebElement input, WebElement btn, String buscar){
		try {
			Thread.sleep(500);
			input.sendKeys(buscar);
			Thread.sleep(500);
			btn.click();
		} catch (InterruptedException e) {
		}
	}
}
