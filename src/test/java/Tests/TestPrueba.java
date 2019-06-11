package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchResults;

public class TestPrueba extends BaseTest {
	
  @Test
  public void Busqueda_Productos() throws Exception {
	  SearchResults sr = this.homepage.Buscar_Producto("apple");
	  Assert.assertEquals(sr.getNombre(),"Apple Cinema 30" + '"');
	  Assert.assertTrue(sr.getPrecio().contains("110"));
  }
}
