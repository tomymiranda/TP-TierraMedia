package promociones;

import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Absoluta extends Promocion {

	private int costo = 0;

	public Absoluta(String nombre, List<Atraccion> atracciones, int costoAbsoluto, String descripcion) {
		super(nombre, atracciones, descripcion);

		this.costo = costoAbsoluto;
		super.setCosto(costo);
	}

	public int obtenerCosto() {
		return costo;
	}
}
