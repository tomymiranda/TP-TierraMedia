package promociones;

import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Porcentual extends Promocion {

	private List<Atraccion> atracciones;
	private int costo = 0;
	private int porcientoDescuento;

	public Porcentual(String nombre, List<Atraccion> atracciones, int porcientoDescuento, String descripcion) {
		super(nombre, atracciones, descripcion);

		this.atracciones = atracciones;
		this.porcientoDescuento = porcientoDescuento;
		calcularCosto();
		super.setCosto(costo);
	}

	private void calcularCosto() {
		for (Atraccion atr : atracciones) {
			costo += atr.getCosto();
		}
	}

	private void aplicarDescuento() {
		costo -= costo * 100 / porcientoDescuento;
	}

	public int obtenerCosto() {
		return costo;
	}
}
