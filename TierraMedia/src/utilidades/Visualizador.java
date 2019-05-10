package utilidades;

import java.util.List;

import clases.Atraccion;
import clases.Usuario;

public class Visualizador {
	
	public static void mostrarLista(List lista){
		for (Object item : lista) {
			   System.out.println("["+ (lista.indexOf(item)+1) +"] - " + item.toString());
		}
	}
	
	public static void mostrarItirenario(Usuario usuario) {
		for (Atraccion atraccion : usuario.getListaAtracciones()) {
			System.out.println(atraccion.getNombre());
		}
	}
	
	public static void log(String texto) {
		System.out.println(texto);
	}
}
