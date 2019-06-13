package Tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SearchResults;

public class Test_Navegar_Buscar extends BaseTest{
	
	@Test(priority = 0)
	public void navegar() {
		List<String> lista = this.homepage.navigation();
		String[] listaesperada = {"Desktops","Laptops & Notebooks","Components","Tablets","Software","Phones & PDAs","Cameras","MP3 Players"};
		for (int i = 0; i < lista.size(); i++) {
			Assert.assertEquals(lista.get(i), listaesperada[i]);
		}
	}
	
	@Test(dataProvider="busqueda",priority = 1)
	public void buscar(String buscar) throws Exception {
		SearchResults sr = this.homepage.Buscar_Producto(buscar);
		Assert.assertTrue(sr.getNombre().toLowerCase().contains(buscar));
	}
	
	@DataProvider(name="busqueda")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "apple" },{ "camera" },{ "windows"},{"Android"},{"iphone"},{"samsung"},{"canon"}
        };
    }
}
