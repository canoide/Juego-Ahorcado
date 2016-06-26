package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.juegoahorcado.controladoras.ControladoraPalabras;

public class TurnoPalabra extends Observable implements Observer, Cloneable {

	// buscar palabra
	
	private Palabra palabra;
	
	private boolean juegoTerminado;
	
	private boolean turnoDisponible;
	
	private List<Jugador> listaJugadores;
	
	/**
	 * @param palabra the palabra to set
	 */
	public void setPalabra(Palabra palabra) {
		this.palabra = palabra;
	}

	{
		turnoDisponible = true;
		juegoTerminado = false;
		palabra = new ControladoraPalabras().getRandomPalabra();
	}

	/**
	 * @return the juegoTerminado
	 */
	public boolean isJuegoTerminado() {
		return juegoTerminado;
	}
	
	public TurnoPalabra() {
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Jugador tempJugador = (Jugador) arg1;
		if (tempJugador.isEsGanador()) {
			this.juegoTerminado = true;
			Thread.interrupted();
			
			this.setChanged();
			this.notifyObservers(tempJugador);
			
			System.out.println("Juego Terminado");
		}
		
		boolean check = true;
		for (int i = 0; i < this.listaJugadores.size(); i++) {
			if (this.listaJugadores.get(i).getVidas() != 0)
				check = false;
		}
		
		
		if (check) {
			this.juegoTerminado = true;
			Thread.interrupted();
			
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	public synchronized void dameTurno(Jugador jugador) throws InterruptedException {
		while (!this.turnoDisponible) {
			this.wait();
		}
		
		this.turnoDisponible = false;
	}
	
	public synchronized void devolverTurno (Jugador jugador) throws InterruptedException {
		this.turnoDisponible = true;
		
		this.notifyAll();
	}
	
	public synchronized List<Integer> proponerLetra(Character letra) {
		// lista de posiciones temporales
		List<Integer> tempListaPosiciones = new ArrayList<Integer>();
		
		// buscar letras y las pociones de la palabra
		for (int i = 0; i < this.palabra.getListaLetras().size(); i++) {
			char tempLetra = this.palabra.getListaLetras().get(i);
			if (letra.equals(tempLetra)) {
				tempListaPosiciones.add(i);
			}
		}
		return tempListaPosiciones;
	}
	
	/**
	 * Devuelve la cantidad de palabras no repetidas
	 */
	public int getCantidadLetras () {
		return this.palabra.getCantidadLetras();
	}
	
	/**
	 * Devuelve la cantidad de palabras
	 */
	public int getCantidadLetrasDePalabra () {
		return this.palabra.getCantidadLetrasDePalabra();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		
		if (!obj.equals(this))
			return false;
		
		TurnoPalabra tempTurno = (TurnoPalabra) obj;
		
		if (!tempTurno.palabra.equals(this.palabra))
			return false;
		if (tempTurno.juegoTerminado != this.juegoTerminado)
			return false;
		if (tempTurno.turnoDisponible != this.turnoDisponible)
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		TurnoPalabra turno = (TurnoPalabra) super.clone();
		turno.setPalabra((Palabra) palabra.clone());
		return turno;
	}
	
	
	public void addObservable (Jugador jugador) {
		if (this.listaJugadores == null) 
			this.listaJugadores = new ArrayList<Jugador>();
		
		jugador.addObserver(this);
		
		this.listaJugadores.add(jugador);
	}
}
