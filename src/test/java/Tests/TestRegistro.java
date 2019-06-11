package Tests;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.wdUtils;
import pages.SignUpPage;

public class TestRegistro extends BaseTest {
	
	@DataProvider(name = "registros")
	public Iterator<Object []> provider() {
		return wdUtils.getCSV(Constants.CSV_FILE);
	}

	@Test(dataProvider = "registros")
	public void Registrar_Usarios(String nombre, String apellido, String email, String tel, String fax, String company, String dir1, String dir2, String city, String postal, String pass) {
		SignUpPage sp = this.homepage.RegistroUsuario();
		List<String> datos = Arrays.asList(nombre,apellido,email,tel,fax,company,dir1,dir2,city,postal,pass);
		String message = sp.RegistrarUsuario(datos);
		//System.out.println(message);
		Assert.assertTrue(message.contains("Your Account Has Been Created!"));
	}

}
