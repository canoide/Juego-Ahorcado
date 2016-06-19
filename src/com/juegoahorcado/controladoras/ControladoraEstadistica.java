package com.juegoahorcado.controladoras;

import java.util.ArrayList;
import java.util.List;

import com.juegoahorcado.dao.EstadisticaDAO;
import com.juegoahorcado.modelos.DetalleJugador;
import com.juegoahorcado.modelos.Estadistica;

public class ControladoraEstadistica {

	private EstadisticaDAO dao;
	
	public ControladoraEstadistica() {
		dao = new EstadisticaDAO();
	}
	
	public Estadistica nuevo (String nombre) {
		Estadistica estadistica = new Estadistica(nombre, new ArrayList<DetalleJugador>());
		dao.guardar(estadistica);
		return estadistica;
	}
	
	public Estadistica nuevo (String nombre, List<DetalleJugador> listaDetalles) {
		Estadistica estadistica = this.nuevo(nombre);
		estadistica.setListaDetalles(listaDetalles);
		return estadistica;
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
	
	public Estadistica obtener (String nombreJugador) {
		return this.dao.obtenerPorNombre(nombreJugador);
	}
	
	public List<Estadistica> obtenerTodos() {
		return this.dao.obtenerLista();
	}
}
