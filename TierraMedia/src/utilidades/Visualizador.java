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
				
		listado += "Total de monedas requeridas: " + totalMonedas + " | Total de tiempo requerido: " + totalTiempo + "\n";
		
		return listado;
	}
	
	public void log(String texto) {
		System.out.println(texto);
	}
}
