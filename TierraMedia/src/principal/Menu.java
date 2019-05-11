package principal;
import utilidades.*;

import java.io.*;
import java.util.*;

import componentes.*;

public class Menu {

	private List<Atraccion> listaAtraccionesUsuario; 
	private List<Atraccion> atraccionesParaUsuario;
	private int atraccionSeleccionada;
	Visualizador view = new Visualizador();
	Archivo archivo = new Archivo();
	GeneradorDeListas generador = new GeneradorDeListas();
	
	public void ejecutar() {
		List<Usuario> listaUsuarios = archivo.LeerUsuarios("usuarios");
		List<Atraccion> listaAtraccionesGeneral = archivo.LeerAtracciones("atracciones");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		if(listaUsuarios.size() > 0 && listaAtraccionesGeneral.size() > 0) {
			
		try {
			view.log("Menu" + listaUsuarios);
			for(Usuario usuario : listaUsuarios) {
				listaAtraccionesUsuario = new ArrayList<Atraccion>();
				listaAtraccionesUsuario.addAll(listaAtraccionesGeneral);
				atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, listaAtraccionesUsuario);
				
					while(atraccionesParaUsuario.size() > 0) {
						atraccionSeleccionada = 0;
						view.log("--------------------------------------------------------\n");
						view.log("Atracciones para " + usuario.getNombre() + "\n");
						view.log(usuario.getMonedasYTiempoRestante());
						view.mostrarLista(atraccionesParaUsuario);
						view.log("Seleccione una opcion: ");
						atraccionSeleccionada = Integer.parseInt(in.readLine())-1;
						
						
						if(atraccionSeleccionada > -1 && atraccionesParaUsuario.size() > atraccionSeleccionada) {	
							
							view.log("Se selecciono la atraccion: " + atraccionesParaUsuario.get(atraccionSeleccionada).getNombre());
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
							view.log("Numero invalido");
						}
						atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, atraccionesParaUsuario);
					}
			};
			archivo.generarItinerarios(listaUsuarios);
		}
		
		catch(Exception e) {
			System.err.println(e);
		}
		
		}
		else {
			view.log("Listas vacias");
		}
		
	}
	
	

	

	
}
