package principal;

import utilidades.Archivo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] matriz = Archivo.Leer("usuarios");
		
		for (int x=0; x < matriz.length; x++){
	        for (int y=0; y < matriz[x].length; y++)
	              System.out.print(" | " + matriz[x][y]+ " | ");   
	        System.out.println("\n----------------------------------------");

	}

	}

}
