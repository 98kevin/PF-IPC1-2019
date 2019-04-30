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
	JButton reportes;
	JButton ayuda;
	JButton salir;
	
	public static void main(String argumentos [] ) {
		new main();
	}
	
	public main() {
		inicializarComponentes();
		setSize(1000,500);
		setVisible(true);
	}
	private void inicializarComponentes() {
		// TODO Auto-generated method stub
		Color fondo= new Color(0,35,60);
		
		iniciar = new JButton("Inciar");
		reportes = new JButton("Reportes");
		ayuda = new JButton("Ayuda");
		salir = new JButton("Salir");
		
		JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(iniciar);
        buttonPanel.add(reportes);
        buttonPanel.add(ayuda);
        buttonPanel.add(salir);
		
        JLabel imageLabel =new JLabel();
        imageLabel.setIcon(new ImageIcon("/home/kevin/eclipse-workspace/PF-IPC1-FINAL/aviones y tanques.jpg"));
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
				
			}
			
		}
		
	}
}
