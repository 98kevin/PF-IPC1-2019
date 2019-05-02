package com.kevin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipoDeJuego extends JFrame{
	JButton etq1;
	JButton etq2;
	JLabel etiqueta; 
	JButton btnAceptar;
	private  int tipoJuego;
	
	public TipoDeJuego() {
		iniciarlizarComponentes( );
		 final int lado=200;
		setSize(lado,lado);
		setLocationRelativeTo( null);
		setTitle("Seleccion del tipo de Juego");
		setResizable(false);
		setVisible(true);
	}

	private void iniciarlizarComponentes() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		 etq1 = new JButton();
		etq1.setIcon(new ImageIcon("jugadorvsjugador.png"));
		etq1.addActionListener(new Eventos());
		etq2 = new JButton();
		etq2.setIcon(new ImageIcon("jugador vs pc.png"));
		etq2.addActionListener(new Eventos());
		JPanel panel1 = new JPanel(new GridLayout(1, 2));
		panel1.add(etq1);
		panel1.add(etq2);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new Eventos());
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2.add(btnAceptar);

		etiqueta = new JLabel("Tipo de Juego");
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3.add(etiqueta);
		
		add(panel1,BorderLayout.PAGE_START);
		add(panel3,BorderLayout.CENTER);
		add(panel2,BorderLayout.PAGE_END);
	}
	
	class Eventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(etq1)) {
				etiqueta.setText("Jugador vs Juador");
				tipoJuego=0;
			}
			if(e.getSource().equals(etq2)) {
				etiqueta.setText("Jugador vs Computadora");
				tipoJuego=1;
			}
			if(e.getSource().equals(btnAceptar)) {
				new Juego(tipoJuego);
				setVisible(false);
			}
				
		}
		
	}
}
