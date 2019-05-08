package com.kevin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Esenario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11000L;
	private static final int CARAS_DADO_COMODIN = 4;
	private static final int CARAS_DADO_ATAQUE = 100;
	private static final int CARAS_DADO_MOVIMIENTO = 6;
	
	private JPanel contentPane;
	private JPanel panelDeJuego;
	private Random random;
	private int resultadoDado;
	private Jugador jugador1;
	private Jugador jugador2;
	private int tipoDeJuego;
	private int tipoDeEsenario;
	private String direccion;
	private Casilla [][] matriz;
	
	
	/**
	 * Create the frame.
	 */
	public Esenario(JComboBox<String> tipoDeJuego, JComboBox<String > comboBoxJugador1, 
			JComboBox<String> comboBoxJugador2, JComboBox<String > tipoDeEsenario) {
		Jugador jugador = new Jugador();
		
		direccion=jugador.getDireccion(String.valueOf(comboBoxJugador1.getSelectedIndex()+1)); //se suma una unidad porque la indexacion del comboBox comienza en 0
		this.jugador1=(Jugador) Archivos.leerObjeto(direccion);
		
		direccion=jugador.getDireccion(String.valueOf(comboBoxJugador2.getSelectedIndex()+1)); //se suma una unidad porque la indexacion del comboBox comienza en 0
		this.jugador2=(Jugador) Archivos.leerObjeto(direccion);
		
		this.tipoDeJuego=tipoDeJuego.getSelectedIndex();
		this.tipoDeEsenario= tipoDeEsenario.getSelectedIndex();
		
		llenarSeccionesDelEsenario(this.tipoDeEsenario);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1175, 706);
		
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
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDeJuego.setBackground(Color.LIGHT_GRAY);
		panelDeJuego.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDeJuego.setBounds(12, 12, 630, 632);
		contentPane.add(panelDeJuego);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(648, 0, 525, 644);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(114, 178, 399, 160);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel etqJugador1 = new JLabel();
		etqJugador1.setForeground(Color.WHITE);
		etqJugador1.setText(jugador1.getNombre());
		etqJugador1.setBounds(12, 12, 118, 17);
		panel_2.add(etqJugador1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(114, 350, 399, 202);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel etqJugador2 = new JLabel();
		etqJugador2.setForeground(Color.WHITE);
		etqJugador2.setText(jugador2.getNombre());
		etqJugador2.setBounds(12, 12, 88, 17);
		panel_3.add(etqJugador2);
		
		JLabel lblArmas = new JLabel("Armas");
		lblArmas.setForeground(Color.WHITE);
		lblArmas.setBounds(12, 18, 49, 41);
		panel_1.add(lblArmas);
		
		JLabel label_3 = new JLabel("<VehiculoUsando>");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(73, 18, 318, 41);
		panel_1.add(label_3);
		
		JPanel panelDeArmas = new JPanel();
		panelDeArmas.setBackground(Color.GRAY);
		panelDeArmas.setBounds(12, 54, 487, 112);
		panel_1.add(panelDeArmas);
		panelDeArmas.setLayout(new GridLayout(3, 6, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 178, 93, 374);
		panel_1.add(panel_5);
		panel_5.setBackground(Color.GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.setLayout(null);
		
		JLabel resultado = new JLabel("54");
		resultado.setForeground(Color.WHITE);
		resultado.setToolTipText("Resultado del Dado");
		resultado.setFont(new Font("Dialog", Font.BOLD, 24));
		resultado.setBounds(22, 283, 44, 49);
		panel_5.add(resultado);
		
		JLabel lblDados = new JLabel("Dados");
		lblDados.setForeground(Color.WHITE);
		lblDados.setBounds(12, 12, 60, 17);
		panel_5.add(lblDados);
		
		JButton dadoDeMovimiento = new JButton("");
		dadoDeMovimiento.setBackground(Color.DARK_GRAY);
		dadoDeMovimiento.setToolTipText("Dado de movimiento");
		dadoDeMovimiento.setIcon(new ImageIcon("Iconos/dadoDeMovimiento.png"));
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
		dadoDeAtaque.setBackground(Color.DARK_GRAY);
		dadoDeAtaque.setIcon(new ImageIcon("Iconos/dadoDeAtaque.png"));
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
		dadoDeComodin.setBackground(Color.DARK_GRAY);
		dadoDeComodin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				random = new Random();
				resultadoDado=random.nextInt(CARAS_DADO_COMODIN)+1;
				resultado.setText(String.valueOf(resultadoDado));
			}
		});
		dadoDeComodin.setIcon(new ImageIcon("Iconos/dadoDeComodin.png"));
		dadoDeComodin.setToolTipText("Dado de Comodin");
		dadoDeComodin.setBounds(12, 183, 69, 59);
		panel_5.add(dadoDeComodin);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(12, 254, 60, 17);
		panel_5.add(lblResultado);
		
		asingarVehiculosEnMatriz(this.tipoDeJuego,jugador1, jugador2, this.matriz,this.tipoDeEsenario);
		setVisible(true);
	}

	private void asingarVehiculosEnMatriz(int tipoDeJuego2, Jugador jugador12, Jugador jugador22, Casilla[][] matriz2, int tipoDeEsenario) {
		if(tipoDeJuego2==Juego.JUGADOR_JUGADOR) {
			llenarVehiculos(jugador12,matriz2,tipoDeEsenario);
			llenarVehiculos(jugador22,matriz2,tipoDeEsenario);
		}if(this.tipoDeJuego==Juego.JUGADOR_PC) {
			llenarVehiculos(jugador12,matriz2,tipoDeEsenario);
		}
		
	}

	private void llenarVehiculos(Jugador jugador, Casilla[][] matriz2,int tipoDeEsenario) {
		if(tipoDeEsenario==Juego.ES_4X4) {
			asignarVehiculos(jugador,matriz2,4,4,jugador.getVehiculos().size());
		}if(tipoDeEsenario==Juego.ES_6X4) {
			asignarVehiculos(jugador,matriz2,6,4,jugador.getVehiculos().size());
		}if(tipoDeEsenario==Juego.ES_8X9) {
			asignarVehiculos(jugador,matriz2,8,9,jugador.getVehiculos().size());
		}
	}

	private void asignarVehiculos(Jugador jugador, Casilla[][] matriz2, int i, int j,int vehiculosFaltantes) {
		if(vehiculosFaltantes>=1) {
			int x =new Random().nextInt(i);
			int y =new Random().nextInt(j);
			if(matriz2[x][y].tieneVehiculo){
				asignarVehiculos(jugador,matriz2,  i,  j, vehiculosFaltantes); //seguira llamando al metodo hasta que ya no hayan vehiculos por asignar. 
			}
			if(!matriz2[x][y].tieneVehiculo) {
				matriz2[x][y].setVehiculo((Vehiculo) jugador.getVehiculos().get(vehiculosFaltantes-1)); //se resta uno porque la indexacion comineza en 0. 
				matriz2[x][y].setIcon(matriz[x][y].getVehiculo().getDefaultIcon());
				asignarVehiculos(jugador,matriz2,  i,  j, vehiculosFaltantes-1);  
			}
		}
	}

	private void llenarSeccionesDelEsenario(int tipoDeEsenario2) {
		if(tipoDeEsenario2==Juego.ES_4X4)
			llenarMatriz(panelDeJuego,matriz,4,4);
		if(tipoDeEsenario2==Juego.ES_6X4) 
			llenarMatriz(panelDeJuego,matriz,6,4);
		if(tipoDeEsenario2==Juego.ES_8X9)
			llenarMatriz(panelDeJuego,matriz,8,9);
	}

	private void llenarMatriz(JPanel panelDeJuego2, JButton[][] matriz2, int i, int j) {
		panelDeJuego = new JPanel(new GridLayout(i, j,5, 5));
		matriz= new Casilla[i][j];
		for (int i2 = 0; i2 <i; i2++) {
			for (int j2 = 0; j2 <j; j2++) {
				matriz[i2][j2]=getSeccionAleatoria();
				matriz[i2][j2].setBackground(matriz[i2][j2].getColor());
				panelDeJuego.add(matriz[i2][j2]);
			}
		}
	}

	private Casilla getSeccionAleatoria() {
		int val = new Random().nextInt(3);
		switch (val) {
		case 0: 
			return new Terreno();
		case 1: 
			return new Agua();
		case 2: 
			return new Montania();
		default:
		return null;
		}
	}
}
