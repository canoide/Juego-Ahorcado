package com.juegoahorcado.vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MenuPrincipal {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonNuevoJuego();
			}
		});
		btnNuevoJuego.setBounds(154, 69, 125, 23);
		frame.getContentPane().add(btnNuevoJuego);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonEstadisticas();
			}
		});
		btnEstadisticas.setBounds(154, 103, 125, 23);
		frame.getContentPane().add(btnEstadisticas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonSalir();
			}
		});
		btnSalir.setBounds(154, 171, 125, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnPalabras = new JButton("Palabras");
		btnPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonPalabras();
			}
		});
		btnPalabras.setBounds(154, 137, 125, 23);
		frame.getContentPane().add(btnPalabras);
	}

	
	// ------------------------- ONCLICK BUTTON --------------------------------------------
	private void onClickButtonNuevoJuego () {
		new MenuJuego("Alejandro", 5);
		this.frame.setVisible(false);
	}
	
	private void onClickButtonEstadisticas () {
		new MenuEstadisticas();
		this.frame.setVisible(false);
	}
	
	private void onClickButtonPalabras () {	
		new MenuPalabras();
		this.frame.setVisible(false);
	}
	
	private void onClickButtonSalir () {
		System.exit(0);
	}
}
