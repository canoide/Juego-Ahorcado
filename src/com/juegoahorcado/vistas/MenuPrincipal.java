package com.juegoahorcado.vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MenuPrincipal {
	
	private JFrame frame;
	private JTextField tfNombreJugador;
	private JTextField tfVidas;

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
		btnNuevoJuego.setBounds(154, 98, 125, 23);
		frame.getContentPane().add(btnNuevoJuego);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonEstadisticas();
			}
		});
		btnEstadisticas.setBounds(154, 132, 125, 23);
		frame.getContentPane().add(btnEstadisticas);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonSalir();
			}
		});
		btnSalir.setBounds(154, 200, 125, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnPalabras = new JButton("Palabras");
		btnPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickButtonPalabras();
			}
		});
		btnPalabras.setBounds(154, 166, 125, 23);
		frame.getContentPane().add(btnPalabras);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(154, 44, 58, 14);
		frame.getContentPane().add(lblNombre);
		
		tfNombreJugador = new JTextField();
		tfNombreJugador.setBounds(210, 41, 69, 20);
		frame.getContentPane().add(tfNombreJugador);
		tfNombreJugador.setColumns(10);
		
		JLabel lblVidas = new JLabel("Vidas:");
		lblVidas.setBounds(154, 69, 46, 14);
		frame.getContentPane().add(lblVidas);
		
		tfVidas = new JTextField();
		tfVidas.setBounds(210, 67, 69, 20);
		frame.getContentPane().add(tfVidas);
		tfVidas.setColumns(10);
	}

	
	// ------------------------- ONCLICK BUTTON --------------------------------------------
	private void onClickButtonNuevoJuego () {
		if(!tfNombreJugador.getText().isEmpty()){
			try{
				if(!tfVidas.getText().isEmpty() && Integer.parseInt(tfVidas.getText())>0){
					new MenuJuego(tfNombreJugador.getText(), Integer.parseInt(tfVidas.getText()));
					this.frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "No ingreso una cantidad de vidas valida.");
				}
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Lo que ingreso no es un numero valido.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No ingreso un nombre valido.");
		}
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
