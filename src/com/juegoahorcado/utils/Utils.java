package com.juegoahorcado.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<Character> convertirStringEnListaCharacter(String string) {
		// crea una lista temporal
		List<Character> tempListaLetras = new ArrayList<Character>();
		// crear array de letras
		char[] listaLetras = string.toCharArray();
		for (int i = 0; i < listaLetras.length; i++) {
			tempListaLetras.add(listaLetras[i]);
		}
		
		return tempListaLetras;
	}

	public static int getRandomRange(int min, int max) {
		return (min + (int)(Math.random() * max));
	}
}
