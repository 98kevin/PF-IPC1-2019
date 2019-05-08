package com.kevin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3000L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		Arma arma = new Arma();
		arma.escribirArmasBasicas();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1002, 588);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etiquetaDeFondo = new JLabel("");
		etiquetaDeFondo.setIcon(new ImageIcon("Imagenes/aviones y tanques.jpg"));
		etiquetaDeFondo.setBounds(0, 0, 1000, 561);
		contentPane.add(etiquetaDeFondo);
		
		JButton btnBoton = new JButton("Iniciar");
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioDeJuego();
			}
		});
		btnBoton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBoton.setBackground(Color.DARK_GRAY);
		btnBoton.setForeground(new Color(255, 255, 255));
		etiquetaDeFondo.add(btnBoton);
		btnBoton.setIcon(new ImageIcon("Iconos/iniciar.png"));
		btnBoton.setBounds(76, 134, 203, 74);
		
		JButton btnNewButton = new JButton("Crear Jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioDeJugador();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("Iconos/crearJugadores.png"));
		btnNewButton.setBounds(291, 134, 214, 74);
		etiquetaDeFondo.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Armas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioDeArmas();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setIcon(new ImageIcon("Iconos/crearArmas.png"));
		btnNewButton_1.setBounds(517, 134, 249, 74);
		etiquetaDeFondo.add(btnNewButton_1);
		
		JLabel lblTitulo = new JLabel("Tanques Y Aviones ");
		etiquetaDeFondo.add(lblTitulo);
		lblTitulo.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 18));
		lblTitulo.setBounds(413, 36, 214, 30);
	}
}
