package pruebas;

import org.junit.*;

import componentes.TipoDeAtracciones;
import componentes.Usuario;

public class UsuarioTest {

	@Test
	public void seCreaUsuario() {
		Usuario frodo = new Usuario("frodo", 100, 18.30, TipoDeAtracciones.Aventura);
		Assert.assertNotNull(frodo);

	}

	@Test
	public void seObtieneElNombreFrodo() {
		Usuario frodo = new Usuario("frodo", 100, 18.30, TipoDeAtracciones.Aventura);
		String a = frodo.getNombre();
		Assert.assertEquals("frodo", a);
	}

	@Test
	public void seObtieneLaCantidadDeMonedas() {
		Usuario frodo = new Usuario("frodo", 100, 18.30, TipoDeAtracciones.Aventura);
		int a = frodo.getCantidadDeMonedas();
		Assert.assertEquals(100, a);
	}

	@Test
	public void seObtieneElTiempo() {
		Usuario frodo = new Usuario("frodo", 100, 18.30, TipoDeAtracciones.Aventura);
		double b = frodo.getTiempoDisponible();
		Assert.assertEquals(18.30, b, 0.001);
	}





}
