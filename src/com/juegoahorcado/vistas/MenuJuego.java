package com.juegoahorcado.vistas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.LineBorder;

import com.juegoahorcado.controladoras.ControladoraJuego;
import com.juegoahorcado.modelos.Jugador;
import com.juegoahorcado.modelos.JugadorHumano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;

public class MenuJuego implements Observer {

	private ControladoraJuego controladora;
	private ArrayList<JButton> listaBotones;

	private JFrame frame;
	private JTextField tfNombreJugador;
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
		this.controladora.registrarEventoJuegoTerminado(this);
		this.listaBotones = new ArrayList<>();
		this.initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 678, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelJugador = new JPanel();
		panelJugador.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelJugador.setBounds(10, 11, 375, 418);
		frame.getContentPane().add(panelJugador);
		panelJugador.setLayout(null);

		Canvas estadoTurnoJ = new Canvas();
		estadoTurnoJ.setBackground(Color.RED);
		estadoTurnoJ.setBounds(10, 10, 355, 7);
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

		JPanel panel = new JPanel();
		panel.setBounds(98, 365, 178, 42);
		panelJugador.add(panel);

		JLabel lblPalabra = new JLabel("PA_A_RA");
		lblPalabra.setLocation(74, 5);
		lblPalabra.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPalabra);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(395, 11, 267, 134);
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
		panel_2.setBounds(46, 82, 178, 42);
		panel_1.add(panel_2);

		JLabel lblPalabraMaq1 = new JLabel("PA_A_RA");
		lblPalabraMaq1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_2.add(lblPalabraMaq1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(395, 156, 267, 134);
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
		panel_4.setBounds(49, 82, 178, 42);
		panel_3.add(panel_4);

		JLabel lblPalabraMaq2 = new JLabel("PA_A_RA");
		lblPalabraMaq2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_4.add(lblPalabraMaq2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(395, 301, 267, 134);
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
		panel_6.setBounds(49, 82, 178, 42);
		panel_5.add(panel_6);

		JLabel lblPalabraMaq3 = new JLabel("PA_A_RA");
		lblPalabraMaq3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_6.add(lblPalabraMaq3);

		JLabel lblVidas = new JLabel("Vidas:");
		lblVidas.setBounds(10, 54, 46, 14);
		panelJugador.add(lblVidas);

		tfJugador1 = new JTextField();
		tfJugador1.setEditable(false);
		tfJugador1.setBounds(66, 51, 92, 20);
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
				jugadorTemp, this.listaBotones).update();
		tfNombreJugador.setText(jugadorTemp.getNombre());
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(31, 79, 311, 145);
		panelJugador.add(panel_7);
		
		JButton btnA = new JButton("A");
		this.listaBotones.add(btnA);
		btnA.setBounds(7, 5, 42, 23);
		btnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.setLayout(null);
		panel_7.add(btnA);
		
		JButton btnB = new JButton("B");
		this.listaBotones.add(btnB);
		btnB.setBounds(59, 5, 42, 23);
		btnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnB);
		
		JButton btnC = new JButton("C");
		this.listaBotones.add(btnC);
		btnC.setBounds(111, 5, 42, 23);
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnC);
		
		JButton btnD = new JButton("D");
		this.listaBotones.add(btnD);
		btnD.setBounds(163, 5, 42, 23);
		btnD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnD);
		
		JButton btnE = new JButton("E");
		this.listaBotones.add(btnE);
		btnE.setBounds(215, 5, 42, 23);
		btnE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnE);
		
		JButton btnF = new JButton("F");
		this.listaBotones.add(btnF);
		btnF.setBounds(267, 5, 42, 23);
		btnF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnF);
		
		JButton btnG = new JButton("G");
		this.listaBotones.add(btnG);
		btnG.setBounds(7, 33, 42, 23);
		btnG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnG);
		
		JButton btnH = new JButton("H");
		this.listaBotones.add(btnH);
		btnH.setBounds(59, 33, 42, 23);
		btnH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnH);
		
		JButton btnI = new JButton("I");
		this.listaBotones.add(btnI);
		btnI.setBounds(111, 33, 42, 23);
		btnI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnI);
		
		JButton btnJ = new JButton("J");
		this.listaBotones.add(btnJ);
		btnJ.setBounds(163, 33, 42, 23);
		btnJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnJ);
		
		JButton btnK = new JButton("K");
		this.listaBotones.add(btnK);
		btnK.setBounds(215, 33, 42, 23);
		btnK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnK);
		
		JButton btnL = new JButton("L");
		this.listaBotones.add(btnL);
		btnL.setBounds(267, 33, 42, 23);
		btnL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnL);
		
		JButton btnM = new JButton("M");
		this.listaBotones.add(btnM);
		btnM.setBounds(7, 61, 42, 23);
		btnM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnM);
		
		JButton btnN = new JButton("N");
		this.listaBotones.add(btnN);
		btnN.setBounds(59, 61, 42, 23);
		btnN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnN);
		
		JButton btnO = new JButton("O");
		this.listaBotones.add(btnO);
		btnO.setBounds(111, 61, 42, 23);
		btnO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnO);
		
		JButton btnP = new JButton("P");
		this.listaBotones.add(btnP);
		btnP.setBounds(163, 61, 42, 23);
		btnP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnP);
		
		JButton btnQ = new JButton("Q");
		this.listaBotones.add(btnQ);
		btnQ.setBounds(215, 61, 42, 23);
		btnQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnQ);
		
		JButton btnR = new JButton("R");
		this.listaBotones.add(btnR);
		btnR.setBounds(267, 61, 42, 23);
		btnR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnR);
		
		JButton btnS = new JButton("S");
		this.listaBotones.add(btnS);
		btnS.setBounds(7, 89, 42, 23);
		btnS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnS);
		
		JButton btnT = new JButton("T");
		this.listaBotones.add(btnT);
		btnT.setBounds(59, 89, 42, 23);
		btnT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnT);
		
		JButton btnU = new JButton("U");
		this.listaBotones.add(btnU);
		btnU.setBounds(111, 89, 42, 23);
		btnU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnU);
		
		JButton btnV = new JButton("V");
		this.listaBotones.add(btnV);
		btnV.setBounds(163, 89, 42, 23);
		btnV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnV);
		
		JButton btnW = new JButton("W");
		this.listaBotones.add(btnW);
		btnW.setBounds(215, 89, 42, 23);
		btnW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnW);
		
		JButton btnX = new JButton("X");
		this.listaBotones.add(btnX);
		btnX.setBounds(267, 89, 42, 23);
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnX);
		
		JButton btnY = new JButton("Y");
		this.listaBotones.add(btnY);
		btnY.setBounds(111, 117, 42, 23);
		btnY.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnY);
		
		JButton btnZ = new JButton("Z");
		this.listaBotones.add(btnZ);
		btnZ.setBounds(163, 117, 42, 23);
		btnZ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClickLetra(e);
			}
		});
		panel_7.add(btnZ);
		

		jugadorTemp = this.controladora.getJugador(1);
		new PanelJugadorMaquina(lblPalabraMaq1, tfJugador2, this.controladora.getCantidadLetrasDePalabra(), canvas,
				jugadorTemp).update();
		tfJugadorMaquina1.setText(jugadorTemp.getNombre());

		jugadorTemp = this.controladora.getJugador(2);
		new PanelJugadorMaquina(lblPalabraMaq2, tfJugador3, this.controladora.getCantidadLetrasDePalabra(), canvas_1,
				jugadorTemp).update();
		tfJugadorMaquina2.setText(jugadorTemp.getNombre());

		jugadorTemp = this.controladora.getJugador(3);
		new PanelJugadorMaquina(lblPalabraMaq3, tfJugador4, this.controladora.getCantidadLetrasDePalabra(), canvas_2,
				jugadorTemp).update();
		tfJugadorMaquina3.setText(jugadorTemp.getNombre());
	}

	@Override
	public void update(Observable o, Object arg) {
		Jugador jugador = null;
		if (arg != null)
			jugador = (Jugador) arg;
		new DialogJuegoTerminado(jugador);
		this.frame.setVisible(false);
	}
	
	private void onClickLetra (MouseEvent e) {
		JButton btn =(JButton)e.getSource();
		if (!btn.isEnabled())
			return;
		
		this.listaBotones.remove(btn);
		btn.setEnabled(false);
		this.controladora.setEntradaPersonaje(btn.getText().charAt(0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected class PanelJugador implements Observer {

		private JLabel lblLetrasCompletas;
		private JTextField tfVida;
		private Canvas canvas;

		private Jugador jugador = null;
		private String palabra = "";
		
		private ArrayList<JButton> listaBotones;

		public PanelJugador(JLabel lblLetrasCompletas, JTextField tfVida, int cantidadLetras, Canvas canvas,
				Jugador jugador, ArrayList<JButton> lista) {
			this.jugador = jugador;
			this.jugador.addObserver(this);
			this.tfVida = tfVida;

			this.canvas = canvas;
			
			this.listaBotones = lista;

			this.lblLetrasCompletas = lblLetrasCompletas;
			// cargar palabra
			for (int i = 0; i < cantidadLetras; i++) {
				this.palabra += "_";
			}
			this.lblLetrasCompletas.setText(this.palabra);
		}

		protected void ingresarLetra(char letra, ArrayList<Integer> posiciones) {
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

			if (this.jugador.isEsMiTurno()) {
				canvas.setBackground(Color.GREEN);
				if(this.listaBotones != null){
					for(int i =0; i<this.listaBotones.size(); i++){
						this.listaBotones.get(i).setEnabled(true);
					}
				}
		} else {
				canvas.setBackground(Color.RED);
				if(this.listaBotones != null){
					for(int i =0; i<this.listaBotones.size(); i++){
						this.listaBotones.get(i).setEnabled(false);
					}
				}
			}
		}
	}

	protected class PanelJugadorMaquina extends PanelJugador {

		public PanelJugadorMaquina(JLabel lblLetrasCompletas, JTextField tfVida, int cantidadLetras, Canvas canvas,
				Jugador jugador) {
			super(lblLetrasCompletas, tfVida, cantidadLetras, canvas, jugador, null);
		}

		/* (non-Javadoc)
		 * @see com.juegoahorcado.vistas.MenuJuego.PanelJugador#ingresarLetra(char, java.util.ArrayList)
		 */
		@Override
		protected void ingresarLetra(char letra, ArrayList<Integer> posiciones) {
			super.ingresarLetra('*', posiciones);
		}
		
		
	}
}
