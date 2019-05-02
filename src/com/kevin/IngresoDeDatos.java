package com.kevin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngresoDeDatos extends JFrame{

	JTextField txtFld[];
	String nombre;
	JButton aceptar;
	JButton cancelar;
	Vehiculo [][] vehiculos; //matriz de vehiculos para los dos jugadores
	final int ancho=500;
	final int alto =200;
	
	public IngresoDeDatos(int tipoJuego) {
		if(tipoJuego==Juego.JUGADOR_JUGADOR) {
			txtFld= new JTextField[2];
			inicializarComponentes(2);
		}
		if(tipoJuego==Juego.JUGADOR_PC) {
			txtFld= new JTextField[1];
			inicializarComponentes(1);
		}
		setSize(ancho,alto);
		setLocationRelativeTo(null);
		setTitle("Ingreso de Datos");
		setVisible(true);
	}

	private void inicializarComponentes(int iteraciones) {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		
		JPanel panelTitulo= new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel etqTitulo = new JLabel("INGRESO DE DATOS");
		panelTitulo.add(etqTitulo);
		
		JPanel panelIngreso = new JPanel(new GridLayout(2,1));  //Almacena los paneles en dos filas y una columna
		for(int i=0; i<iteraciones;i++) {
			JPanel subPanel1= new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel etq = new JLabel("Nombre");
			txtFld [i]= new JTextField(20);
			txtFld[i].addActionListener(new Eventos());
			subPanel1.add(etq);
			subPanel1.add(txtFld[i]);
			
			panelIngreso.add(subPanel1);
		}
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		aceptar= new JButton("Aceptar");
		aceptar.addActionListener(new Eventos());
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(new Eventos());
		buttonPanel.add(aceptar);
		buttonPanel.add(cancelar);
		
		add(panelTitulo,BorderLayout.PAGE_START);
		add(panelIngreso,BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.PAGE_END);
		
	}
	
	private class Eventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(aceptar)) {
				Jugador jugadores[]= new Jugador [txtFld.length];
				for(int i=0; i<txtFld.length;i++) {
					jugadores[i]= new Jugador(txtFld[i].getText());
				}
				new Juego(jugadores);
				JOptionPane.showMessageDialog(null, "Jugador/es agreado/s exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
			if(e.getSource().equals(cancelar)) 
				setVisible(false);
		}
		
	}
}
