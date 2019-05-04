package com.kevin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Formulario extends JFrame {

	private static final int JUGADOR_vs_JUGADOR = 0;
	private static final int JUGADOR_vs_PC = 1;
	private static final int AVION = 0;
	private static final int TANQUE = 0;
	
	
	private JComboBox []comboBoxVehiculo;
	private JTextField [] textFieldsNombreVehiculo;
	
	private JPanel panelDeContenidos;
	private JTextField textFieldJugador1;
	private JTextField textFieldJugador2;
	private JPanel panelJugador1;
	private JPanel panelJugador2;
	
	/**
	 * Create the frame.
	 */
	public Formulario() {
		
		comboBoxVehiculo= new JComboBox[6];
		textFieldsNombreVehiculo= new JTextField[6];
		setSize( 817, 618);
		setLocationRelativeTo(null);
		panelDeContenidos = new JPanel();
		panelDeContenidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelDeContenidos);
		panelDeContenidos.setLayout(null);
		
		panelJugador1 = new JPanel();
		panelJugador1.setBounds(12, 126, 780, 154);
		panelDeContenidos.add(panelJugador1);
		panelJugador1.setLayout(null);
		
		JPanel panelTipoJuego = new JPanel();
		panelTipoJuego.setBounds(12, 54, 780, 72);
		panelDeContenidos.add(panelTipoJuego);
		panelTipoJuego.setLayout(null);
		
		JLabel lblTipoDeJuego = new JLabel("Tipo de Juego");
		lblTipoDeJuego.setBounds(12, 27, 117, 17);
		panelTipoJuego.add(lblTipoDeJuego);
		
		JComboBox<String> comboBoxTipoJuego = new JComboBox<String>();
		comboBoxTipoJuego.addItem("Jugador vs Jugador");
		comboBoxTipoJuego.addItem("Jugador vs Computadora");
		comboBoxTipoJuego.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxTipoJuego.getSelectedIndex()==JUGADOR_vs_JUGADOR) {
					panelJugador1.setVisible(true);
					panelJugador2.setVisible(true);
				}
				if(comboBoxTipoJuego.getSelectedIndex()==JUGADOR_vs_PC) {
					panelJugador1.setVisible(true);
					panelJugador2.setVisible(false);
				}
			}
		});
		comboBoxTipoJuego.setBounds(133, 22, 254, 26);
		panelTipoJuego.add(comboBoxTipoJuego);
		
		JLabel esenario = new JLabel("Tamanio del Esenario");
		esenario.setBounds(410, 27, 200, 17);
		panelTipoJuego.add(esenario);
		JComboBox<String> tipoEsenario = new JComboBox<String>();
		tipoEsenario.addItem("4 x 4");
		tipoEsenario.addItem("6 x 4");
		tipoEsenario.addItem("8 x 9");
		tipoEsenario.setBounds(590, 22, 150, 26);
		panelTipoJuego.add(tipoEsenario);		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 49, 17);
		panelJugador1.add(lblNombre);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setBounds(79, 10, 278, 21);
		panelJugador1.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 41, 243, 96);
		panelJugador1.add(panel_1);
		panel_1.setLayout(null);
				
		 comboBoxVehiculo [0]= new JComboBox<String>();
		 comboBoxVehiculo [0].setBounds(12, 12, 206, 26);
		panel_1.add( comboBoxVehiculo [0]);
		 comboBoxVehiculo [0].addItem("Avion");
		 comboBoxVehiculo [0].addItem("Tanque");
		
		textFieldsNombreVehiculo[0] = new JTextField();
		textFieldsNombreVehiculo[0] .setBounds(12, 50, 206, 21);
		panel_1.add(textFieldsNombreVehiculo[0] );
		textFieldsNombreVehiculo[0] .setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(267, 41, 243, 96);
		panelJugador1.add(panel_2);
		
		 comboBoxVehiculo [1] = new JComboBox();
		comboBoxVehiculo [1].addItem("Avion");
		comboBoxVehiculo [1].addItem("Tanque");
		comboBoxVehiculo [1].setBounds(12, 12, 206, 26);
		panel_2.add(comboBoxVehiculo [1]);
		
		textFieldsNombreVehiculo[1]  = new JTextField();
		textFieldsNombreVehiculo[1]  .setColumns(10);
		textFieldsNombreVehiculo[1]  .setBounds(12, 50, 206, 21);
		panel_2.add(textFieldsNombreVehiculo[1]  );
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(522, 41, 243, 96);
		panelJugador1.add(panel_3);
		
		comboBoxVehiculo [2] = new JComboBox();
		comboBoxVehiculo [2].setBounds(12, 12, 206, 26);
		comboBoxVehiculo [2].addItem("Avion");
		comboBoxVehiculo [2].addItem("Tanque");
		panel_3.add(comboBoxVehiculo [2]);
		
		textFieldsNombreVehiculo[2]   = new JTextField();
		textFieldsNombreVehiculo[2].setColumns(10);
		textFieldsNombreVehiculo[2].setBounds(12, 50, 206, 21);
		panel_3.add(textFieldsNombreVehiculo[2]);
		
		panelJugador2 = new JPanel();
		panelJugador2.setLayout(null);
		panelJugador2.setBounds(12, 292, 787, 141);
		panelDeContenidos.add(panelJugador2);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(12, 12, 49, 17);
		panelJugador2.add(label);
		
		textFieldJugador2 = new JTextField();
		textFieldJugador2.setColumns(10);
		textFieldJugador2.setBounds(79, 10, 278, 21);
		panelJugador2.add(textFieldJugador2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(12, 41, 243, 96);
		panelJugador2.add(panel_4);
		
		comboBoxVehiculo [3] = new JComboBox();
		comboBoxVehiculo [3].setBounds(12, 12, 206, 26);
		comboBoxVehiculo [3].addItem("Avion");
		comboBoxVehiculo [3].addItem("Tanque");
		panel_4.add(comboBoxVehiculo [3]);
		
		textFieldsNombreVehiculo[3] = new JTextField();
		textFieldsNombreVehiculo[3] .setColumns(10);
		textFieldsNombreVehiculo[3] .setBounds(12, 50, 206, 21);
		panel_4.add(textFieldsNombreVehiculo[3] );
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(267, 41, 243, 96);
		panelJugador2.add(panel_5);
		
		comboBoxVehiculo [4] = new JComboBox();
		comboBoxVehiculo [4].setBounds(12, 12, 206, 26);
		comboBoxVehiculo [4].addItem("Avion");
		comboBoxVehiculo [4].addItem("Tanque");
		panel_5.add(comboBoxVehiculo [4]);
		
		textFieldsNombreVehiculo[4]  = new JTextField();
		textFieldsNombreVehiculo[4].setColumns(10);
		textFieldsNombreVehiculo[4].setBounds(12, 50, 206, 21);
		panel_5.add(textFieldsNombreVehiculo[4]);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(522, 41, 243, 96);
		panelJugador2.add(panel_6);
		
		comboBoxVehiculo [5] = new JComboBox();
		comboBoxVehiculo [5].setBounds(12, 12, 206, 26);
		comboBoxVehiculo [5].addItem("Avion");
		comboBoxVehiculo [5].addItem("Tanque");
		panel_6.add(comboBoxVehiculo [5]);
		
		textFieldsNombreVehiculo[5] = new JTextField();
		textFieldsNombreVehiculo[5].setColumns(10);
		textFieldsNombreVehiculo[5].setBounds(12, 50, 206, 21);
		panel_6.add(textFieldsNombreVehiculo[5]);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 435, 787, 44);
		panelDeContenidos.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Juego(comboBoxTipoJuego, tipoEsenario, textFieldJugador1,textFieldJugador2,comboBoxVehiculo,textFieldsNombreVehiculo);
				setVisible(false);
			}
		});
		btnAceptar.setBounds(548, 12, 105, 27);
		buttonPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(665, 12, 105, 27);
		buttonPanel.add(btnCancelar);
		
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(12, 0, 780, 52);
		panelDeContenidos.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		JLabel lblIngresoDeDatos = new JLabel("INGRESO DE DATOS");
		lblIngresoDeDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		panelTitulo.add(lblIngresoDeDatos);
		setVisible(true);
	}
}
