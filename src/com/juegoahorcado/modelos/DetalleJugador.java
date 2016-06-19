package com.juegoahorcado.modelos;

import java.io.Serializable;

public class DetalleJugador implements Serializable {
	
	private int id;
	private int cantidadAciertos;
	private int cantidadErrores;
	private boolean esGanador;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadAciertos() {
		return cantidadAciertos;
	}

	public void setCantidadAciertos(int cantidadAciertos) {
		this.cantidadAciertos = cantidadAciertos;
	}

	public int getCantidadErrores() {
		return cantidadErrores;
	}

	public void setCantidadErrores(int cantidadErrores) {
		this.cantidadErrores = cantidadErrores;
	}

	public boolean getEsGanador() {
		return esGanador;
	}

	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}

	public DetalleJugador() {

	}
	
	/**
	 * @param nombreJugador
	 * @param cantidadAciertos
	 * @param cantidadErrores
	 * @param esGanador
	 */
	public DetalleJugador(int cantidadAciertos, int cantidadErrores, boolean esGanador) {
		this.cantidadAciertos = cantidadAciertos;
		this.cantidadErrores = cantidadErrores;
		this.esGanador = esGanador;
	}
	
}
