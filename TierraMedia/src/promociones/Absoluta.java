package promociones;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Absoluta extends Promocion {

	public Absoluta(String nombre, int costo, Calendar validoHasta, List<Atraccion> atracciones) {
		super(nombre, costo, validoHasta, atracciones);
	}

	public void aplicarDescuento() {

	}

}
