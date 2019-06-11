package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.wdUtils;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.HomePage;
import pages.LoginPage;
import pages.View_Order;

public class Test_CompraProductos extends BaseTest{


	@Test(dataProvider="login")
	public void compra_productos(String mail,String pass) throws InterruptedException{
		if (!wdUtils.logged) {
			LoginPage lp = homepage.SignIn();
			lp.Login(mail, pass);
		}
		driverc.get(wd.getProperty("BASE_URL"));
		this.homepage = PageFactory.initElements(driverc, HomePage.class);
		Cart_Page cp = homepage.agregar_productos_carrito();
		String asd = cp.ordenar_productos();
		Assert.assertTrue(asd.contains("Products marked with ***"));
		Checkout_Page chp = cp.checkout();
		View_Order vo = chp.confirmar_pedido();
		String confirm = vo.assertorder();
		Assert.assertTrue(confirm.contains("Order ID"));
		homepage.Logout();
	}
	
	@DataProvider(name="login")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "cualquiercosas4646467@mail.com","Hola_1234" },
            { "cualquiercosas4646467@mail.com","Hola_1234" },
            { "cualquiercosas4646467@mail.com","Hola_1234" }
        };
    }
}
