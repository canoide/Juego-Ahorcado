/**
 * 
 */
package com.juegoahorcado.vistas;

import com.juegoahorcado.dao.PalabraDAO;
import com.juegoahorcado.modelos.Palabra;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalabraDAO dao = new PalabraDAO();
		Palabra palabra = new Palabra();
		dao.guardar(palabra);
		dao.obtenerPorID(1);
		/*
		TurnoPalabra turnoPalabra = new TurnoPalabra();
		int cantidadVidas = 5;
		
		// creando jugadores
		Jugador jugadorHumano = new JugadorHumano("Alejandro", turnoPalabra, cantidadVidas);
		Jugador jugadorMaquina1 = new JugadorMaquina("Maquina 1", turnoPalabra, cantidadVidas);
		Jugador jugadorMaquina2 = new JugadorMaquina("Maquina 2", turnoPalabra, cantidadVidas);
		Jugador jugadorMaquina3 = new JugadorMaquina("Maquina 3", turnoPalabra, cantidadVidas);
		
		// observadores
		jugadorMaquina1.addObserver(turnoPalabra);
		jugadorMaquina2.addObserver(turnoPalabra);
		jugadorMaquina3.addObserver(turnoPalabra);
		jugadorHumano.addObserver(turnoPalabra);
		
		// creando hilos
		Thread theardJugadorHumano = new Thread(jugadorHumano);
		Thread theardJugadorMaquina1 = new Thread(jugadorMaquina1);
		Thread theardJugadorMaquina2 = new Thread(jugadorMaquina2);
		Thread theardJugadorMaquina3 = new Thread(jugadorMaquina3);
		
		// ejecutando hilos
		theardJugadorHumano.start();
		theardJugadorMaquina1.start();
		theardJugadorMaquina2.start();
		theardJugadorMaquina3.start();*/
	}

}
