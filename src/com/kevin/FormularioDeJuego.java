package com.kevin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormularioDeJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9000L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioDeJuego frame = new FormularioDeJuego();
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
	public FormularioDeJuego() {
		setResizable(false);
		setBounds(100, 100, 451, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloDelFormulario = new JLabel("FORMULARIO DE JUEGO");
		lblTituloDelFormulario.setFont(new Font("Dialog", Font.BOLD, 21));
		lblTituloDelFormulario.setBounds(34, 12, 367, 17);
		contentPane.add(lblTituloDelFormulario);
		
		JLabel lblTipoDeJuego = new JLabel("Tipo de Juego");
		lblTipoDeJuego.setForeground(Color.WHITE);
		lblTipoDeJuego.setBounds(34, 54, 105, 17);
		contentPane.add(lblTipoDeJuego);
		
		JComboBox<String> comboBoxTipoDeJuego = new JComboBox<String>();
		comboBoxTipoDeJuego.setBounds(157, 49, 214, 26);
		new Juego().agregarTiposDeJuego(comboBoxTipoDeJuego);
		contentPane.add(comboBoxTipoDeJuego);
		
		JLabel lblPrimerJugador = new JLabel("Primer Jugador");
		lblPrimerJugador.setForeground(Color.WHITE);
		lblPrimerJugador.setBounds(34, 109, 105, 17);
		contentPane.add(lblPrimerJugador);
		
		JLabel lblSegundoJugador = new JLabel("Segundo Jugador");
		lblSegundoJugador.setForeground(Color.WHITE);
		lblSegundoJugador.setBounds(34, 159, 126, 17);
		contentPane.add(lblSegundoJugador);
		
		JLabel lblEsenario = new JLabel("Esenario");
		lblEsenario.setForeground(Color.WHITE);
		lblEsenario.setBounds(34, 216, 60, 17);
		contentPane.add(lblEsenario);
		
		JComboBox<String > comboBoxJugador1 = new JComboBox<String>();
		comboBoxJugador1.setBounds(157, 104, 214, 26);
		new Jugador().agregarItemsDeJugadores(comboBoxJugador1);
		contentPane.add(comboBoxJugador1);
		
		JComboBox<String> comboBoxJugador2 = new JComboBox<String>();
		comboBoxJugador2.setBounds(157, 154, 214, 26);
		new Jugador().agregarItemsDeJugadores(comboBoxJugador2);
		contentPane.add(comboBoxJugador2);
		
		JComboBox<String> comboBoxEsenario = new JComboBox<String>();
		comboBoxEsenario.setBounds(112, 211, 202, 26);
		new Juego().agregarTiposDeEsenario(comboBoxEsenario);
		contentPane.add(comboBoxEsenario);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Esenario(comboBoxTipoDeJuego,comboBoxJugador1,comboBoxJugador2,comboBoxEsenario);
				setVisible(false);
			}
		});
		btnAceptar.setIcon(new ImageIcon("Iconos/aceptar.png"));
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBounds(48, 334, 148, 49);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("Iconos/cancelar.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(208, 334, 163, 49);
		contentPane.add(btnCancelar);
		setVisible(true);
	}

}
