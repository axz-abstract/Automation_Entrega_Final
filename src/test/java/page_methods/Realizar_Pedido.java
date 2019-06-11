package page_methods;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utils.Constants;
import Utils.wdUtils;

public class Realizar_Pedido {
	
	public static void pedido(WebDriver driver,List<WebElement> lista) {
		for (WebElement e : lista) {
			wdUtils.wait(1500);
			e.click();
		}
	}

	public static void mensaje_pedido(WebElement btn,JavascriptExecutor js) {
		js.executeScript("arguments[0].scrollIntoView(true);", btn);
		wdUtils.wait(500);
		btn.click();
	}
}
