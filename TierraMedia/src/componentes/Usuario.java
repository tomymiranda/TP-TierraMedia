package componentes;

import java.util.*;

import utilidades.Archivo;

public class Usuario {

	private String nombre;
	private int cantidadDeMonedas;
	private double tiempoDisponible;
	private TipoDeAtracciones tipoDeAtraccionPredilecta;
	private List<Atraccion> atraccionesSeleccionadas = new ArrayList<Atraccion>();
	private List<Promocion> promocionesSeleccionadas = new ArrayList<Promocion>();

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
	
	public void addPromocion(Promocion promocion) {
		promocionesSeleccionadas.add(promocion);
	}
	
	public List<Promocion> getPromocionesSeleccionadas(){
		return promocionesSeleccionadas;
	}
	
	public String getMonedasYTiempoRestante() {
		return "Monedas: " + cantidadDeMonedas + " | Tiempo Disponible: " + tiempoDisponible;
	}
	
	@Override
	public String toString() {
		return "nombre: " + nombre + " | Monedas: " + cantidadDeMonedas + " | Tiempo Disponible: " + tiempoDisponible;
	}
	
	public int compare(TipoDeAtracciones tipo) {
		if(tipo == this.tipoDeAtraccionPredilecta) {
			return 1;
		}
		else {
			return 0;
		}
	}


}
