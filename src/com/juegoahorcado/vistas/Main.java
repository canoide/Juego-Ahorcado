/**
 * 
 */
package com.juegoahorcado.vistas;

import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.juegoahorcado.controladoras.ControladoraEstadistica;
import com.juegoahorcado.controladoras.ControladoraPalabras;
import com.juegoahorcado.modelos.DetalleJugador;
import com.juegoahorcado.modelos.Estadistica;
import com.juegoahorcado.modelos.Jugador;
import com.juegoahorcado.modelos.JugadorHumano;
import com.juegoahorcado.modelos.TurnoPalabra;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        
        ControladoraPalabras controlPalabras = new ControladoraPalabras();
        ControladoraEstadistica controlEstadistica = new ControladoraEstadistica();
        
        if(controlPalabras.getCantidad()==0 && controlEstadistica.getCantidad()==0){
        	crearCargado(controlPalabras , controlEstadistica);
        }
        
		
        new MenuPrincipal();
	}
	
	public static void crearCargado(ControladoraPalabras cPalabras, ControladoraEstadistica cEtadistica) {
		cPalabras.guardar(cPalabras.nuevaPalabra("HOLA"));
		cPalabras.guardar(cPalabras.nuevaPalabra("MUNDO"));
		cPalabras.guardar(cPalabras.nuevaPalabra("PALABRA"));
		cPalabras.guardar(cPalabras.nuevaPalabra("ANDROID"));
		cPalabras.guardar(cPalabras.nuevaPalabra("GUSANO"));
		cPalabras.guardar(cPalabras.nuevaPalabra("KAKAROTO"));
		cPalabras.guardar(cPalabras.nuevaPalabra("INSECTO"));
		
		for (int i = 0; i < 10; i++) {
			TurnoPalabra turno = new TurnoPalabra();
			Jugador jugadorH1 = new JugadorHumano("Jugador", turno, 3);
			jugadorH1.setEsGanador(new Random().nextBoolean());
			jugadorH1.setCantidadAciertos(new Random().nextInt(5));
			jugadorH1.setCantidadErrores(new Random().nextInt(5));
			Jugador jugadorH2 = new JugadorHumano("Maquina 1", turno, 3);
			jugadorH2.setCantidadAciertos(new Random().nextInt(5));
			jugadorH2.setCantidadErrores(new Random().nextInt(5));
			Jugador jugadorH3 = new JugadorHumano("Maquina 2", turno, 3);
			jugadorH3.setCantidadAciertos(new Random().nextInt(5));
			jugadorH3.setCantidadErrores(new Random().nextInt(5));
			Jugador jugadorH4 = new JugadorHumano("Maquina 3", turno, 3);
			jugadorH4.setCantidadAciertos(new Random().nextInt(5));
			jugadorH4.setCantidadErrores(new Random().nextInt(5));
				
			DetalleJugador detalleJugadorH1 = new DetalleJugador(jugadorH1);
			DetalleJugador detalleJugadorH2 = new DetalleJugador(jugadorH2);
			DetalleJugador detalleJugadorH3 = new DetalleJugador(jugadorH3);
			DetalleJugador detalleJugadorH4 = new DetalleJugador(jugadorH4);
			
			Estadistica estadistica = cEtadistica.nuevo(detalleJugadorH1, detalleJugadorH2, detalleJugadorH3, detalleJugadorH4);
			cEtadistica.guardar(estadistica);
		}
		
		
	}

}
