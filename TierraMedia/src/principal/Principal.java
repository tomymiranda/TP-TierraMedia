package principal;
import utilidades.Archivo;

import java.io.*;
import java.util.*;

import componentes.*;

public class Principal {

	public static void main(String[] args) {
		
		
		
		
		String[][] usuarios = Usuario.getUsuarios();
		String[][] atracciones = Atraccion.getAtracciones();
		
		
		
		
		List<Atraccion> listaAtracciones = crearListadoAtracciones(atracciones);
		List<Usuario> listaUsuarios = crearListaUsuarios(usuarios);
		int atraccionSeleccionada = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		mostrarLista(listaUsuarios);
		System.out.println("Seleccione el usuario ingresando el numero correspondiente: ");
		try {
			Usuario usuarioSeleccionado = listaUsuarios.get(Integer.parseInt(in.readLine())-1);
			
			
			while(atraccionSeleccionada > -1) {
				System.out.println("[0] - Generar itinerario");
				mostrarPosiblesAtraccionesParaUsuario(usuarioSeleccionado, listaAtracciones);
				System.out.println("Seleccione una opcion: ");
				atraccionSeleccionada = Integer.parseInt(in.readLine())-1;
				if(atraccionSeleccionada > -1) {			
					usuarioSeleccionado.addAtraccion(listaAtracciones.get(atraccionSeleccionada));
					usuarioSeleccionado.setCantidadDeMonedas(usuarioSeleccionado.getCantidadDeMonedas() - listaAtracciones.get(atraccionSeleccionada).getCosto());
					usuarioSeleccionado.setTiempoDisponible(usuarioSeleccionado.getTiempoDisponible() - listaAtracciones.get(atraccionSeleccionada).getTiempoDeDuracion());
					listaAtracciones.get(atraccionSeleccionada).setcapacidadRestante(listaAtracciones.get(atraccionSeleccionada).getcapacidadRestante()-1);
				}
			}
			
			mostrarItirenario(usuarioSeleccionado);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private static void mostrarPosiblesAtraccionesParaUsuario(Usuario usuario, List<Atraccion> listaAtracciones) {
		
		Comparator<Atraccion> comparador = new Comparator<Atraccion>() {
			@Override
			public int compare(Atraccion a1, Atraccion a2) {
				
				int result = a1.getTipo().compareTo(a2.getTipo());
				if(result == 0) {
					return a1.getTipo() == usuario.getTipoAtraccionPredilecta() && a1.getCosto() > a2.getCosto() ? -1 : 1;
				}
				else {
					return result;
				}
			}
		};
		
		Collections.sort(listaAtracciones, comparador);
		
		listaAtracciones.removeIf(item -> item.getCosto() >= usuario.getCantidadDeMonedas() || 
				item.getTiempoDeDuracion() >= usuario.getTiempoDisponible() ||
				usuario.getListaAtracciones().contains(item) ||
				item.getcapacidadRestante() == 0);
		
		mostrarLista(listaAtracciones);
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
	
}
