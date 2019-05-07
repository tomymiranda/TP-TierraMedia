package principal;
import clases.*;
import utilidades.Archivo;
import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] usuarios = Archivo.Leer("usuarios");
		String[][] atracciones = Archivo.Leer("Atracciones");
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		/*
		for (int x=0; x < atracciones.length; x++){
	        for (int y=0; y < atracciones[x].length; y++)
	              System.out.print(" | " + atracciones[x][y]+ " | ");   
	        System.out.println("\n----------------------------------------");

		}
		*/

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
		for (Atraccion atr : listaAtracciones) {
			   System.out.println(atr.getNombre() + " - "  + atr.getCosto() + " - "  + atr.getTiempoDeDuracion()  + " - "  + atr.getCapacidad()  + " - "  + atr.getTipo());
			}

	}

}
