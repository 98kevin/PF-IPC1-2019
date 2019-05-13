package com.kevin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
/**
 * Es el lugar donde se desarrolla el combate. 
 * @author kevin
 *
 */
public class Esenario extends JFrame {

	/**
	 * Serializacion de la clase Esenario
	 */
	private static final long serialVersionUID = 11000L;
	
	//constantes para las acciones de juego
	private static final int MOVIMIENTO=0;
	private static final int ATAQUE=1;
	private static final int COMODIN=2;
	
	private JPanel contentPane;
	private JPanel panelDeJuego;
	private JLabel jugadorActivo;
	private JComboBox<String> comboBoxArmas;
	private JButton btnSeleccionarArma;
	private JLabel labelArmaSeleccionada;
	private JLabel etqResultadoDado;
	
	private Casilla [][] matriz;
	
	private Vehiculo vehiculoSeleccionado;
	private Casilla casillaVehiculoAtacante;
	private int indiceDelArmaSeleccionada;
	private Casilla casillaEnemigo;//este valor se utiliza en la clase interna
	private int valorDelDado;
	
	private int tipoDeJuego;
	private int tipoDeEsenario;
	private int tipoDeAccion;
	private boolean esTurnoJugador1;

	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorEnTurno;
	private Esenario esenario;
	private String direccion;
	
	/**
	 * Create the frame.
	 */
	public Esenario(JComboBox<String> tipoDeJuego, JComboBox<String > comboBoxJugador1, 
			JComboBox<String> comboBoxJugador2, JComboBox<String > tipoDeEsenario) {
		Jugador jugador = new Jugador();
		
		direccion=jugador.getDireccion(String.valueOf(comboBoxJugador1.getSelectedIndex()+1));
		//se suma una unidad porque la indexacion del comboBox comienza en 0
		this.jugador1=(Jugador) Archivos.leerObjeto(direccion);
		
		direccion=jugador.getDireccion(String.valueOf(comboBoxJugador2.getSelectedIndex()+1)); 
		//se suma una unidad porque la indexacion del comboBox comienza en 0
		this.jugador2=(Jugador) Archivos.leerObjeto(direccion);
		this.esenario=this;
		this.tipoDeJuego=tipoDeJuego.getSelectedIndex();
		this.tipoDeEsenario= tipoDeEsenario.getSelectedIndex();
		this.esTurnoJugador1=new Random().nextBoolean();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1175, 762);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(648, 0, 525, 682);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(12, 358, 511, 120);
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
		panel_3.setBounds(12, 490, 511, 120);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel etqJugador2 = new JLabel();
		etqJugador2.setForeground(Color.WHITE);
		etqJugador2.setText(jugador2.getNombre());
		etqJugador2.setBounds(12, 12, 88, 17);
		panel_3.add(etqJugador2);
		
		JLabel lblDeAcciones = new JLabel("<EtiquetaDinamica>");
		lblDeAcciones.setForeground(Color.WHITE);
		lblDeAcciones.setBounds(22, 76, 193, 41);
		panel_1.add(lblDeAcciones);
		
		JPanel panelDeArmas = new JPanel();
		panelDeArmas.setBackground(Color.GRAY);
		panelDeArmas.setBounds(12, 108, 487, 112);
		panel_1.add(panelDeArmas);
		panelDeArmas.setLayout(null);
		
		JButton btnNewButton = new JButton("Atacar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAccion(ATAQUE);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setIcon(new ImageIcon("Iconos/atacar.png"));
		btnNewButton.setBounds(12, 12, 148, 88);
		panelDeArmas.add(btnNewButton);
		
		JButton btnMovimiento = new JButton("Moverse");
		btnMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDeAccion=MOVIMIENTO;
			}
		});
		btnMovimiento.setForeground(Color.WHITE);
		btnMovimiento.setBackground(Color.DARK_GRAY);
		btnMovimiento.setIcon(new ImageIcon("Iconos/movimiento.png"));
		btnMovimiento.setBounds(165, 12, 152, 88);
		panelDeArmas.add(btnMovimiento);
		
		JButton btnComodin = new JButton("Comodin");
		btnComodin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoDeAccion=COMODIN;
			}
		});
		btnComodin.setForeground(Color.WHITE);
		btnComodin.setBackground(Color.DARK_GRAY);
		btnComodin.setIcon(new ImageIcon("Iconos/comodin.png"));
		btnComodin.setBounds(329, 12, 158, 88);
		panelDeArmas.add(btnComodin);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(12, 12, 501, 74);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblJugadorActivo = new JLabel("Jugador Activo");
		lblJugadorActivo.setForeground(Color.WHITE);
		lblJugadorActivo.setBounds(12, 12, 113, 17);
		panel.add(lblJugadorActivo);
		
		jugadorActivo = new JLabel("<JugadorDynamic>");
		jugadorActivo.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 20));
		jugadorActivo.setForeground(Color.WHITE);
		jugadorActivo.setBounds(12, 32, 239, 30);
		panel.add(jugadorActivo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador1.actualizarVehiculos(jugador1,matriz);
				jugador2.actualizarVehiculos(jugador2,matriz);
			}
		});
		btnGuardar.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 12));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setIcon(new ImageIcon("Iconos/guardar.png"));
		btnGuardar.setBounds(161, 622, 146, 47);
		panel_1.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 12));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val= JOptionPane.showConfirmDialog(null, "Desea salir realmente", "Salir", JOptionPane.INFORMATION_MESSAGE);
				if(val==JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		btnSalir.setIcon(new ImageIcon("Iconos/salir.png"));
		btnSalir.setBounds(337, 622, 146, 47);
		panel_1.add(btnSalir);
		
		JPanel panelVariable = new JPanel();
		panelVariable.setBackground(Color.GRAY);
		panelVariable.setBounds(22, 232, 491, 112);
		panel_1.add(panelVariable);
		panelVariable.setLayout(null);
		
		comboBoxArmas = new JComboBox<String>();
		comboBoxArmas.setBounds(12, 12, 159, 26);
		panelVariable.add(comboBoxArmas);
		
		btnSeleccionarArma = new JButton("Seleccionar");
		btnSeleccionarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indiceDelArmaSeleccionada=comboBoxArmas.getSelectedIndex();
				labelArmaSeleccionada.setText(vehiculoSeleccionado.getArmas().get(indiceDelArmaSeleccionada).getNombre());
			}
		});
		btnSeleccionarArma.setBackground(Color.DARK_GRAY);
		btnSeleccionarArma.setForeground(Color.WHITE);
		btnSeleccionarArma.setBounds(181, 12, 133, 27);
		panelVariable.add(btnSeleccionarArma);
		
		JLabel lblArma = new JLabel("Arma");
		lblArma.setForeground(Color.WHITE);
		lblArma.setBounds(12, 51, 60, 17);
		panelVariable.add(lblArma);
		
		labelArmaSeleccionada = new JLabel("<Dynamic>");
		labelArmaSeleccionada.setForeground(Color.WHITE);
		labelArmaSeleccionada.setBounds(81, 51, 233, 17);
		panelVariable.add(labelArmaSeleccionada);
		
		JLabel lblDado = new JLabel("Dado");
		lblDado.setForeground(Color.WHITE);
		lblDado.setBounds(359, 17, 60, 17);
		panelVariable.add(lblDado);
		
		JButton btnDado = new JButton("");
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setResultadoDado(Dado.getValorDelDado(tipoDeAccion)+50);
				vehiculoSeleccionado.atacar(vehiculoSeleccionado,casillaVehiculoAtacante,
						casillaEnemigo,getJugadorInactivo(),esenario,indiceDelArmaSeleccionada,valorDelDado);
			}
		});
		btnDado.setBackground(Color.DARK_GRAY);
		btnDado.setIcon(new ImageIcon("Iconos/dadoDeMovimiento.png"));
		btnDado.setBounds(335, 34, 105, 78);
		panelVariable.add(btnDado);
		
		JLabel lblResultado = new JLabel("Resultado ");
		lblResultado.setFont(new Font("Dialog", Font.BOLD, 15));
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBounds(12, 80, 108, 17);
		panelVariable.add(lblResultado);
		
		etqResultadoDado = new JLabel("<dynamic>");
		etqResultadoDado.setFont(new Font("Dialog", Font.BOLD, 15));
		etqResultadoDado.setForeground(Color.WHITE);
		etqResultadoDado.setBounds(132, 80, 108, 17);
		panelVariable.add(etqResultadoDado);
		
		llenarSeccionesDelEsenario(this.tipoDeEsenario);
		panelDeJuego.setBackground(Color.LIGHT_GRAY);
		panelDeJuego.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDeJuego.setBounds(12, 12, 630, 632);
		contentPane.add(panelDeJuego);
		
		asingarVehiculosEnMatriz(this.tipoDeJuego,jugador1, jugador2, this.matriz,this.tipoDeEsenario);
		jugar(jugador1, jugador2, matriz);
		
		setVisible(true);
	}
	
	private Jugador getJugadorInactivo() {
		if(jugador1 .equals(jugadorEnTurno))
		return jugador2;
		if(jugador2 .equals(jugadorEnTurno))
			return jugador1;
		else
			return null;
	}
	
	
	/**
	 * @return the matriz
	 */
	public Casilla[][] getMatriz() {
		return matriz;
	}

	public void setResultadoDado(int valor) {
		this.valorDelDado= valor;
		etqResultadoDado.setText(String.valueOf(this.valorDelDado));
	}
	
	public void setVehiculoSeleccionado(Vehiculo vehiculo) {
		try {
			this.vehiculoSeleccionado=vehiculo;
			comboBoxArmas.removeAllItems();
			Iterator it = vehiculo.getArmas().iterator();
			while (it.hasNext()) {
				Arma tmp = (Arma)	it.next();			
						comboBoxArmas.addItem(tmp.getNombre());
			}
		} catch (NullPointerException e) {
			comboBoxArmas.removeAllItems();
		}
	}
	
	public void setAccion(int accion) {
		this.tipoDeAccion=accion;
		if(this.tipoDeAccion==ATAQUE) {
			btnSeleccionarArma.setVisible(true);
			comboBoxArmas.setVisible(true);
		}else {
			btnSeleccionarArma.setVisible(false);
			comboBoxArmas.setVisible(false);
		}
	}
	
	private void jugar(Jugador jugador1, Jugador jugador2, Casilla[][] matriz) {
		if(esTurnoJugador1) {
			  setTurnoActivo(jugador1); 
		}if(!esTurnoJugador1) {
			 setTurnoActivo(jugador2); 
		}
	}

	void setTurnoActivo(Jugador jugador) {  //visibilidad default para el mismo paquete. 
		jugadorActivo.setText(jugador.getNombre());
		jugadorEnTurno=jugador;
		esTurnoJugador1 =jugador.equals(jugador1) ? true: false;	
		this.vehiculoSeleccionado=null;
		tipoDeAccion=-1;
	}

	private void asingarVehiculosEnMatriz(int tipoDeJuego2, Jugador jugador12, Jugador jugador22, 
			Casilla[][] matriz2, int tipoDeEsenario) {
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
				asignarVehiculos(jugador,matriz2,  i,  j, vehiculosFaltantes); //seguira llamando al metodo hasta que
				//ya no hayan vehiculos por asignar. 
			}
			if(!matriz2[x][y].tieneVehiculo) {
				matriz2[x][y].setVehiculo((Vehiculo) jugador.getVehiculos().get(vehiculosFaltantes-1)); 
				//se resta uno porque la indexacion comineza en 0. 
				matriz2[x][y].setToolTipText(jugador.getNombre());
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
				matriz[i2][j2]=getSeccionAleatoria(i2,j2);
				matriz[i2][j2].addActionListener(new Listener());
				matriz[i2][j2].setBackground(matriz[i2][j2].getColor());
				if(matriz[i2][j2] instanceof Agua)
					matriz[i2][j2].setText(String.valueOf(((Agua)matriz[i2][j2]).getVida()));
				if(matriz[i2][j2] instanceof Montania)
					matriz[i2][j2].setText(String.valueOf(((Montania)matriz[i2][j2]).getVida()));
				panelDeJuego.add(matriz[i2][j2]);
			}
		}
	}
	
	private Casilla getSeccionAleatoria(int i, int j) {
		int val = new Random().nextInt(3);
		switch (val) {
		case 0: 
			return new Terreno(i,j);
		case 1: 
			return new Agua(i,j);
		case 2: 
			return new Montania(i,j);
		default:
		return null;
		}
	}

	class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(hayVehiculoSeleccionado()) {
				casillaEnemigo = (Casilla ) e.getSource();
				JOptionPane.showMessageDialog(null, "Objetivo Seleccionado");
			}
			if(tipoDeAccion==ATAQUE&!hayVehiculoSeleccionado()){
				setVehiculoSeleccionado(null);
				casillaVehiculoAtacante =(Casilla) e.getSource();
				Iterator it = jugadorEnTurno.getVehiculos().iterator();
				boolean coincide=false;
				while (it.hasNext()) {
					Vehiculo v= (Vehiculo) it.next();
					if(v.equals(casillaVehiculoAtacante.getVehiculo())) {
						setVehiculoSeleccionado(v);
						coincide=true;
						JOptionPane.showMessageDialog(null, "Vehiculo Seleccionado");
					}
				}
				if (!coincide)
					JOptionPane.showMessageDialog(null, "No puede seleccionar esa casilla");
			} //sierre del tipo de ataque
		}//sierre del evento ActionPerformed

		private boolean hayVehiculoSeleccionado() {
			return (vehiculoSeleccionado!=null )  ?  true : false;
		}
	}
}
