package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Constants;
import Utils.wdUtils;

public class HomePage extends BasePage{
	
	private String headerCategory = "#content h2";
	private String cartCategory = "//div[@class='button-group']/descendant::button[1]";
	private String cleanCartCSS = "#cart button[title='Remove']";
	private String cartCount = "#cart-total";
			
	@FindBy(how = How.CSS, using = "a[title='Shopping Cart']")
	private WebElement btnCart;
	
	@FindBy(how = How.CSS, using = "#cart button[title='Remove']")
	private List<WebElement> cleanCart;
			
	@FindBy(how = How.CSS, using = "#cart button[data-toggle='dropdown']")
	private WebElement dropdownCart;
	
	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='search']")
	private WebElement inputBuscar;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default btn-lg']")
	private WebElement btnBuscar;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/register')]")
	private WebElement btnRegistro;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/login')]")
	private WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'/logout')]")
	private WebElement btnLogout;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'account/order')]")
	private WebElement btnOrderHistory;
	
	@FindBy(how = How.XPATH, using = "//a[@title='My Account' and contains(@class,'dropdown')]")
	private WebElement dropdown;
	
	//Menú Categorías
	@FindBy(how = How.XPATH, using = "//a[text()='Desktops' and contains(@class,'dropdown')]" )
	WebElement dropdownDesktop;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Desktops')]" ) //a[contains(text(),'All Laptops')]
	WebElement liDesktop;
	@FindBy(how = How.XPATH, using = "//a[text()='Laptops & Notebooks' and contains(@class,'dropdown')]" )
	WebElement dropdownLaptops;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Laptops')]" ) 
	WebElement liLaptops;
	@FindBy(how = How.XPATH, using = "//a[text()='Components' and contains(@class,'dropdown')]" )
	WebElement dropdownComponent;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Components')]" )
	WebElement liComponent; 
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Tablets')]" )
	WebElement liTablets;
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Software')]" )
	WebElement liSoftware;
	@FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Phones')]" )
	WebElement liPhones;
	@FindBy(how = How.XPATH, using = "//li/a[text()='Cameras']" )
	WebElement liCameras;
	@FindBy(how = How.XPATH, using = "//li/a[text()='MP3 Players']" )
	WebElement dropdownMp3;
	@FindBy(how = How.XPATH, using = "//a[text()='Show All MP3 Players']" )
	WebElement liMp3;
	
	public HomePage(WebDriver driver) throws IllegalAccessException {
		super(driver);
		//HomePage.wd.getProperty("HomePage_InputBuscar");
		isLoaded("principal");
	}
	
	public LoginPage SignIn() {
		dropdown.click();
		btnLogin.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public View_Order getLastOrder() {
		clean_cart();
		dropdown.click();
		btnOrderHistory.click();
		driver.findElement(By.xpath("//a[contains(@class,'info')][1]")).click();
		return PageFactory.initElements(driver, View_Order.class);
	}
	
	public void Logout() {
		dropdown.click();
		btnLogout.click();
		wdUtils.logged = false;
	}
	
	public SignUpPage RegistroUsuario() {
		dropdown.click();
		btnRegistro.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SearchResults Buscar_Producto(String buscar) {
		page_methods.Buscar_Producto.buscar_producto(inputBuscar, btnBuscar, buscar);
		return PageFactory.initElements(driver, SearchResults.class);
	}
	
	public List<String> navigation() {
		List<String> list_toassert = new ArrayList<String>();
		List<WebElement> lista = Arrays.asList(dropdownDesktop,liDesktop,dropdownLaptops,liLaptops,dropdownComponent,liComponent,liTablets,liSoftware,liPhones,liCameras,dropdownMp3,liMp3);
		for (int i = 0; i < lista.size(); i++) {
			if (page_methods.Navegacion.navegacion(lista.get(i))) {
				WebElement aux = driver.findElement(By.cssSelector(headerCategory));
				list_toassert.add(aux.getText());
			}
		}
		return list_toassert;
	}
	
	public void clean_cart() {
		WebElement e = driver.findElement(By.cssSelector(cartCount));
		if (!e.getText().contains("0 item"))
			do { // es necesario repetir la acción para vacíar el carrito recargando la lista y el texto del contador
				e = driver.findElement(By.cssSelector(cartCount));
				dropdownCart.click();
				wdUtils.wait(1000);
				List<WebElement> aux = driver.findElements(By.cssSelector(cleanCartCSS));
				aux.get(0).click();
				wdUtils.wait(1000);
				e = driver.findElement(By.cssSelector(cartCount));
			} while (!e.getText().contains("0 item"));
	}
	
	public Cart_Page agregar_productos_carrito() {
		clean_cart();
		liTablets.click();
		WebDriverWait wait=new WebDriverWait(driver, Constants.WEBELEMTIMEOUT);
		WebElement cart;
		cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartCategory)));
		cart.click();
		liPhones.click();
		driver.manage().timeouts().implicitlyWait(Constants.WEBELEMTIMEOUT, TimeUnit.SECONDS);
		List<WebElement> lista = driver.findElements(By.xpath(cartCategory));
		wdUtils.executeJS66(driver, lista.get(0));
		lista.get(0).click();
		wdUtils.wait(800);
		wdUtils.executeJS66(driver, lista.get(1));
		lista.get(1).click();
		wdUtils.wait(800);
		btnCart.click();
		return PageFactory.initElements(driver, Cart_Page.class);		
	}
	

	@Override
	public By getPageLoadedLocator() {
		//return By.xpath("//div[@id='slideshow0']");
		return By.id("slideshow0");
	}

}
