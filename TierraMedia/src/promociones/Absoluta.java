package promociones;

import java.util.Calendar;
import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Absoluta extends Promocion {

	public Absoluta(String nombre, int costo, List<Atraccion> atracciones, String descripcion) {
		super(nombre, atracciones, descripcion);
	}

	public void aplicarDescuento() {

	}

}
