package principal;
import utilidades.*;

import java.io.*;
import java.util.*;

import componentes.*;

public class Menu {

	private List<Atraccion> listaAtraccionesUsuario; 
	private List<Atraccion> atraccionesParaUsuario;
	private List<Promocion> listaPromociones;
	List<Promocion> listaPromocionesParaUsuario;
	private int opcionSeleccionada;
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
				listaPromocionesParaUsuario = new ArrayList<Promocion>();
				listaPromocionesParaUsuario.addAll(listaPromociones);
				
				atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, listaAtraccionesUsuario);
				//listaPromocionesParaUsuario = generador.armarPosiblesPromocionesParaUsuario(usuario, listaPromociones);
					while(atraccionesParaUsuario.size() > 0) {
						opcionSeleccionada = 0;
						view.log("--------------------------------------------------------\n");
						view.log("Atracciones & Promociones para " + usuario.getNombre() + "\n");
						view.log(usuario.getMonedasYTiempoRestante());
						view.mostrarLista(listaPromocionesParaUsuario,0);
						view.mostrarLista(atraccionesParaUsuario, listaPromocionesParaUsuario.size());
						view.log("Seleccione una opcion: ");
						opcionSeleccionada = Integer.parseInt(in.readLine())-1;
						
						
						if(opcionSeleccionada > -1 && listaPromocionesParaUsuario.size() > opcionSeleccionada) {	
							if(opcionSeleccionada > atraccionesParaUsuario.size()){
								view.log("Se selecciono la atraccion: " + atraccionesParaUsuario.get(opcionSeleccionada).getNombre());
								try {
									usuario.addAtraccion(atraccionesParaUsuario.get(opcionSeleccionada));
									usuario.setCantidadDeMonedas(usuario.getCantidadDeMonedas() - atraccionesParaUsuario.get(opcionSeleccionada).getCosto());
									usuario.setTiempoDisponible(usuario.getTiempoDisponible() - atraccionesParaUsuario.get(opcionSeleccionada).getTiempoDeDuracion());
									atraccionesParaUsuario.get(opcionSeleccionada).setcapacidadRestante(atraccionesParaUsuario.get(opcionSeleccionada).getcapacidadRestante()-1);
								}
								catch(Exception e) {
									System.out.println("Error: " + e.getMessage());
								}
							} else if (opcionSeleccionada < atraccionesParaUsuario.size()) {
								view.log("Se selecciono la promocion: " + listaPromocionesParaUsuario.get(opcionSeleccionada).getNombre());
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
			listaPromociones = archivo.LeerPromociones("promociones", listaAtraccionesGeneral);
		}
		catch(Exception e){
			System.out.print("LeerArchivo " + e.getMessage());
		}
		
	}
	
	

	

	
}
