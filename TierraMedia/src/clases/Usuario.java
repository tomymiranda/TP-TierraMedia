package clases;

import java.util.*;

public class Usuario {

	private String nombre;
	private int cantidadDeMonedas;
	private double tiempoDisponible;
	private TipoDeAtracciones tipoDeAtraccionPredilecta;
	private List<Atraccion> atraccionesSeleccionadas = new ArrayList<Atraccion>();

	public Usuario(String nombre, int cantidadDeMonedas, double tiempoDisponible, TipoDeAtracciones tipo) {

		this.nombre = nombre;
		this.cantidadDeMonedas = cantidadDeMonedas;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccionPredilecta = tipo;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadDeMonedas() {
		return cantidadDeMonedas;
	}

	public void setCantidadDeMonedas(int cantidadDeMonedas) {
		this.cantidadDeMonedas = cantidadDeMonedas;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public void setTipoAtraccionPredilecta(TipoDeAtracciones tipo) {
		this.tipoDeAtraccionPredilecta = tipo;
	}
	
	public TipoDeAtracciones getTipoAtraccionPredilecta() {
		return this.tipoDeAtraccionPredilecta;
	}
	
	public void addAtraccion(Atraccion atraccion) {
		this.atraccionesSeleccionadas.add(atraccion);
	}
	
	public List<Atraccion> getListaAtracciones(){
		return this.atraccionesSeleccionadas;
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + " | Monedas: " + cantidadDeMonedas + " | Tiempo Disponible: " + tiempoDisponible;
	}


}
