package com.juegoahorcado.modelos;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Estadistica {
	
	private int id;
	private Date fecha;
	private List<DetalleJugador> listaDetalles;// = new HashSet<DetalleJugador>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the listaDetalles
	 */
	public List<DetalleJugador> getListaDetalles() {
		return listaDetalles;
	}
	/**
	 * @param listaDetalles the listaDetalles to set
	 */
	public void setListaDetalles(List<DetalleJugador> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}
	
	public Estadistica () {

	}
	
	/**
	 * @param nombreJugador
	 * @param listaDetalles
	 */
	public Estadistica  (Collection<DetalleJugador> listaDetalles) {
		super();
		this.listaDetalles.addAll(listaDetalles);
	}
}
