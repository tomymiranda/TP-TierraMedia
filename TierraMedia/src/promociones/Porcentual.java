package promociones;

import java.util.Date;
import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Porcentual extends Promocion {

	private List<Atraccion> atracciones;
	private int costo = 0;
	private int costoDescuento;
	
	public Porcentual(String nombre, List<Atraccion> atracciones, String descripcion) {
		super(nombre, atracciones, descripcion);
		
		this.atracciones = atracciones;
		calcularCosto();
		super.setCosto(costo);
	}

	private void calcularCosto() {
		for(Atraccion atr : atracciones) {
			costo += atr.getCosto();
		}
	}
	
	private void aplicarDescuento() {
		
	}
	
	public int getCostoConDescuento() {
		return costoDescuento;
	}
	


}
