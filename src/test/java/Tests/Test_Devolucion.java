package Tests;

import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.wdUtils;
import pages.HomePage;
import pages.LoginPage;
import pages.Return_Product;
import pages.View_Order;

public class Test_Devolucion extends BaseTest{
	
  @Test(dataProvider="login")
  public void devolucion(String mail,String pass) {
	  if (!wdUtils.logged) {
			LoginPage lp = homepage.SignIn();
			lp.Login(mail, pass);
	  }
	  driverc.get(wd.getProperty("BASE_URL"));
	  this.homepage = PageFactory.initElements(driverc, HomePage.class);
	  View_Order vo = homepage.getLastOrder();
	  Assert.assertEquals(vo.reorder_clean(),"iPhone");
	  Return_Product rp = vo.devolucion_producto();
	  Assert.assertEquals(rp.devolucion(),"Product Returns");
  }
  
  @DataProvider(name = "registros")
	public Iterator<Object []> provider() {
		return wdUtils.getCSV(Constants.LOGIN_CSV_FILE);
	}
  
//  @DataProvider(name="login")
//  public Object[][] getDataFromDataprovider(){
//  return new Object[][] 
//  	{
//          { "cualquiercosas4646467@mail.com","Hola_1234" },
//          { "cualquiercosas4646467@mail.com","Hola_1234" },
//          { "cualquiercosas4646467@mail.com","Hola_1234" }
//      };
//  }
}
