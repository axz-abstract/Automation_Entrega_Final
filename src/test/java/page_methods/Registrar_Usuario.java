package page_methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.wdUtils;

public class Registrar_Usuario {

	public static void SignUp(List<WebElement> lista, List<String> datos, WebElement subscribe, WebElement check) {
		int x=0;
		for (int i=0;i<lista.size();i++) {
			WebElement aux = lista.get(i);
			if (aux.getTagName().contains("input")) {
				aux.sendKeys(datos.get(x));
				if (x<10)
					x++;	
			}
			if (aux.getTagName().contains("select")) {
				aux.click();
				wdUtils.wait(3000);
				aux.findElements(By.xpath("option")).get(11).click();
			}
		}
		subscribe.click();
		check.click();
		check.submit();
	}
	
}
