package com.kevin;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FormularioDeJugador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8000L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField nombreVehiculo1;
	private JTextField nombreVehiculo2;
	private JTextField nombreVehiculo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioDeJugador frame = new FormularioDeJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioDeJugador() {
		setBounds(100, 100, 720, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormularioDeJugadores = new JLabel("FORMULARIO DE JUGADORES");
		lblFormularioDeJugadores.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 20));
		lblFormularioDeJugadores.setBounds(28, 12, 415, 30);
		contentPane.add(lblFormularioDeJugadores);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(28, 56, 60, 17);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(106, 54, 325, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblVehiculo = new JLabel("Vehiculo ");
		lblVehiculo.setForeground(Color.WHITE);
		lblVehiculo.setBounds(28, 125, 60, 17);
		contentPane.add(lblVehiculo);
		
		JLabel label = new JLabel("Vehiculo ");
		label.setForeground(Color.WHITE);
		label.setBounds(28, 216, 60, 17);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Vehiculo ");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(28, 310, 60, 17);
		contentPane.add(label_1);
		
		JComboBox<String> comboBoxVehiculo1 = new JComboBox<String>();
		comboBoxVehiculo1.setBounds(28, 164, 207, 26);
		comboBoxVehiculo1.addItem("Avion");
		comboBoxVehiculo1.addItem("Tanque");
		contentPane.add(comboBoxVehiculo1);
		
		JComboBox<String> comboBoxVehiculo2 = new JComboBox<String>();
		comboBoxVehiculo2.setBounds(28, 249, 207, 26);
		comboBoxVehiculo2.addItem("Avion");
		comboBoxVehiculo2.addItem("Tanque");
		contentPane.add(comboBoxVehiculo2);
		
		JComboBox <String>comboBoxVehiculo3 = new JComboBox<String>();
		comboBoxVehiculo3.setBounds(28, 338, 207, 26);
		comboBoxVehiculo3.addItem("Avion");
		comboBoxVehiculo3.addItem("Tanque");
		contentPane.add(comboBoxVehiculo3);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Jugador(textFieldNombre.getText(),
						nombreVehiculo1.getText(),comboBoxVehiculo1.getSelectedIndex(),
						nombreVehiculo2.getText(),comboBoxVehiculo2.getSelectedIndex(),
						nombreVehiculo3.getText(),comboBoxVehiculo3.getSelectedIndex());
				JOptionPane.showMessageDialog(null, "Se ha creado un nuevo usuario correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		});
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setIcon(new ImageIcon("/home/kevin/eclipse-workspace/PF-IPC1-2019/Iconos/aceptar.png"));
		btnAceptar.setBounds(223, 376, 182, 50);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon("/home/kevin/eclipse-workspace/PF-IPC1-2019/Iconos/cancelar.png"));
		btnCancelar.setBounds(417, 376, 158, 50);
		contentPane.add(btnCancelar);
		
		nombreVehiculo1 = new JTextField();
		nombreVehiculo1.setBounds(120, 123, 182, 21);
		contentPane.add(nombreVehiculo1);
		nombreVehiculo1.setColumns(10);
		
		nombreVehiculo2 = new JTextField();
		nombreVehiculo2.setBounds(120, 214, 182, 21);
		contentPane.add(nombreVehiculo2);
		nombreVehiculo2.setColumns(10);
		
		nombreVehiculo3 = new JTextField();
		nombreVehiculo3.setBounds(120, 308, 182, 21);
		contentPane.add(nombreVehiculo3);
		nombreVehiculo3.setColumns(10);
		
		setVisible(true);
	}
}
