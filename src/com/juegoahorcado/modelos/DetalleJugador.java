package com.juegoahorcado.modelos;

public class DetalleJugador {
	
	private int id;
	private String nombreJugador;
	private int cantidadAciertos;
	private int cantidadErrores;
	private boolean esGanador;
	
	private Estadistica estadistica;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
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

	/**
	 * @return the estadistica
	 */
	public Estadistica getEstadistica() {
		return estadistica;
	}

	/**
	 * @param estadistica the estadistica to set
	 */
	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
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
	
	public DetalleJugador(Jugador jugador) {
		this.nombreJugador = jugador.getNombre();
		this.cantidadAciertos = jugador.getCantidadAciertos();
		this.cantidadErrores = jugador.getCantidadErrores();
		this.esGanador = jugador.isEsGanador();
	}
	
}
