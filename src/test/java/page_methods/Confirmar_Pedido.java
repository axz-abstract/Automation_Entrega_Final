package page_methods;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utils.wdUtils;

public class Confirmar_Pedido {

	public static void confirmar(JavascriptExecutor js,List<WebElement> lista) {
		for (WebElement e : lista) {
			wdUtils.wait(800);
			js.executeScript("arguments[0].scrollIntoView(true);", e);
			if (e.getTagName().contains("textarea"))
				e.sendKeys("fees too expensive");
			else
				e.click();
		}
	}
}
