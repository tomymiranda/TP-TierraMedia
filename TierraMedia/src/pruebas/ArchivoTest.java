package pruebas;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.*;
import componentes.*;
import utilidades.*;


public class ArchivoTest {
	Archivo archivo = null;
	
	@Before
	public void instanciarArchivo() {
		archivo = new Archivo();
	}
	
	@Test(expected = Test.None.class)
	public void leerArchivoExiste() throws Exception {
		archivo.LeerUsuarios("usuarios");
	}
	
	@Test(expected = Exception.class)
	public void leerArchivoNoExiste() throws Exception {
		archivo.LeerUsuarios("mouse");
	}
	
}
