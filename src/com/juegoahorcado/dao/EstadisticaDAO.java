package com.juegoahorcado.dao;

import java.util.List;

import com.juegoahorcado.modelos.Estadistica;

public class EstadisticaDAO extends BaseDAO<Estadistica> {

	public Estadistica obtenerPorNombre(String nombreJugador) {
		List<Estadistica> lista = this.obtenerLista();  
        
	    for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNombreJugador().equals(nombreJugador))
				return lista.get(i);
		}
        
        return null;
	}
}
