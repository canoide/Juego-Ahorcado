package com.juegoahorcado.vistas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.juegoahorcado.controladoras.ControladoraJuego;
import com.juegoahorcado.modelos.Jugador;
import javax.swing.border.LineBorder;

public class MenuJuego {

	private ControladoraJuego controladora;

	private JFrame frame;
	private JTextField tfNombreJugador;
	private JTextField tfIngreseLetra;
	private JTextField tfJugadorMaquina1;
	private JTextField tfJugadorMaquina2;
	private JTextField tfJugadorMaquina3;
	private JTextField tfJugador1;
	private JTextField tfJugador2;
	private JTextField tfJugador3;
	private JTextField tfJugador4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJuego window = new MenuJuego();
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
	public MenuJuego() {
		this.controladora = new ControladoraJuego("Jugador", 5, 3);
		initialize();
		this.frame.setVisible(true);
	}

	public MenuJuego(String nombre, int cantidadVidas) {
		this.controladora = new ControladoraJuego(nombre, cantidadVidas, 3);
		this.initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 568, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelJugador = new JPanel();
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBounds(10, 11, 267, 176);
		frame.getContentPane().add(panelJugador);
		panelJugador.setLayout(null);

		Canvas estadoTurnoJ = new Canvas();
		estadoTurnoJ.setBackground(Color.RED);
		estadoTurnoJ.setBounds(10, 10, 247, 7);
		panelJugador.add(estadoTurnoJ);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 26, 46, 14);
		panelJugador.add(lblNombre);

		tfNombreJugador = new JTextField();
		tfNombreJugador.setText("JUGADOR");
		tfNombreJugador.setEditable(false);
		tfNombreJugador.setBounds(66, 23, 191, 20);
		panelJugador.add(tfNombreJugador);
		tfNombreJugador.setColumns(10);

		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setBounds(10, 51, 46, 14);
		panelJugador.add(lblLetra);

		tfIngreseLetra = new JTextField();
		tfIngreseLetra.setBounds(66, 48, 92, 20);
		panelJugador.add(tfIngreseLetra);
		tfIngreseLetra.setColumns(10);

		JButton btnProbar = new JButton("Probar");
		btnProbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickProbar();
			}
		});
		btnProbar.setBounds(168, 47, 89, 23);
		panelJugador.add(btnProbar);

		JPanel panel = new JPanel();
		panel.setBounds(46, 103, 178, 42);
		panelJugador.add(panel);

		JLabel lblPalabra = new JLabel("PA_A_RA");
		lblPalabra.setLocation(74, 5);
		lblPalabra.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPalabra);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(287, 11, 267, 176);
		frame.getContentPane().add(panel_1);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.RED);
		canvas.setBounds(10, 10, 247, 7);
		panel_1.add(canvas);

		JLabel label = new JLabel("Nombre:");
		label.setBounds(10, 26, 46, 14);
		panel_1.add(label);

		tfJugadorMaquina1 = new JTextField();
		tfJugadorMaquina1.setText("JUGADOR");
		tfJugadorMaquina1.setEditable(false);
		tfJugadorMaquina1.setColumns(10);
		tfJugadorMaquina1.setBounds(66, 23, 191, 20);
		panel_1.add(tfJugadorMaquina1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(46, 103, 178, 42);
		panel_1.add(panel_2);

		JLabel lblPalabraMaq1 = new JLabel("PA_A_RA");
		lblPalabraMaq1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_2.add(lblPalabraMaq1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 198, 267, 176);
		frame.getContentPane().add(panel_3);

		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.RED);
		canvas_1.setBounds(10, 10, 247, 7);
		panel_3.add(canvas_1);

		JLabel label_3 = new JLabel("Nombre:");
		label_3.setBounds(10, 26, 46, 14);
		panel_3.add(label_3);

		tfJugadorMaquina2 = new JTextField();
		tfJugadorMaquina2.setText("JUGADOR");
		tfJugadorMaquina2.setEditable(false);
		tfJugadorMaquina2.setColumns(10);
		tfJugadorMaquina2.setBounds(66, 23, 191, 20);
		panel_3.add(tfJugadorMaquina2);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(49, 92, 178, 42);
		panel_3.add(panel_4);

		JLabel lblPalabraMaq2 = new JLabel("PA_A_RA");
		lblPalabraMaq2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_4.add(lblPalabraMaq2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(287, 198, 267, 176);
		frame.getContentPane().add(panel_5);

		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.RED);
		canvas_2.setBounds(10, 10, 247, 7);
		panel_5.add(canvas_2);

		JLabel label_6 = new JLabel("Nombre:");
		label_6.setBounds(10, 26, 46, 14);
		panel_5.add(label_6);

		tfJugadorMaquina3 = new JTextField();
		tfJugadorMaquina3.setText("JUGADOR");
		tfJugadorMaquina3.setEditable(false);
		tfJugadorMaquina3.setColumns(10);
		tfJugadorMaquina3.setBounds(66, 23, 191, 20);
		panel_5.add(tfJugadorMaquina3);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(49, 92, 178, 42);
		panel_5.add(panel_6);

		JLabel lblPalabraMaq3 = new JLabel("PA_A_RA");
		lblPalabraMaq3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_6.add(lblPalabraMaq3);

		JLabel lblVidas = new JLabel("Vidas:");
		lblVidas.setBounds(10, 76, 46, 14);
		panelJugador.add(lblVidas);

		tfJugador1 = new JTextField();
		tfJugador1.setEditable(false);
		tfJugador1.setBounds(66, 73, 92, 20);
		panelJugador.add(tfJugador1);
		tfJugador1.setColumns(10);

		tfJugador2 = new JTextField();
		tfJugador2.setEditable(false);
		tfJugador2.setColumns(10);
		tfJugador2.setBounds(66, 51, 92, 20);
		panel_1.add(tfJugador2);

		JLabel label_1 = new JLabel("Vidas:");
		label_1.setBounds(10, 54, 46, 14);
		panel_1.add(label_1);

		tfJugador3 = new JTextField();
		tfJugador3.setEditable(false);
		tfJugador3.setColumns(10);
		tfJugador3.setBounds(66, 51, 92, 20);
		panel_3.add(tfJugador3);

		JLabel label_2 = new JLabel("Vidas:");
		label_2.setBounds(10, 54, 46, 14);
		panel_3.add(label_2);

		tfJugador4 = new JTextField();
		tfJugador4.setEditable(false);
		tfJugador4.setColumns(10);
		tfJugador4.setBounds(66, 51, 92, 20);
		panel_5.add(tfJugador4);

		JLabel label_4 = new JLabel("Vidas:");
		label_4.setBounds(10, 54, 46, 14);
		panel_5.add(label_4);

		// INSTANCIANDO PANELES
		Jugador jugadorTemp = this.controladora.getJugador(0);
		new PanelJugador(lblPalabra, tfJugador1, this.controladora.getCantidadLetrasDePalabra(), estadoTurnoJ,
				jugadorTemp).update();
		tfNombreJugador.setText(jugadorTemp.getNombre());
		

		jugadorTemp = this.controladora.getJugador(1);
		new PanelJugador(lblPalabraMaq1, tfJugador2, this.controladora.getCantidadLetrasDePalabra(), canvas,
				jugadorTemp).update();
		tfJugadorMaquina1.setText(jugadorTemp.getNombre());

		jugadorTemp = this.controladora.getJugador(2);
		new PanelJugador(lblPalabraMaq2, tfJugador3, this.controladora.getCantidadLetrasDePalabra(), canvas_1,
				jugadorTemp).update();
		tfJugadorMaquina2.setText(jugadorTemp.getNombre());

		jugadorTemp = this.controladora.getJugador(3);
		new PanelJugador(lblPalabraMaq3, tfJugador4, this.controladora.getCantidadLetrasDePalabra(), canvas_2,
				jugadorTemp).update();
		tfJugadorMaquina3.setText(jugadorTemp.getNombre());
	}

	protected void onClickProbar() {
		this.controladora.setEntradaPersonaje(this.tfIngreseLetra.getText().charAt(0));
	}

	protected class PanelJugador implements Observer {

		private JLabel lblLetrasCompletas;
		private JTextField tfVida;
		private Canvas canvas;

		private Jugador jugador = null;
		private String palabra = "";

		public PanelJugador(JLabel lblLetrasCompletas, JTextField tfVida, int cantidadLetras, Canvas canvas,
				Jugador jugador) {
			this.jugador = jugador;
			this.jugador.addObserver(this);
			this.tfVida = tfVida;

			this.canvas = canvas;

			this.lblLetrasCompletas = lblLetrasCompletas;
			// cargar palabra
			for (int i = 0; i < cantidadLetras; i++) {
				this.palabra += "_";
			}
			this.lblLetrasCompletas.setText(this.palabra);
		}

		public void ingresarLetra(char letra, ArrayList<Integer> posiciones) {
			char[] letras = this.palabra.toCharArray();
			for (int i = 0; i < posiciones.size(); i++) {
				letras[posiciones.get(i)] = letra;
			}

			this.palabra = "";
			for (int i = 0; i < letras.length; i++) {
				this.palabra += letras[i];
			}

			this.lblLetrasCompletas.setText(this.palabra);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		@Override
		public void update(Observable o, Object arg) {
			this.update();
		}

		public void update() {
			Hashtable<Character, ArrayList<Integer>> listaLetras = this.jugador.getListaLetrasAcerdas();
			Enumeration<Character> e = listaLetras.keys();
			char clave;
			while (e.hasMoreElements()) {
				clave = (char) e.nextElement();
				this.ingresarLetra(clave, listaLetras.get(clave));
			}

			this.tfVida.setText(String.valueOf(this.jugador.getVidas()));

			if (this.jugador.isEsMiTurno())
				canvas.setBackground(Color.GREEN);
			else
				canvas.setBackground(Color.RED);
		}
	}
}
