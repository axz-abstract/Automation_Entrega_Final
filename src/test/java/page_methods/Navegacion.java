package page_methods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navegacion {

	public static boolean navegacion(WebElement e){
		e.click();
		if (!e.getAttribute("class").contains("dropdown")) {
			return true;
		}
		return false;
	}

}
