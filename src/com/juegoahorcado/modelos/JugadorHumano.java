package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadorHumano extends Jugador {
	
	public JugadorHumano(String nombre, TurnoPalabra turnoPalabra, int vidas) {
		super(nombre, turnoPalabra, vidas);
	}

	@Override
	public void run() {
		while (!super.getTurnoPalabra().isJuegoTerminado()) {
			try {
				super.getTurnoPalabra().dameTurno(this);
				
				System.out.print("Ingrese su letra: ");
				Scanner reader = new Scanner(System.in);
				char letra = reader.next().charAt(0);
				
				
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
			
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
