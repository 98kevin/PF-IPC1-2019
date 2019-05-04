package com.kevin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FormularioDeArmas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldAtaque;
	private JTextField textFieldPunteria;
	private JTextField textFieldPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioDeArmas frame = new FormularioDeArmas();
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
	public FormularioDeArmas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreacionDeArmas = new JLabel("Creacion De Armas");
		lblCreacionDeArmas.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCreacionDeArmas.setBounds(150, 12, 191, 17);
		contentPane.add(lblCreacionDeArmas);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 58, 60, 17);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(114, 56, 186, 21);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(32, 91, 60, 17);
		contentPane.add(lblAtaque);
		
		textFieldAtaque = new JTextField();
		textFieldAtaque.setBounds(114, 89, 60, 21);
		contentPane.add(textFieldAtaque);
		textFieldAtaque.setColumns(10);
		
		JLabel lblPunteria = new JLabel("Punteria");
		lblPunteria.setBounds(32, 126, 60, 17);
		contentPane.add(lblPunteria);
		
		textFieldPunteria = new JTextField();
		textFieldPunteria.setBounds(114, 124, 60, 21);
		contentPane.add(textFieldPunteria);
		textFieldPunteria.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(32, 166, 60, 17);
		contentPane.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(114, 164, 60, 21);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(239, 91, 60, 17);
		contentPane.add(lblImagen);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & PNG", "jpg", "png");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			    }
			}
		});
		btnSeleccionar.setBounds(305, 86, 105, 27);
		contentPane.add(btnSeleccionar);
		
		JLabel label = new JLabel("");
		label.setBounds(305, 140, 36, 32);
		contentPane.add(label);
	}
}
