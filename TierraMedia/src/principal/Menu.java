package principal;
import utilidades.*;

import java.io.*;
import java.util.*;

import componentes.*;

public class Menu {

	private List<Atraccion> listaAtraccionesUsuario; 
	private List<Atraccion> atraccionesParaUsuario;
	List<Atraccion> listaAtraccionesGeneral;
	
	private List<Promocion> listaPromocionesGeneral;
	List<Promocion> listaPromocionesParaUsuario;
	private List<Promocion> promocionesParaUsuario;
	
	List<Usuario> listaUsuarios;

	private int opcionSeleccionada;
	Visualizador view = new Visualizador();
	Archivo archivo = new Archivo();
	GeneradorDeListas generador = new GeneradorDeListas();
	
	public void ejecutar() {
		leerArchivos();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		if(listaUsuarios.size() > 0 && listaAtraccionesGeneral.size() > 0) {
			
		try {
			for(Usuario usuario : listaUsuarios) {
				// Se clonan para no referenciar al original y no borrar elementos del original
				listaAtraccionesUsuario = new ArrayList<Atraccion>();
				listaAtraccionesUsuario.addAll(listaAtraccionesGeneral);
				listaPromocionesParaUsuario = new ArrayList<Promocion>();
				listaPromocionesParaUsuario.addAll(listaPromocionesGeneral);
				
				// Se generan los listados de opciones filtrados
				atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, listaAtraccionesUsuario);
				promocionesParaUsuario = generador.armarPosiblesPromocionesParaUsuario(usuario, listaPromocionesGeneral);
				
					while(atraccionesParaUsuario.size() > 0) {
						opcionSeleccionada = 0;
						view.log("--------------------------------------------------------\n");
						view.log("Atracciones & Promociones para " + usuario.getNombre() + "\n");
						view.log(usuario.getMonedasYTiempoRestante());
						view.mostrarLista(promocionesParaUsuario,0);
						view.mostrarLista(atraccionesParaUsuario, promocionesParaUsuario.size());
						view.log("Seleccione una opcion: ");
						
						opcionSeleccionada = Integer.parseInt(in.readLine())-1;
						int totalItems = listaPromocionesParaUsuario.size()+listaAtraccionesUsuario.size();
						
						if (opcionSeleccionada > -1 && totalItems > opcionSeleccionada) {	
							view.log("if " + opcionSeleccionada);
							view.log("Atracciones: " + atraccionesParaUsuario.size());
							view.log("Promo: " + promocionesParaUsuario.size());
							
							if (opcionSeleccionada < promocionesParaUsuario.size()) {
								view.log("Selec Promo");
								view.log("Se selecciono la promocion: " + promocionesParaUsuario.get(opcionSeleccionada).getNombre());
							}
							else if ((opcionSeleccionada-promocionesParaUsuario.size()) < atraccionesParaUsuario.size()){
								opcionSeleccionada -= promocionesParaUsuario.size();
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
							}  else {
								view.log("Numero invalido 2");
							}
							
						}
						else {
							view.log("Numero invalido");
						}
						// Se refrescan las listas de posibles opciones
						atraccionesParaUsuario = generador.armarPosiblesAtraccionesParaUsuario(usuario, atraccionesParaUsuario);
						promocionesParaUsuario = generador.armarPosiblesPromocionesParaUsuario(usuario, promocionesParaUsuario);
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
			listaPromocionesGeneral = archivo.LeerPromociones("promociones", listaAtraccionesGeneral);
		}
		catch(Exception e){
			System.out.print("LeerArchivo " + e.getMessage());
		}
		
	}
	
	

	

	
}
