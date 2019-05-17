package promociones;

import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class AxB extends Promocion {

	private List<Atraccion> atracciones;
	private int costo = 0;
	private int costoDePromo;
	private String atraccionArestar;

	public AxB(String nombre, List<Atraccion> atracciones, String atraccionArestar, String descripcion) {
		super(nombre, atracciones, descripcion);

		this.atracciones = atracciones;
		this.atraccionArestar = atraccionArestar;
		calcularCosto();
		super.setCosto(costo);
	}

	private void calcularCosto() {
		for (Atraccion atr : atracciones) {
			if (atr.getNombre() != atraccionArestar)
				costo += atr.getCosto();
		}
	}

	public String obtenerAtraccionArestar() {
		return atraccionArestar;
	}

	public int obtenerCosto() {
		return costo;
	}

}
