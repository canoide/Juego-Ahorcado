package com.juegoahorcado.modelos;

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

	/* (non-Javadoc)
	 * @see com.juegoahorcado.modelos.Jugador#aplicarDormir()
	 */
	@Override
	protected void aplicarDormir() throws InterruptedException {
		Thread.sleep(Utils.getRandomRange(15, 30) * 1000);
	}

	private Character obtenerLetraAleatoria () {
		int indiceLetra = Utils.getRandomRange(0, this.listaLetrasDisponibles.size());
		char tempLetra = this.listaLetrasDisponibles.get(indiceLetra);
		
		this.listaLetrasDisponibles.remove(indiceLetra);
		
		return tempLetra;
	}
	
	/* (non-Javadoc)
	 * @see com.juegoahorcado.modelos.Jugador#setInput(char)
	 */
	@Override
	public void setInput(char letra) {
		
	}

	/* (non-Javadoc)
	 * @see com.juegoahorcado.modelos.Jugador#getInput()
	 */
	@Override
	protected char getInput() throws InterruptedException {
		Thread.sleep(Utils.getRandomRange(5, 10) * 1000);
		return this.obtenerLetraAleatoria();
	}
}
