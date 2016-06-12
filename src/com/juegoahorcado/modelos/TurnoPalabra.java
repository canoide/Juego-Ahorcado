package com.juegoahorcado.modelos;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;

public class TurnoPalabra implements Observer {

	// buscar palabra
	
	private Palabra palabra;
	
	private boolean juegoTerminado;
	
	private boolean turnoDisponible;
	
	{
		turnoDisponible = true;
		juegoTerminado = false;
		palabra = new Palabra();
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
			System.out.println("Juego Terminado");
		}
	}
	
	public synchronized void dameTurno(Jugador jugador) throws InterruptedException {
		while (!this.turnoDisponible)
			this.wait();
		
		this.turnoDisponible = false;
	}
	
	public synchronized void devolverTurno (Jugador jugador) throws InterruptedException {
		while (this.turnoDisponible)
			this.wait();
		
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
}
