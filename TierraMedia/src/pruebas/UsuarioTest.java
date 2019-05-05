package Test;

import org.junit.Assert;
import org.junit.Test;

import Clases.Usuario;

public class UsuarioTest {

	@Test
	public void seCreaUsuario() {
		Usuario frodo = new Usuario("frodo", 100, 18.30);
		Assert.assertNotNull(frodo);

	}

	@Test
	public void seObtieneElNombreFrodo() {
		Usuario frodo = new Usuario("frodo", 100, 18.30);
		String a = frodo.getNombre();
		Assert.assertEquals("frodo", a);
	}

	@Test
	public void seObtieneLaCantidadDeMonedas() {
		Usuario frodo = new Usuario("frodo", 100, 18.30);
		int a = frodo.getCantidadDeMonedas();
		Assert.assertEquals(100, a);
	}

	@Test
	public void seObtieneElTiempo() {
		Usuario frodo = new Usuario("frodo", 100, 18.30);
		double b = frodo.getTiempoDisponible();
		Assert.assertEquals(18.30, b, 0.001);
	}





}
