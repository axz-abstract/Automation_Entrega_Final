package Utils;

public class Constants {
	
	public static final int PAGETIMEOUT = 120;
	public static final int WEBELEMTIMEOUT = 10;
	public static final String FIREFOX_DRIVER_WIN = System.getProperty("base_dir")+"/src/test/java/drivers/geckodriver.exe";
	public static final String FIREFOX_DRIVER_LINUX = System.getProperty("base_dir")+"/src/test/java/drivers/geckodriver";
	public static final String CHROME_DRIVER_WIN = System.getProperty("base_dir")+"/src/test/java/drivers/chromedriver.exe";
	public static final String CHROME_DRIVER_LINUX = System.getProperty("base_dir")+"/src/test/java/drivers/chromedriver";
	public static final String SIGNUP_CSV_FILE = System.getProperty("base_dir")+"/src/test/java/Utils/registro.csv";
	public static final String LOGIN_CSV_FILE = System.getProperty("base_dir")+"/src/test/java/Utils/login.csv";

}
