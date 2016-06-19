package com.juegoahorcado.modelos;

import com.juegoahorcado.utils.Utils;

public class JugadorHumano extends Jugador {
	
	char letra = ' ';
	
	public JugadorHumano(String nombre, TurnoPalabra turnoPalabra, int vidas) {
		super(nombre, turnoPalabra, vidas);
	}

	/*
	@Override
	public char checkInput(char letra) {
		System.out.print("Ingrese Letra: ");
		letra = new Scanner(System.in).next().charAt(0);
		return letra;
	}*/
	
	public char getInput() throws InterruptedException {
		char letraTemp = new Character(letra);
		if (this.letra != ' ')
			this.letra = ' ';
		
		return letraTemp;
	}
	
	/* (non-Javadoc)
	 * @see com.juegoahorcado.modelos.Jugador#checkInput(char)
	 */
	@Override
	public void setInput(char letra) {
		this.letra = letra;
	}

	/* (non-Javadoc)
	 * @see com.juegoahorcado.modelos.Jugador#aplicarDormir()
	 */
	@Override
	protected void aplicarDormir() throws InterruptedException {
		Thread.sleep(Utils.getRandomRange(0, 10) * 1000);
	}

}
