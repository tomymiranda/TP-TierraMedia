package utilidades;

import java.util.List;

import componentes.*;

public class Visualizador {
	
	public <T> void mostrarLista(List<T> lista, int indiceAnterior){
		for (Object item : lista) {
			   System.out.println("["+ (indiceAnterior + lista.indexOf(item)+1) +"] - " + item.toString());
		}
	}
	
	public  String generarItinerarioPorUsuario(Usuario usuario) {
		int totalMonedas = 0;
		double totalTiempo = 0;
		String listado = "";
		
		for (Atraccion atraccion : usuario.getListaAtracciones()) {
			totalMonedas += atraccion.getCosto();
			totalTiempo += atraccion.getTiempoDeDuracion();
			listado += "- Atraccion: " + atraccion.getNombre() + " | Tiempo de Duracion: " + atraccion.getTiempoDeDuracion() + "\n";
		}
		
		for(Promocion promo : usuario.getPromocionesSeleccionadas()) {
			totalMonedas += promo.getCosto();
			totalTiempo += promo.getTiempoDeDuracion();
			listado += "- Promocion: " + promo.getNombre() + " | Tiempo de Duracion: " + promo.getTiempoDeDuracion() + "\n";
		}
				
		listado += "Total de monedas requeridas: " + totalMonedas + " | Total de tiempo requerido: " + totalTiempo + "\n";
		
		return listado;
	}
	
	public void log(String texto) {
		System.out.println(texto);
	}
	
	public void mostrarMenu(Usuario usuario, List<Atraccion> atraccionesParaUsuario, List<Promocion> promocionesParaUsuario) {
		log("--------------------------------------------------------\n");
		log("Atracciones & Promociones para " + usuario.getNombre() + "\n");
		log(usuario.getMonedasYTiempoRestante());
		
		mostrarLista(promocionesParaUsuario,0);
		mostrarLista(atraccionesParaUsuario, promocionesParaUsuario.size());
		log("Seleccione una opcion: ");
	}
}
