package principal;
import clases.*;
import utilidades.Archivo;

import java.io.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		String[][] usuarios = Archivo.Leer("usuarios");
		String[][] atracciones = Archivo.Leer("Atracciones");
		List<Atraccion> listaAtracciones = crearListadoAtracciones(atracciones);
		List<Usuario> listaUsuarios = crearListaUsuarios(usuarios);
		List<Atraccion> atraccionesParaUsuario;
		int atraccionSeleccionada;
		Usuario usuarioSeleccionado;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		for(Usuario usuario : listaUsuarios) {
			atraccionSeleccionada = 0;
			log("Size listaAtracciones, " + listaAtracciones.size());
			atraccionesParaUsuario = armarPosiblesAtraccionesParaUsuario(usuario, crearListadoAtracciones(atracciones));
			log("atraccionSeleccionada " + atraccionSeleccionada);
			log("size " + atraccionesParaUsuario.size());
				while(atraccionesParaUsuario.size() > 0) {
					
					System.out.println("Atracciones para " + usuario.getNombre());
					System.out.println(usuario.getMonedasYTiempoRestante());
					mostrarLista(atraccionesParaUsuario);
					System.out.println("Seleccione una opcion: ");
					atraccionSeleccionada = Integer.parseInt(in.readLine())-1;
					System.out.println("Se selecciono la atraccion: " + atraccionesParaUsuario.get(atraccionSeleccionada).getNombre());
					
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
						log("Numero invalido");
					}
					atraccionesParaUsuario = armarPosiblesAtraccionesParaUsuario(usuario, atraccionesParaUsuario);
					log("final while dentro, " + atraccionesParaUsuario.size());
				}
				log("final while fuera");
		};
		}
		
		catch(Exception e) {
			System.err.println(e);
		}
		
		for(Usuario user : listaUsuarios) {
			System.out.println("Itinerario para: " + user.getNombre());
			mostrarItirenario(user);		
		}
		
	}
	
	private static List<Atraccion> crearListadoAtracciones(String[][] atracciones){
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		for(int i = 0; i < atracciones.length; i++) {
			switch(atracciones[i][atracciones[i].length-1]) {
			  case "Paisaje":
			    listaAtracciones.add(new Atraccion(atracciones[i][0],
			    		Integer.parseInt(atracciones[i][1]),
			    		Double.parseDouble(atracciones[i][2]),
			    		Integer.parseInt(atracciones[i][3]),
			    		TipoDeAtracciones.Paisaje));
			    break;
			  case "Degustacion":
				  listaAtracciones.add(new Atraccion(atracciones[i][0],
				    		Integer.parseInt(atracciones[i][1]),
				    		Double.parseDouble(atracciones[i][2]),
				    		Integer.parseInt(atracciones[i][3]),
				    		TipoDeAtracciones.Desgustacion));
			    break;
			  default:
				  listaAtracciones.add(new Atraccion(atracciones[i][0],
				    		Integer.parseInt(atracciones[i][1]),
				    		Double.parseDouble(atracciones[i][2]),
				    		Integer.parseInt(atracciones[i][3]),
				    		TipoDeAtracciones.Aventura));
			}
		}
		
		return listaAtracciones;
	}
	
	private static List<Usuario> crearListaUsuarios(String[][] usuarios){
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for(int i = 0; i < usuarios.length; i++) {
			
			switch(usuarios[i][usuarios[i].length-1]) {
			  case "Paisaje":
				  listaUsuarios.add(new Usuario(
							usuarios[i][0],
							Integer.parseInt(usuarios[i][1]),
							Double.parseDouble(usuarios[i][2]),
							TipoDeAtracciones.Paisaje
						));
			    break;
			  case "Degustacion":
				  listaUsuarios.add(new Usuario(
							usuarios[i][0],
							Integer.parseInt(usuarios[i][1]),
							Double.parseDouble(usuarios[i][2]),
							TipoDeAtracciones.Desgustacion
						));
			    break;
			  default:
				  listaUsuarios.add(new Usuario(
							usuarios[i][0],
							Integer.parseInt(usuarios[i][1]),
							Double.parseDouble(usuarios[i][2]),
							TipoDeAtracciones.Aventura
						));
			}
			
		}
		
		return listaUsuarios;
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

	
	private static void mostrarLista(List lista){
		for (Object item : lista) {
			   System.out.println("["+ (lista.indexOf(item)+1) +"] - " + item.toString());
		}
	}
	
	private static void mostrarItirenario(Usuario usuario) {
		for (Atraccion atraccion : usuario.getListaAtracciones()) {
			System.out.println(atraccion.getNombre());
		}
	}
	
	private static void log(String texto) {
		System.out.println(texto);
	}
	
}
