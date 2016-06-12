package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.List;

import com.juegoahorcado.utils.Utils;

public class JugadorMaquina extends Jugador {
	
	private List<Character> listaLetrasDisponibles;
	
	{
		// crear lista de letras disponibles
		listaLetrasDisponibles = Utils.convertirStringEnListaCharacter ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}
	
	public JugadorMaquina(String nombre, TurnoPalabra turnoPalabra, int vidas) {
		super(nombre, turnoPalabra, vidas);
	}

	@Override
	public void run() {
		while (!super.getTurnoPalabra().isJuegoTerminado()) {
			try {
				super.getTurnoPalabra().dameTurno(this);
				
				
				char letra = this.obtenerLetraAleatoria();
				List<Integer> tempListaLetras = super.getTurnoPalabra().proponerLetra(letra);
				if (tempListaLetras.size() > 0) {
					System.out.println("Acertado " + this.getNombre() + " la letra: " + letra);
					super.agregarLetraAcertada(letra, (ArrayList<Integer>) tempListaLetras);
					super.setCantidadAciertos(super.getCantidadAciertos() + 1);
				} else {
					System.out.println("Ha errado " + this.getNombre() + " la letra: " + letra);
					super.setCantidadErrores(super.getCantidadErrores() + 1);
				}
				
				if (super.getTurnoPalabra().getCantidadLetras() == super.getListaLetrasAcerdas().size()) {
					super.setEsGanador(true);
					this.setChanged();
					this.notifyObservers(this);
				}
				
				super.getTurnoPalabra().devolverTurno(this);
				
				Thread.sleep(Utils.getRandomRange(1, 12) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	private Character obtenerLetraAleatoria () {
		int indiceLetra = Utils.getRandomRange(0, this.listaLetrasDisponibles.size());
		char tempLetra = this.listaLetrasDisponibles.get(indiceLetra);
		
		this.listaLetrasDisponibles.remove(indiceLetra);
		
		return tempLetra;
	}
}
