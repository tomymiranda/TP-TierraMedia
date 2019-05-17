package pruebas;

import org.junit.Assert;
import org.junit.Test;

import componentes.TipoDeAtracciones;
import componentes.Usuario;

import utilidades.Visualizador;

public class VisualizadorTest {
	@Test
	public void seCrea() {
		Visualizador visual = new Visualizador();
		Assert.assertNotNull(visual);

	}

	@Test
	public void seCreaElItirearario() {
		Visualizador visual = new Visualizador();
		Usuario frodo = new Usuario("frodo", 100, 18.30,
				TipoDeAtracciones.Aventura);
		String a = visual.generarItinerarioPorUsuario(frodo);
		Assert.assertNotNull(a);
	}
}
