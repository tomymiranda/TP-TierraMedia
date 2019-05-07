package principal;
import clases.*;
import utilidades.Archivo;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] usuarios = Archivo.Leer("usuarios");
		String[][] atracciones = Archivo.Leer("Atracciones");
		ArrayList<Atraccion> listaAtracciones = crearListadoAtracciones(atracciones);
		ArrayList<Usuario> listaUsuarios = crearListaUsuarios(usuarios);
		
		for (Atraccion atr : listaAtracciones) {
			   System.out.println(atr.getNombre() + " - "  + atr.getCosto() + " - "  + atr.getTiempoDeDuracion()  + " - "  + atr.getCapacidad()  + " - "  + atr.getTipo());
		}
		System.out.println("\n");
		for (Usuario user : listaUsuarios) {
			   System.out.println(user.getNombre() + " - "  + user.getCantidadDeMonedas() + " - "  + user.getTiempoDisponible() + " - "  + user.getTipoAtraccionPredilecta());
		}

	}
	
	private static ArrayList<Atraccion> crearListadoAtracciones(String[][] atracciones){
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
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
	
	private static ArrayList<Usuario> crearListaUsuarios(String[][] usuarios){
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
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
	
	private void mostrarPosiblesAtraccionesParaUsuario() {
		
	}
	
	
}
