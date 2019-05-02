package com.kevin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main extends JFrame{
	
	JButton iniciar;
	JButton cargarPartida;
	JButton reportes;
	JButton ayuda;
	
	public static void main(String argumentos [] ) {
		new main();
	}
	
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializarComponentes();
		setSize(1000,500);
		setLocationRelativeTo(null);
		setTitle("JUEGO DE TANQUES Y AVIONES");
		setVisible(true);
	}
	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		Color fondo= new Color(0,35,60);
		
		iniciar = new JButton("Inciar Paritda");
		iniciar.addActionListener(new Evento());
		cargarPartida = new JButton("Cargar Partida");
		cargarPartida.addActionListener(new Evento());
		reportes = new JButton("Reportes");
		reportes.addActionListener(new Evento());
		ayuda = new JButton("Ayuda");
		ayuda.addActionListener(new Evento());
		cargarPartida = new JButton("Cargar Partida");
		cargarPartida.addActionListener(new Evento());
		
		JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(iniciar);
        buttonPanel.add(cargarPartida);
        buttonPanel.add(reportes);
        buttonPanel.add(ayuda);

		
        JLabel imageLabel =new JLabel();
        imageLabel.setIcon(new ImageIcon("aviones y tanques.jpg"));
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
		imagePanel.setSize(300,300);
        
		setLayout(new BorderLayout());
		add(buttonPanel,BorderLayout.PAGE_START);
		add(imagePanel,BorderLayout.CENTER);
		setBackground(fondo);
	}
	class Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(iniciar)) {
				Formulario frame = new Formulario();
				frame.setVisible(true);
			}
			
		}
		
	}
}
