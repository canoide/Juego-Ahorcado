package com.juegoahorcado.modelos;

import java.util.Observable;

public abstract class Jugador extends Observable implements Runnable {
	
	private TurnoPalabra turnoPalabra;
	
	private int vidas = 0;
	
	private int cantidadAciertos;
	
	private int cantidadErrores;
	
	private boolean esGanador;
	
	private String nombre;


	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}



	/**
	 * @param vidas the vidas to set
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}



	/**
	 * @return the cantidadAciertos
	 */
	public int getCantidadAciertos() {
		return cantidadAciertos;
	}



	/**
	 * @param cantidadAciertos the cantidadAciertos to set
	 */
	public void setCantidadAciertos(int cantidadAciertos) {
		this.cantidadAciertos = cantidadAciertos;
	}



	/**
	 * @return the cantidadErrores
	 */
	public int getCantidadErrores() {
		return cantidadErrores;
	}



	/**
	 * @param cantidadErrores the cantidadErrores to set
	 */
	public void setCantidadErrores(int cantidadErrores) {
		this.cantidadErrores = cantidadErrores;
	}



	/**
	 * @return the esGanador
	 */
	public boolean isEsGanador() {
		return esGanador;
	}



	/**
	 * @param esGanador the esGanador to set
	 */
	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Jugador (String nombre, TurnoPalabra turnoPalabra,int vidas) {
		this.turnoPalabra = turnoPalabra;
		this.nombre = nombre;
		this.vidas = vidas;
		this.cantidadAciertos = 0;
		this.cantidadErrores = 0;
		this.esGanador = false;
	}
}
