package utilidades;

import java.util.*;
import componentes.*;

public class GeneradorDeListas {

	public List<Atraccion> armarPosiblesAtraccionesParaUsuario(Usuario usuario, List<Atraccion> listadoAtracciones) {

		Comparator<Atraccion> comparador = new Comparator<Atraccion>() {
			@Override
			public int compare(Atraccion a1, Atraccion a2) {
				if (a1.getTipo() == usuario.getTipoAtraccionPredilecta() ? false : true) {
					return a1.getCosto() > a2.getCosto() ? -1 : 1;
				}
				return -1;
			}
		};

		Collections.sort(listadoAtracciones, comparador);

		listadoAtracciones.removeIf(item -> item.getCosto() > usuario.getCantidadDeMonedas() || item.getTiempoDeDuracion() > usuario.getTiempoDisponible()
				|| usuario.getListaAtracciones().contains(item) || item.getcapacidadRestante() == 0);
        
		return listadoAtracciones;

	}

	public List<Promocion> armarPosiblesPromocionesParaUsuario(Usuario usuario, List<Promocion> listaPromociones) {
		Comparator<Promocion> comparador = new Comparator<Promocion>() {
			@Override
			public int compare(Promocion a1, Promocion a2) {
				return a1.getCosto() > a2.getCosto() ? -1 : 1;
			}
		};

		Collections.sort(listaPromociones, comparador);

		listaPromociones.removeIf(item -> item.getCosto() > usuario.getCantidadDeMonedas()
				|| item.getTiempoDeDuracion() > usuario.getTiempoDisponible()
				|| usuario.getPromocionesSeleccionadas().contains(item));

		return listaPromociones;
	}
}
