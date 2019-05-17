package promociones;

import java.util.List;

import componentes.Atraccion;
import componentes.Promocion;

public class Porcentual extends Promocion {

	private List<Atraccion> atracciones;
	private int costo = 0;
	private int costoDescuento;
	private int porcentaje;
	
	public Porcentual(String nombre, List<Atraccion> atracciones, String descripcion, int porcentaje) {
		super(nombre, atracciones, descripcion);
		System.out.println("Porcentaje "+ porcentaje);
		this.atracciones = atracciones;
		this.porcentaje = porcentaje;
		calcularCosto();
		aplicarDescuento();
		super.setCosto(costo);
	}

	private void calcularCosto() {
		for(Atraccion atr : atracciones) {
			costo += atr.getCosto();
		}
	}
	
	private void aplicarDescuento() {
		if(porcentaje != 0) {
			this.costo -= costo/(porcentaje/100)+1; 
		}
	}
	
	public int getCostoConDescuento() {
		return costoDescuento;
	}
	


}
