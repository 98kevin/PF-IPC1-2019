package com.kevin;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeleccionadorDeVehiculo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton avion;
	JButton tanque;
	JTextField txtNombre;
	JButton aceptar;
	JButton cancelar;
	
	public SeleccionadorDeVehiculo() {
		inicializarComponentes();
		setLocationRelativeTo(null);
		setSize(500,500);
		setVisible(true);
	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Seleccione su Vehiculo");
		panel1.add(label1);
		
		JPanel panel2 = new JPanel();
			JPanel subPanel21= new JPanel(new GridLayout(1,2));
			 avion = new JButton(new ImageIcon("avion-de-guerra64.png"));
			 avion.addActionListener(new Eventos());
			 tanque = new JButton(new ImageIcon("tanque64.png"));
			 tanque.addActionListener(new Eventos());
			subPanel21.add(avion);
			subPanel21.add(tanque);
			
			JPanel subPanel22= new JPanel();
			JLabel nombre = new JLabel("Nombre del Vehiculo: ");
			txtNombre= new JTextField();
			txtNombre.addActionListener(new Eventos());
			subPanel22.add(nombre);
			subPanel22.add(txtNombre);
		panel2.add(subPanel21);
		panel2.add(subPanel22);
		
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		aceptar= new JButton("Aceptar");
		aceptar.addActionListener(new Eventos());
		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(new Eventos());
		panel3.add(aceptar);
		panel3.add(cancelar);
		
		
	}
	class Eventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(aceptar)) {
				if(avion.isSelected())
					new Avion(txtNombre.getText());
				if(tanque.isSelected())
					new Tanque(txtNombre.getText());
			}
			if(e.getSource().equals(cancelar)) 
				setVisible(false);
		}
		
	}

}
