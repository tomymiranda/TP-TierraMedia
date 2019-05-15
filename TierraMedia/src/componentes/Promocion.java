package componentes;

import java.util.*;

public class Promocion {

	private String nombre;
	private int costo;
	//private Calendar validoHasta;
	private List<Atraccion> atracciones;
	private String descripcion;
	private double tiempoRequerido = 0;
	

	public Promocion(String nombre, List<Atraccion> atracciones, String descripcion) {
		this.nombre = nombre;
		//this.validoHasta = validoHasta;
		this.atracciones = atracciones;
		this.descripcion = descripcion;
		calcularTiempoRequerido();
	}

	public int getCosto() {
		return costo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void recorridoListaDeAtracciones() {
	}
	
	private void calcularTiempoRequerido() {
		for(Atraccion atr : atracciones) {
			tiempoRequerido += atr.getTiempoDeDuracion();
		}
	}

	@Override
	public String toString() {
		return nombre + " | Costo: " + costo + " | Tiempo: " + tiempoRequerido + " | Descripcion: " + descripcion;
	}
}
