package com.juegoahorcado.vistas;

import java.awt.EventQueue;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.juegoahorcado.controladoras.ControladoraEstadistica;
import com.juegoahorcado.modelos.DetalleJugador;
import com.juegoahorcado.modelos.Estadistica;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEstadisticas {

	private JFrame frmEstadisticas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEstadisticas window = new MenuEstadisticas();
					window.frmEstadisticas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuEstadisticas() {
		initialize();
		this.frmEstadisticas.setVisible(true);
		this.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEstadisticas = new JFrame();
		frmEstadisticas.setResizable(false);
		frmEstadisticas.setTitle("Estadisticas");
		frmEstadisticas.setBounds(100, 100, 585, 300);
		frmEstadisticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEstadisticas.getContentPane().setLayout(null);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickMenuPrincipal();
			}
		});
		btnMenuPrincipal.setBounds(10, 237, 101, 23);
		frmEstadisticas.getContentPane().add(btnMenuPrincipal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 559, 215);
		frmEstadisticas.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cantidad Acertadas", "Cantidad Errores", "Cantidad Perdidas", "Cantidad Ganadas"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		scrollPane.setViewportView(table);
	}
	
	
	void init () {
		ControladoraEstadistica controladora = new ControladoraEstadistica();
		List<Estadistica> listControladora = controladora.obtenerTodos();
		DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

		Hashtable<String, Object[]> table = new Hashtable<String, Object[]>();
		for (int i = 0; i < listControladora.size(); i++) {
			List<DetalleJugador> listDetalle = listControladora.get(i).getListaDetalles();
			for (Object asd : listDetalle) {
				DetalleJugador detalleJugador = (DetalleJugador) asd;
				if (table.containsKey(detalleJugador.getNombreJugador())) {
					Object[] row = table.get(detalleJugador.getNombreJugador());
					row[1] = ((int) row[1]) + detalleJugador.getCantidadAciertos();
					row[2] = ((int) row[2]) + detalleJugador.getCantidadErrores();
					row[3] = ((int) row[3]) + (!detalleJugador.getEsGanador() ? 1 : 0);
					row[4] = ((int) row[4]) + (detalleJugador.getEsGanador() ? 1 : 0);
				} else {
					table.put(detalleJugador.getNombreJugador(), new Object[] {
							detalleJugador.getNombreJugador(),
							detalleJugador.getCantidadAciertos(),
							detalleJugador.getCantidadErrores(),
							!detalleJugador.getEsGanador() ? 1 : 0,
							detalleJugador.getEsGanador() ? 1 : 0
					});
				}
			}
			/*for (DetalleJugador detalleJugador : listDetalle) {
				if (table.containsKey(detalleJugador.getNombreJugador())) {
					Object[] row = table.get(detalleJugador.getNombreJugador());
					row[1] = ((int) row[1]) + detalleJugador.getCantidadAciertos();
					row[2] = ((int) row[2]) + detalleJugador.getCantidadErrores();
					row[3] = ((int) row[3]) + (detalleJugador.getEsGanador() ? 1 : 0);
					row[4] = ((int) row[4]) + (!detalleJugador.getEsGanador() ? 1 : 0);
				} else {
					table.put(detalleJugador.getNombreJugador(), new Object[] {
							detalleJugador.getNombreJugador(),
							detalleJugador.getCantidadAciertos(),
							detalleJugador.getCantidadErrores(),
							detalleJugador.getEsGanador() ? 1 : 0,
							!detalleJugador.getEsGanador() ? 1 : 0
					});
				}
			}*/
		}
		
		Enumeration<Object[]> e = table.elements();
		while (e.hasMoreElements()) {
			Object[] objects = (Object[]) e.nextElement();
			tableModel.addRow(objects);
		}
	}
	
	private void onClickMenuPrincipal() {
		new MenuPrincipal();
		this.frmEstadisticas.setVisible(false);
	}
}
