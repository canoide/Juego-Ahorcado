package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

public abstract class Jugador extends Observable implements Runnable {

	private TurnoPalabra turnoPalabra;
	private int vidas = 0;
	private int cantidadAciertos;
	private int cantidadErrores;
	private boolean esGanador;
	private String nombre;
	private boolean esMiTurno;

	private char letra = ' ';

	private Hashtable<Character, ArrayList<Integer>> listaLetrasAcerdas;

	{
		listaLetrasAcerdas = new Hashtable<Character, ArrayList<Integer>>();
	}

	/**
	 * @return the turnoPalabra
	 */
	public TurnoPalabra getTurnoPalabra() {
		return turnoPalabra;
	}

	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * @param vidas
	 *            the vidas to set
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
	 * @param cantidadAciertos
	 *            the cantidadAciertos to set
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
	 * @param cantidadErrores
	 *            the cantidadErrores to set
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
	 * @param esGanador
	 *            the esGanador to set
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
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * @return the esMiTurno
	 */
	public boolean isEsMiTurno() {
		return esMiTurno;
	}

	/**
	 * @return the listaLetrasAcerdas
	 */
	public Hashtable<Character, ArrayList<Integer>> getListaLetrasAcerdas() {
		return listaLetrasAcerdas;
	}

	/**
	 * @param nombre
	 * @param turnoPalabra
	 * @param vidas
	 */
	public Jugador(String nombre, TurnoPalabra turnoPalabra, int vidas) {
		this.turnoPalabra = turnoPalabra;
		this.nombre = nombre;
		this.vidas = vidas;
		this.cantidadAciertos = 0;
		this.cantidadErrores = 0;
		this.esGanador = false;
		this.esMiTurno = false;
	}

	protected void agregarLetraAcertada(Character letra, int[] posicionesLetras) {
		ArrayList<Integer> tempPositiones = new ArrayList<Integer>();

		for (int i = 0; i < posicionesLetras.length; i++) {
			tempPositiones.add(posicionesLetras[i]);
		}

		this.listaLetrasAcerdas.put(letra, tempPositiones);
	}

	protected void agregarLetraAcertada(Character letra, ArrayList<Integer> posicionesLetras) {
		this.listaLetrasAcerdas.put(letra, posicionesLetras);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		// actualiza la pantalla de los jugadores al iniciar
		this.setChanged();
		this.notifyObservers(this);
		
		while (!this.getTurnoPalabra().isJuegoTerminado() && this.getVidas() > 0) {
			try {
				this.getTurnoPalabra().dameTurno(this);
				
				// despues que consiguio turno y termino el juego interrumpe el Hilo
				if (this.getTurnoPalabra().isJuegoTerminado()) {
					Thread.interrupted();
					this.getTurnoPalabra().devolverTurno(this);
				}
				
				this.esMiTurno = true;
				
				// Actualiza la pantalla porque se le dio el turno
				this.setChanged();
				this.notifyObservers(this);
				
				
				
				while (this.letra == ' ') {
					this.letra = this.getInput();
					Thread.yield();
				}

				// lista de posiciones acertadas
				List<Integer> tempListaLetras = this.getTurnoPalabra().proponerLetra(letra);

				if (tempListaLetras.size() > 0) {
					System.out.println("Acertado " + this.getNombre() + " la letra: " + letra);
					this.agregarLetraAcertada(letra, (ArrayList<Integer>) tempListaLetras);
					this.cantidadAciertos++;
				} else {
					System.out.println("Ha errado " + this.vidas + " "+ this.getNombre() + " la letra: " + letra);
					this.cantidadErrores++;
					this.vidas--;
				}

				if (this.getTurnoPalabra().getCantidadLetras() == this.getListaLetrasAcerdas().size()) {
					this.setEsGanador(true);
				}
				

				this.getTurnoPalabra().devolverTurno(this);

				this.letra = ' ';
				this.esMiTurno = false;

				// despues que encontro la palabra actualiza la palabra y tambien que perdio el turno
				this.setChanged();
				this.notifyObservers(this);
				
				// pone a dormir al jugador por un tiempo
				this.aplicarDormir();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public abstract void setInput(char letra);
	
	protected abstract char getInput() throws InterruptedException;
	
	protected abstract void aplicarDormir() throws InterruptedException;
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nombre: [" + this.nombre + "] - es Ganador: [" + this.esGanador + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		Jugador jugador = (Jugador) obj;
		
		if (!jugador.turnoPalabra.equals(this.turnoPalabra))
			return false;
		
		if (!jugador.nombre.equals(this.nombre))
			return false;
		
		//Hashtable<Character, ArrayList<Integer>>
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
