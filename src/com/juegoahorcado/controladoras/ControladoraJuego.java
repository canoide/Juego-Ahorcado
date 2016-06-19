package com.juegoahorcado.controladoras;

import java.util.Observer;

import com.juegoahorcado.modelos.Jugador;
import com.juegoahorcado.modelos.JugadorHumano;
import com.juegoahorcado.modelos.JugadorMaquina;
import com.juegoahorcado.modelos.TurnoPalabra;

public class ControladoraJuego {
	
	private TurnoPalabra turnoPalabra;
	private Jugador[] jugadores;
	
	public ControladoraJuego(String nombreJugador, int cantidadVidas, int cantidadMaquinas) {
		this.initGame(nombreJugador, cantidadVidas, cantidadMaquinas);
	}
	
	public void initGame(String nombreJugador, int cantidadVidas, int cantidadMaquinas) {
		// crea las cantidad de jugadorMaquinas de la partida
		this.jugadores = new Jugador[cantidadMaquinas + 1];
		
		// crear turno Palabra
		this.turnoPalabra = new TurnoPalabra();

		// crear jugador principal
		this.jugadores[0] = new JugadorHumano(nombreJugador, this.turnoPalabra, cantidadVidas);
		
		// crea las maquinas
		for (int i = 1; i < cantidadMaquinas + 1; i++) {
			this.jugadores[i]  = new JugadorMaquina("Maquina " + i, this.turnoPalabra, cantidadVidas);
		}
		
		// crea los hilos y los pone en ejecucion agregando el observador
		for (int i = 0; i < jugadores.length; i++) {
			this.jugadores[i].addObserver(this.turnoPalabra);
			new Thread(this.jugadores[i]).start();
		}
	}

	public int getCantidadLetrasDePalabra() {
		return turnoPalabra.getCantidadLetrasDePalabra();
	}

	public void setEntradaPersonaje (char letra) {
		this.jugadores[0].setInput(letra);
	}
	/**
	 * Recive una cantidad observadores el primer observer es el player
	 * @param observer
	 */
	public void registerObserver(Observer... observer) {
		for (int i = 0; i < this.jugadores.length; i++) {
			if (i < observer.length)
				this.jugadores[i].addObserver(observer[i]);
			else
				break;
		}
	}

	/**
	 * El indice 0 es el jugador, el resto de los indices son la maquina.
	 * Si esta fuera de rango devuelve un null.
	 * @param indice
	 * @return
	 */
	public Jugador getJugador (int indice) {
		if (indice < this.jugadores.length)
			return this.jugadores[indice];
		else
			return null;
	}
}
