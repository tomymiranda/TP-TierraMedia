package principal;
import clases.*;
import utilidades.Archivo;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] usuarios = Archivo.Leer("usuarios");
		String[][] atracciones = Archivo.Leer("Atracciones");
		List<Atraccion> listaAtracciones = crearListadoAtracciones(atracciones);
		List<Usuario> listaUsuarios = crearListaUsuarios(usuarios);
		
		mostrarPosiblesAtraccionesParaUsuario(listaUsuarios.get(0), listaAtracciones);
		/*
		for (Atraccion atr : listaAtracciones) {
			   System.out.println(atr.getNombre() + " - "  + atr.getCosto() + " - "  + atr.getTiempoDeDuracion()  + " - "  + atr.getCapacidad()  + " - "  + atr.getTipo());
		}
		System.out.println("\n");
		for (Usuario user : listaUsuarios) {
			   System.out.println(user.getNombre() + " - "  + user.getCantidadDeMonedas() + " - "  + user.getTiempoDisponible() + " - "  + user.getTipoAtraccionPredilecta());
		}
		*/

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
					return a1.getTipo() == usuario.getTipoAtraccionPredilecta() ? -1 : 1;
				}
				else {
					return result;
				}
			}
		};
		
		Collections.sort(listaAtracciones, comparador);
			
		for (Atraccion item : listaAtracciones) {
			if(item.getCosto() > usuario.getCantidadDeMonedas()) {
				//listaAtracciones.remove(listaAtracciones.indexOf(item));				
			}
		}
			   
		mostrarLista(listaAtracciones);
	}
	
	private static void mostrarLista(Object lista){
		for (Object item : (Iterable)lista) {
			   System.out.println(item.toString());
		}
	}
}
