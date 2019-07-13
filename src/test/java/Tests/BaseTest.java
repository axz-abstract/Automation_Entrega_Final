package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Utils.Constants;
import Utils.wdUtils;
import pages.HomePage;

public abstract class BaseTest {
	
	protected WebDriver driverc = null,driverf = null;
	protected HomePage homepage;
	protected wdUtils wd = new wdUtils();
	
	public WebDriver instanceofchrome() {
		if (driverc == null) {
			if (wdUtils.isWindows())
				return new ChromeDriver();
			else {
				ChromeOptions chop = new ChromeOptions();
				chop.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
				return new ChromeDriver(chop);
			}	
		}
		else return driverc;
	}
	
	@BeforeMethod
	public void Beforeeach() {	/*ejecutar antes de cada test*/}

	@BeforeTest //ejecutar antes de todos los tests
	public void SetUp() {
		System.setProperty("base_dir",System.getProperty("user.dir").replace("target", "")); //al ejecutar desde maven la ruta del proyecto se modifica
		if (wdUtils.isWindows()) {
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_WIN);
			System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_WIN);
		} else {
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_LINUX);
			System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_LINUX);
		}
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
