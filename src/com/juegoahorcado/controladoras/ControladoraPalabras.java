package com.juegoahorcado.controladoras;

import java.util.List;

import com.juegoahorcado.dao.PalabraDAO;
import com.juegoahorcado.modelos.Palabra;
import com.juegoahorcado.utils.Utils;

public class ControladoraPalabras {

	private PalabraDAO dao;
	
	public ControladoraPalabras() {
		this.dao = new PalabraDAO ();
	}
	
	public Palabra nuevaPalabra (String palabra) {
		Palabra tempPalabra = new Palabra(palabra);
		
		dao.guardar(tempPalabra);
		
		return tempPalabra;
	}
	
	public void modificar(int id, String palabra) {
		Palabra tempPalabra = this.dao.obtenerPorID(id);
		tempPalabra.setPalabra(palabra);
		this.dao.actualizar(tempPalabra);
	}
	
	public void eliminar(int id) {
		Palabra tempPalabra = this.dao.obtenerPorID(id);
		this.dao.eliminar(tempPalabra);
	}
	
	public Palabra obtenerPorId(int id) {
		return this.dao.obtenerPorID(id);
	}
	
	public List<Palabra> obtenerTodos() {
		return this.dao.obtenerLista();
	}
	
	public Palabra getRandomPalabra() {
		List<Palabra> lista = this.obtenerTodos();
		if (lista.size() == 0) {
			// si no existe palabras cargadas crea una
			return this.nuevaPalabra("PALABRA");
		}
		
		return lista.get(Utils.getRandomRange(1, lista.size()));
	}
}
