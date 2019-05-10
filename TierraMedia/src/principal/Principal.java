package principal;
import utilidades.*;

import java.io.*;
import java.util.*;

import componentes.*;

public class Principal {

	private static List<Atraccion> listaAtraccionesUsuario; 
	private static List<Atraccion> atraccionesParaUsuario;
	private static int atraccionSeleccionada;
	
	public static void main(String[] args) throws Exception {
		List<Usuario> listaUsuarios = Archivo.Leer("usuarios");
		List<Atraccion> listaAtraccionesGeneral = Archivo.Leer("atracciones");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		for(Usuario usuario : listaUsuarios) {
			listaAtraccionesUsuario = new ArrayList<Atraccion>();
			listaAtraccionesUsuario.addAll(listaAtraccionesGeneral);
			atraccionSeleccionada = 0;
			atraccionesParaUsuario = armarPosiblesAtraccionesParaUsuario(usuario, listaAtraccionesUsuario);
			
				while(atraccionesParaUsuario.size() > 0) {
					
					Visualizador.log("Atracciones para " + usuario.getNombre());
					Visualizador.log(usuario.getMonedasYTiempoRestante());
					Visualizador.mostrarLista(atraccionesParaUsuario);
					Visualizador.log("Seleccione una opcion: ");
					atraccionSeleccionada = Integer.parseInt(in.readLine())-1;
					Visualizador.log("Se selecciono la atraccion: " + atraccionesParaUsuario.get(atraccionSeleccionada).getNombre());
					
					if(atraccionSeleccionada > -1 && atraccionesParaUsuario.size() >= atraccionSeleccionada) {	
						try {
							usuario.addAtraccion(atraccionesParaUsuario.get(atraccionSeleccionada));
							usuario.setCantidadDeMonedas(usuario.getCantidadDeMonedas() - atraccionesParaUsuario.get(atraccionSeleccionada).getCosto());
							usuario.setTiempoDisponible(usuario.getTiempoDisponible() - atraccionesParaUsuario.get(atraccionSeleccionada).getTiempoDeDuracion());
							atraccionesParaUsuario.get(atraccionSeleccionada).setcapacidadRestante(atraccionesParaUsuario.get(atraccionSeleccionada).getcapacidadRestante()-1);
						}
						catch(Exception e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
					else {
						Visualizador.log("Numero invalido");
					}
					atraccionesParaUsuario = armarPosiblesAtraccionesParaUsuario(usuario, atraccionesParaUsuario);
				}
		};
		}
		
		catch(Exception e) {
			System.err.println(e);
		}
		
		for(Usuario user : listaUsuarios) {
			System.out.println("Itinerario para: " + user.getNombre());
			Visualizador.mostrarItinerario(user);		
		}
		
	}
	
	private static List<Atraccion> armarPosiblesAtraccionesParaUsuario(Usuario usuario, List<Atraccion> listadoAtracciones) {
		
		Comparator<Atraccion> comparador = new Comparator<Atraccion>() {
			@Override
			public int compare(Atraccion a1, Atraccion a2) {
					if(a1.getTipo() == usuario.getTipoAtraccionPredilecta() ? false : true) {
						return a1.getCosto() > a2.getCosto() ? -1 : 1;
					}
					return -1;
			}
		};
		
		Collections.sort(listadoAtracciones, comparador);
		
		listadoAtracciones.removeIf(item -> item.getCosto() >= usuario.getCantidadDeMonedas() || 
				item.getTiempoDeDuracion() >= usuario.getTiempoDisponible() ||
				usuario.getListaAtracciones().contains(item) ||
				item.getcapacidadRestante() == 0);
		
		return listadoAtracciones;
	}

	

	
}
