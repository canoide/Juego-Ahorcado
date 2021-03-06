package com.juegoahorcado.vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.juegoahorcado.modelos.Jugador;
import com.juegoahorcado.modelos.JugadorHumano;
import com.juegoahorcado.modelos.JugadorMaquina;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DialogJuegoTerminado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfAciertos;
	private JTextField tfErrads;
	private JTextField txtAlejandro;

	/**
	 * Create the dialog.
	 */
	public DialogJuegoTerminado(Jugador jugador) {
		if (jugador != null) {
			
			this.initialize();
			
			if(jugador instanceof JugadorHumano && jugador.isEsGanador()){
				JLabel lblEstado = new JLabel("Gano! :)");
				lblEstado.setBounds(10, 128, 50, 14);
				contentPanel.add(lblEstado);
			} else if (jugador instanceof JugadorHumano && !jugador.isEsGanador()) {
				JLabel lblEstado = new JLabel("Perdio! :(");
				lblEstado.setBounds(10, 128, 50, 14);
				contentPanel.add(lblEstado);
			} else if (jugador instanceof JugadorMaquina && jugador.isEsGanador()){
				JLabel lblEstado = new JLabel("Gano " + jugador.getNombre());
				lblEstado.setBounds(5, 128, 80, 14);
				contentPanel.add(lblEstado);
			}
			
			this.txtAlejandro.setText(jugador.getNombre());
			this.tfAciertos.setText(jugador.getCantidadAciertos() + "");
			this.tfErrads.setText(jugador.getCantidadErrores() + "");
			
		} else {
			this.initializeSinGanador();
		}
		
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
	
	private void initializeSinGanador () {
		setBounds(100, 100, 205, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		JLabel lblNoHuboGanadores = new JLabel("No hubo Ganadores");
		lblNoHuboGanadores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoHuboGanadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoHuboGanadores.setBounds(10, 11, 169, 109);
		contentPanel.add(lblNoHuboGanadores);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAceptar();
			}
		});
		btnAceptar.setBounds(90, 124, 89, 23);
		contentPanel.add(btnAceptar);
	}
	
	private void initialize() {
		setBounds(100, 100, 205, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAceptar();
			}
		});
		btnAceptar.setBounds(90, 124, 89, 23);
		contentPanel.add(btnAceptar);
		
		JLabel lblGanador = new JLabel("JUGADOR:");
		lblGanador.setBounds(10, 15, 62, 27);
		contentPanel.add(lblGanador);
		
		JLabel lblAciertos = new JLabel("Aciertos: ");
		lblAciertos.setBounds(10, 66, 46, 14);
		contentPanel.add(lblAciertos);
		
		JLabel lblErrados = new JLabel("Errados:");
		lblErrados.setBounds(10, 91, 46, 14);
		contentPanel.add(lblErrados);
		
		tfAciertos = new JTextField();
		tfAciertos.setHorizontalAlignment(SwingConstants.RIGHT);
		tfAciertos.setEditable(false);
		tfAciertos.setBounds(66, 63, 113, 20);
		contentPanel.add(tfAciertos);
		tfAciertos.setColumns(10);
		
		tfErrads = new JTextField();
		tfErrads.setHorizontalAlignment(SwingConstants.RIGHT);
		tfErrads.setEditable(false);
		tfErrads.setColumns(10);
		tfErrads.setBounds(66, 88, 113, 20);
		contentPanel.add(tfErrads);
		
		txtAlejandro = new JTextField();
		txtAlejandro.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAlejandro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAlejandro.setText("JUGADOR");
		txtAlejandro.setEditable(false);
		txtAlejandro.setBounds(66, 11, 113, 32);
		contentPanel.add(txtAlejandro);
		txtAlejandro.setColumns(10);
	}
	
	private void onClickAceptar() {
		new MenuPrincipal();
		this.setVisible(false);
	}
}
