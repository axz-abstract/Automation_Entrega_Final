package Tests;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.wdUtils;
import pages.HomePage;

public abstract class BaseTest {
	
	protected WebDriver driverc = null,driverf = null;
	protected HomePage homepage;
	protected wdUtils wd = new wdUtils();
	
	public WebDriver instanceofchrome() {
		if (driverc == null) {
			return new ChromeDriver();
		}
		else return driverc;
	}
	
	@BeforeMethod
	public void Beforeeach() {	/*ejecutar antes de cada test*/}

	@BeforeTest //ejecutar antes de todos los tests
	public void SetUp() {
		System.setProperty("base_dir",System.getProperty("user.dir").replace("target", "")); //al ejecutar desde maven la ruta del proyecto se modifica
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("base_dir"));
		
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER);
		System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER);
		//driverf = new FirefoxDriver();
		driverc = instanceofchrome();
		driverc.get(wd.getProperty("BASE_URL"));
		homepage = PageFactory.initElements(driverc, HomePage.class);
	}

	@AfterMethod
	public void Aftereach() {
		driverc.get(wd.getProperty("BASE_URL"));
	}

	@AfterTest
	public void TearDown() {
		driverc.quit();
	}
  
}
