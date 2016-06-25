package com.juegoahorcado.controladoras;

import java.util.Calendar;
import java.util.List;

import com.juegoahorcado.dao.EstadisticaDAO;
import com.juegoahorcado.modelos.DetalleJugador;
import com.juegoahorcado.modelos.Estadistica;

public class ControladoraEstadistica {

	private EstadisticaDAO dao;
	
	public ControladoraEstadistica() {
		dao = new EstadisticaDAO();
	}
	
	public Estadistica nuevo (List<DetalleJugador> listaDetalles) {
		Estadistica estadistica = new Estadistica();
		
		// Fecha
		estadistica.setFecha(Calendar.getInstance().getTime());
		
		for (int i = 0; i < listaDetalles.size(); i++) {
			listaDetalles.get(i).setEstadistica(estadistica);
		}
		
		estadistica.setListaDetalles(listaDetalles);
		
		return estadistica;
	}
	
	public void guardar (Estadistica estadistica) {
		dao.guardar(estadistica);
	}
	
	public void modificar (Estadistica estadistica ) {
		this.dao.actualizar(estadistica); 
	}
	
	public void eliminar (Estadistica estadistica ) {
		this.dao.eliminar(estadistica); 
	}
	
	public Estadistica obtener (int id) {
		return this.dao.obtenerPorID(id);
	}
	
	public List<Estadistica> obtenerTodos() {
		return this.dao.obtenerLista();
	}
}
