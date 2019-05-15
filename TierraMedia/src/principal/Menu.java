package principal;
import utilidades.*;

import java.io.*;
import java.util.*;

import componentes.*;

public class Menu {

	private List<Atraccion> listaAtraccionesUsuario; 
	private List<Atraccion> atraccionesParaUsuario;
	private List<Promocion> listasPromociones;
	private List<Promocion> listasPromocionesParaUsuario;
	private int atraccionSeleccionada;
	List<Usuario> listaUsuarios;
	List<Atraccion> listaAtraccionesGeneral;
	Visualizador view = new Visualizador();
	Archivo archivo = new Archivo();
	GeneradorDeListas generador = new GeneradorDeListas();
	
	public void ejecutar() {
		leerArchivos();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		if(listaUsuarios.size() > 0 && listaAtraccionesGeneral.size() > 0) {
			
		try {
			for(Usuario usuario : listaUsuarios) {
				listaAtraccionesUsuario = new ArrayList<Atraccion>();
				listaAtraccionesUsuario.addAll(listaAtraccionesGeneral);
				//listasPromocionesParaUsuario.addAll(listasPromociones);
				
				atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, listaAtraccionesUsuario);
				
					while(atraccionesParaUsuario.size() > 0) {
						atraccionSeleccionada = 0;
						view.log("--------------------------------------------------------\n");
						view.log("Atracciones & Promociones para " + usuario.getNombre() + "\n");
						view.log(usuario.getMonedasYTiempoRestante());
						//view.mostrarLista(listasPromociones);
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
	
	private void leerArchivos() {
		try {
			listaUsuarios = archivo.LeerUsuarios("usuarios");
			listaAtraccionesGeneral = archivo.LeerAtracciones("atracciones");
			//listasPromociones = archivo.LeerPromociones("promociones", listaAtraccionesGeneral);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
		
	}
	
	

	

	
}
