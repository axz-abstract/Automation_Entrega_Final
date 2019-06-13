package page_methods;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Devolver_Producto {

	public static void devolver(List<WebElement> lista) {
		lista.get(0).clear();
		lista.get(0).sendKeys("5");
		lista.get(1).click();
		lista.get(2).click();
		lista.get(3).sendKeys("This product doesn’t even start, it’s a piece of crap");
		lista.get(4).click();
	}
}
