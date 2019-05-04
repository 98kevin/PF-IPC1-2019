package com.kevin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Esenario extends JFrame {

	protected static final int CARAS_DADO_COMODIN = 4;
	protected static final int CARAS_DADO_ATAQUE = 100;
	protected static final int CARAS_DADO_MOVIMIENTO = 6;
	private JPanel contentPane;
	private Random random;
	private int resultadoDado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Esenario frame = new Esenario();
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
	public Esenario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1175, 448);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnJuego.add(mntmGuardar);
		
		JMenuItem mntmCargar = new JMenuItem("Cargar");
		mnJuego.add(mntmCargar);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnJuego.add(mntmAyuda);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnJuego.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(12, 12, 630, 386);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(648, 0, 525, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(114, 88, 399, 143);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("<Jugador1>");
		label_1.setBounds(12, 12, 118, 17);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(114, 243, 399, 143);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("<Jugador2>");
		label_2.setBounds(12, 12, 88, 17);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(114, 12, 399, 60);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblArmas = new JLabel("Armas");
		lblArmas.setBounds(12, 0, 60, 17);
		panel_4.add(lblArmas);
		
		JLabel label_3 = new JLabel("<VehiculoUsando>");
		label_3.setBounds(84, 0, 136, 17);
		panel_4.add(label_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(12, 23, 42, 33);
		panel_4.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(66, 23, 42, 33);
		panel_4.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(120, 23, 42, 33);
		panel_4.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(174, 23, 42, 33);
		panel_4.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(228, 23, 42, 33);
		panel_4.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(282, 23, 42, 33);
		panel_4.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(336, 23, 42, 33);
		panel_4.add(button_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.setBounds(9, 12, 93, 374);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel resultado = new JLabel("54");
		resultado.setToolTipText("Resultado del Dado");
		resultado.setFont(new Font("Dialog", Font.BOLD, 24));
		resultado.setBounds(22, 283, 44, 49);
		panel_5.add(resultado);
		
		JLabel lblDados = new JLabel("Dados");
		lblDados.setBounds(12, 12, 60, 17);
		panel_5.add(lblDados);
		
		JButton dadoDeMovimiento = new JButton("");
		dadoDeMovimiento.setToolTipText("Dado de movimiento");
		dadoDeMovimiento.setIcon(new ImageIcon("dadoDeMovimiento.png"));
		dadoDeMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				random = new Random();
				resultadoDado=random.nextInt(CARAS_DADO_MOVIMIENTO)+1;
				resultado.setText(String.valueOf(resultadoDado));
			}
		});
		dadoDeMovimiento.setBounds(12, 41, 69, 59);
		panel_5.add(dadoDeMovimiento);
		
		JButton dadoDeAtaque = new JButton();
		dadoDeAtaque.setIcon(new ImageIcon("dadoDeAtaque.png"));
		dadoDeAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				random = new Random();
				resultadoDado=random.nextInt(CARAS_DADO_ATAQUE)+1;
				resultado.setText(String.valueOf(resultadoDado));
			}
		});
		dadoDeAtaque.setToolTipText("Dado de Ataque");
		dadoDeAtaque.setBounds(12, 115, 69, 59);
		panel_5.add(dadoDeAtaque);
		
		JButton dadoDeComodin = new JButton("");
		dadoDeComodin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				random = new Random();
				resultadoDado=random.nextInt(CARAS_DADO_COMODIN)+1;
				resultado.setText(String.valueOf(resultadoDado));
			}
		});
		dadoDeComodin.setIcon(new ImageIcon("dadoDeComodin.png"));
		dadoDeComodin.setToolTipText("Dado de Comodin");
		dadoDeComodin.setBounds(12, 183, 69, 59);
		panel_5.add(dadoDeComodin);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(12, 254, 60, 17);
		panel_5.add(lblResultado);
		
	}
}
