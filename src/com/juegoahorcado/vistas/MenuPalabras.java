package com.juegoahorcado.vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.juegoahorcado.controladoras.ControladoraPalabras;
import com.juegoahorcado.modelos.Palabra;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class MenuPalabras {

	private ControladoraPalabras controladora;

	private JFrame frame;
	private JTable table;

	DefaultTableModel tableMode = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "PALABRA" });
	private JTextField tfNombre;
	private JButton btnNuevo;
	private boolean isModificar = false; // para chequar si al apretar el boton
											// nuevo tiene que guardar o
											// modificar
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPalabras window = new MenuPalabras();
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
	public MenuPalabras() {
		initialize();
		frame.setVisible(true);
		
		controladora = new ControladoraPalabras();

		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Palabras");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickEliminar();
			}
		});
		btnEliminar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnEliminar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickModificar();
			}
		});
		btnModificar.setBounds(236, 227, 89, 23);
		frame.getContentPane().add(btnModificar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickNuevo();
			}
		});
		btnNuevo.setBounds(162, 11, 89, 23);
		frame.getContentPane().add(btnNuevo);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickVolver();
			}
		});
		btnVolver.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVolver);

		JLabel lblIngresar = new JLabel("Ingresar:");
		lblIngresar.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblIngresar);

		tfNombre = new JTextField();
		tfNombre.setBounds(66, 12, 86, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableMode);
		table.setBounds(10, 65, 414, 151);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		frame.getContentPane().add(table);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 64, 414, 152);
		frame.getContentPane().add(scrollPane);
	}

	private void onClickVolver() {
		new MenuPrincipal();
		this.frame.setVisible(false);
	}

	private void onClickNuevo() {
		if (!this.isModificar) {
			String palabra = this.tfNombre.getText();
			this.controladora.nuevaPalabra(palabra);
		} else {
			String palabra = this.tfNombre.getText();
			int id = (int) table.getValueAt(table.getSelectedRow(), 0);
			this.controladora.modificar(id, palabra);

			this.table.setEnabled(true);
			this.isModificar = false;
		}
		this.tfNombre.setText("");
		this.actualizarTabla();
	}

	private void onClickModificar() {
		if (table.getSelectedRow() != -1) {
			int id = (int) table.getValueAt(table.getSelectedRow(), 0);
			Palabra palabra = this.controladora.obtenerPorId(id);
			this.tfNombre.setText(palabra.getPalabra());

			this.table.setEnabled(false);
			this.isModificar = true;
		}
	}

	private void onClickEliminar() {
		if (table.getSelectedRow() != -1) {
			int id = (int) table.getValueAt(table.getSelectedRow(), 0);
			this.controladora.eliminar(id);
		}

		this.actualizarTabla();
	}

	private void actualizarTabla() {
		if (this.tableMode.getRowCount() > 0)
			this.limpiarTabla();

		List<Palabra> listaPalabras = this.controladora.obtenerTodos();

		Object[] linea = new Object[2];
		for (int i = 0; i < listaPalabras.size(); i++) {
			linea[0] = listaPalabras.get(i).getId();
			linea[1] = listaPalabras.get(i).getPalabra();

			tableMode.addRow(linea);
		}
	}

	private void limpiarTabla() {
		while (this.tableMode.getRowCount() > 0)
			this.tableMode.removeRow(0);
		;
	}
}
