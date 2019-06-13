package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wdUtils {
	
	private static Properties prop = new Properties();
	
	public static boolean logged = false;
		
	public static boolean isElementPresent(WebDriver driver, final By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public wdUtils() {
		System.out.println("java.class:  === " + System.getProperty("java.class.path"));
		System.out.println("user.dir:    === " + System.getProperty("user.dir"));
		
		InputStream in = getClass().getResourceAsStream("config.properties");
		prop = new Properties();
		try {
			prop.load(in);
		} 	catch (FileNotFoundException e) {System.out.println("No se encontro el archivo");}
			catch (IOException e) {System.out.println("No se puede leer la propiedad");}
	}
	
	public String getProperty(String property) {
		return prop.getProperty(property);
	}
	
	public static void executeJS66(WebDriver driver,WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e);
	}
	
	public static void wait(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Iterator<Object[]> getCSV(String csvFile) {
		List<Object []> testCases = new ArrayList<>();
	      String[] data= null;
	      BufferedReader br = null;
	      String line = "";
	      String cvsSplitBy = ",";
	      try {
	    	  br = new BufferedReader(new FileReader(csvFile));
	      } catch (FileNotFoundException e1) {
	    	  // TODO Auto-generated catch block
	    	  e1.printStackTrace();
	      }
	      try {
	    	  while ((line = br.readLine()) != null) {
	    		  // coma como separador
	    		  data= line.split(cvsSplitBy);
	    		  testCases.add(data);
	    	  }
	      } catch (IOException e) {
	    	  // TODO Auto-generated catch block
	    	  e.printStackTrace();
	      }
	      testCases.remove(0);
	      return testCases.iterator();
	}

}
