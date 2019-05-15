package componentes;

import java.util.*;

public class Promocion {

	private String nombre;
	private int costo;
	//private Calendar validoHasta;
	private List<Atraccion> atracciones;
	private String descripcion;
	

	public Promocion(String nombre, List<Atraccion> atracciones, String descripcion) {
		this.nombre = nombre;
		//this.costo = costo;
		//this.validoHasta = validoHasta;
		this.atracciones = atracciones;
		this.descripcion = descripcion;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void recorridoListaDeAtracciones() {
	}
	@Override
	public String toString() {
		return "Promo Nombre: " + nombre;
	}

}
