package pruebas;

import org.junit.*;

import componentes.*;

public class UsuarioTest {

	Usuario usuario;
	
	@Before
	public void crearUsuario() {
		usuario = new Usuario("frodo", 100, 18.30, TipoDeAtracciones.Aventura);
	}
	
	@Test
	public void seCreaUsuario() {
		Assert.assertNotNull(usuario);

	}

	@Test
	public void obtenerNombre() {
		Assert.assertEquals("frodo", usuario.getNombre());
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

	@Test
	public void seAsignaAtraccionAUsuario() {
		usuario.addAtraccion(new Atraccion("Moria",10,2.0,6,TipoDeAtracciones.Paisaje));
		Assert.assertTrue(usuario.getListaAtracciones().size() > 0);
	}

	


}
