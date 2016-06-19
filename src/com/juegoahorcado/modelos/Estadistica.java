package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.List;

public class Estadistica {
	
	private int id;
	private String nombreJugador;
	private List<DetalleJugador> listaDetalles = new ArrayList<DetalleJugador>();
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
	 * @return the nombreJugador
	 */
	public String getNombreJugador() {
		return nombreJugador;
	}
	/**
	 * @param nombreJugador the nombreJugador to set
	 */
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
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
	public Estadistica  (String nombreJugador, List<DetalleJugador> listaDetalles) {
		super();
		this.nombreJugador = nombreJugador;
		this.listaDetalles = listaDetalles;
	}
}
