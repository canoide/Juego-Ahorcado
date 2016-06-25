package com.juegoahorcado.modelos;

import java.util.ArrayList;
import java.util.List;

import com.juegoahorcado.utils.Utils;

public class Palabra implements Cloneable {

	private int id;
	
	private String palabra;
	
	private List<Character> listaLetras;
	
	private int cantidadLetrasDePalabra;
	
	private int cantidadLetras;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the palabra
	 */
	public String getPalabra() {
		return palabra;
	}

	/**
	 * @param palabra the palabra to set
	 */
	public void setPalabra(String palabra) {
		this.palabra = palabra;
		this.init();
	}

	/**
	 * @return the listaLetras
	 */
	public List<Character> getListaLetras() {
		return listaLetras;
	}

	/**
	 * @return La cantidad de letras de la palabra
	 */
	public int getCantidadLetrasDePalabra() {
		return cantidadLetrasDePalabra;
	}

	/**
	 * @return La cantidad de letras sin repetir
	 */
	public int getCantidadLetras() {
		return cantidadLetras;
	}

	public Palabra() {
		
	}

	public Palabra(String palabra) {
		this.palabra = palabra;
		this.init();
	}
	
	private void init() {
		this.listaLetras = Utils.convertirStringEnListaCharacter(palabra);
		
		this.cantidadLetrasDePalabra = this.listaLetras.size();
		
		ArrayList<Character> letraEncontradas = new ArrayList<Character>();
		
		for (int i = 0; i < cantidadLetrasDePalabra; i++) {
			Character letraEncontrada = this.listaLetras.get(i);
			
			for (int j = 0; j < letraEncontradas.size(); j++) {
				if (letraEncontrada.equals(letraEncontradas.get(j))) {
					letraEncontrada = '/';
					break;
				}
			}
			
			if (!letraEncontrada.equals('/'))
				letraEncontradas.add(letraEncontrada);
		}
		this.cantidadLetras = letraEncontradas.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Palabra palabra = (Palabra) super.clone();
		
		List<Character> listaTemp = new ArrayList<Character> ();
		for (int i = 0; i < this.listaLetras.size(); i++) {
			listaTemp.add(new Character(this.listaLetras.get(0)));
		}
		palabra.listaLetras = listaTemp;
		
		return palabra;
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
		
		Palabra palabra = (Palabra) obj;
		
		if (palabra.getId() != this.getId())
			return false;
		
		if (!palabra.getPalabra().equals(this.getPalabra()))
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
}
