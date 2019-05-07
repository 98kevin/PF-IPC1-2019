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
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class Esenario extends JFrame {

	private static final int CARAS_DADO_COMODIN = 4;
	private static final int CARAS_DADO_ATAQUE = 100;
	private static final int CARAS_DADO_MOVIMIENTO = 6;
	
	private JPanel contentPane;
	private Random random;
	private int resultadoDado;
	
	/**
	 * Create the frame.
	 */
	public Esenario(Juego juego) {
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
		panel_2.setBounds(114, 178, 399, 98);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel etqJugador1 = new JLabel();
		etqJugador1.setText(juego.getGamer1().getNombre());
		etqJugador1.setBounds(12, 12, 118, 17);
		panel_2.add(etqJugador1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(114, 288, 399, 98);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel etqJugador2 = new JLabel();
		etqJugador2.setText(juego.getGamer2().getNombre());
		etqJugador2.setBounds(12, 12, 88, 17);
		panel_3.add(etqJugador2);
		
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
		
		JLabel lblArmas = new JLabel("Armas");
		lblArmas.setBounds(114, 18, 49, 41);
		panel_1.add(lblArmas);
		
		JLabel label_3 = new JLabel("<VehiculoUsando>");
		label_3.setBounds(175, 18, 318, 41);
		panel_1.add(label_3);
		
		JPanel panelDeArmas = new JPanel();
		panelDeArmas.setBounds(114, 54, 399, 112);
		panel_1.add(panelDeArmas);
		panelDeArmas.setLayout(new GridLayout(3, 6, 0, 0));
		
		
		
	}
}
