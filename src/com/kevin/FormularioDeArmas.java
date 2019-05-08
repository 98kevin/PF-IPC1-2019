package com.kevin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;

public class FormularioDeArmas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10000L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldAtaque;
	private JTextField textFieldPunteria;
	private JTextField textFieldPrecio;

	private String nombreDeImagen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FormularioDeArmas frame = new FormularioDeArmas();
					new VentanaPrincipal().setVisible(true);
					//frame.setVisible(true);
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
		setSize( 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreacionDeArmas = new JLabel("Creacion De Armas");
		lblCreacionDeArmas.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCreacionDeArmas.setBounds(150, 12, 191, 17);
		contentPane.add(lblCreacionDeArmas);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(32, 58, 60, 17);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(114, 56, 186, 21);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setForeground(Color.WHITE);
		lblAtaque.setBounds(32, 91, 60, 17);
		contentPane.add(lblAtaque);
		
		textFieldAtaque = new JTextField();
		textFieldAtaque.setBounds(114, 89, 60, 21);
		contentPane.add(textFieldAtaque);
		textFieldAtaque.setColumns(10);
		
		JLabel lblPunteria = new JLabel("Punteria");
		lblPunteria.setForeground(Color.WHITE);
		lblPunteria.setBounds(32, 126, 60, 17);
		contentPane.add(lblPunteria);
		
		textFieldPunteria = new JTextField();
		textFieldPunteria.setBounds(114, 124, 60, 21);
		contentPane.add(textFieldPunteria);
		textFieldPunteria.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(32, 166, 60, 17);
		contentPane.add(lblPrecio);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(114, 164, 60, 21);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setBounds(239, 91, 60, 17);
		contentPane.add(lblImagen);
		
		JLabel labelImagen = new JLabel("");
		labelImagen.setBounds(305, 140, 36, 32);
		contentPane.add(labelImagen);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setForeground(Color.WHITE);
		btnSeleccionar.setBackground(Color.DARK_GRAY);
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & PNG", "jpg", "png");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			     nombreDeImagen= chooser.getSelectedFile().getName();
			     	labelImagen.setIcon(new ImageIcon(nombreDeImagen));
			    }
			}
		});
		btnSeleccionar.setBounds(305, 86, 105, 27);
		contentPane.add(btnSeleccionar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setIcon(new ImageIcon("Iconos/aceptar.png"));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Arma(textFieldNombre.getText(),Integer.parseInt(textFieldAtaque.getText()),
							Integer.parseInt(textFieldPunteria.getText()), Integer.parseInt(textFieldPrecio.getText()));
					JOptionPane.showMessageDialog(null, "Arma agregada exitosamente");
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Error al ingresar el los datos numericos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(72, 211, 165, 50);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setIcon(new ImageIcon("Iconos/cancelar.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(252, 211, 144, 50);
		contentPane.add(btnCancelar);
		setVisible(true);
	}
}
