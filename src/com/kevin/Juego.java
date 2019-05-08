package com.kevin;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Juego implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000L;
	static final int JUGADOR_JUGADOR=0;
	static final int JUGADOR_PC=1;
	
	static final int ES_4X4=0;
	static final int ES_6X4=1;
	static final int ES_8X9=2;
	
	static final int AVION = 0;
	static final int TANQUE = 1;
	
	private int tipoJuego;
	private Jugador jugadores[];
	private Jugador gamer1;
	private Jugador gamer2;
	private int tipoEsenario;
	
	public Juego() {}
	
	public Juego (Jugador [] jugador) {
		this.jugadores=jugador;
	}
	/**
	 * Crea un nuevo Juego con los datos ingresados en el formulario. 
	 * @param comboBoxTipoJuego
	 * @param tipoDeEsenario
	 * @param jugador1
	 * @param jugador2
	 * @param comboBoxVehiculo
	 * @param textFieldsNombreVehiculo
	 */
	public Juego(JComboBox comboBoxTipoJuego, JComboBox tipoDeEsenario, JTextField jugador1, 
			JTextField jugador2, JComboBox[] comboBoxVehiculo, JTextField[] textFieldsNombreVehiculo) {
		// TODO Auto-generated constructor stub
		ArrayList<Vehiculo> vehiculosJugador1 = new ArrayList<Vehiculo>();
		ArrayList<Vehiculo> vehiculosJugador2 = new ArrayList<Vehiculo>();
		this.tipoJuego=comboBoxTipoJuego.getSelectedIndex();
		this.tipoEsenario=tipoDeEsenario.getSelectedIndex();
		if(tipoJuego==JUGADOR_JUGADOR) {
			jugadores= new Jugador[2];
			for(int i=0;i<3;i++) {
				if(comboBoxVehiculo[i].getSelectedIndex()==0) //avion
					vehiculosJugador1.add(new Avion(textFieldsNombreVehiculo[i].getText()));
				if(comboBoxVehiculo[i].getSelectedIndex()==1) //tanque
					vehiculosJugador1.add(new Tanque(textFieldsNombreVehiculo[i].getText()));
			}
			for(int i=3;i<6;i++) {
				if(comboBoxVehiculo[i].getSelectedIndex()==0) //avion
					vehiculosJugador2.add(new Avion(textFieldsNombreVehiculo[i].getText()));
				if(comboBoxVehiculo[i].getSelectedIndex()==1) //tanque
					vehiculosJugador2.add(new Tanque(textFieldsNombreVehiculo[i].getText()));
			}
			gamer1= new Jugador(jugador1.getText(),vehiculosJugador1);
			 gamer2= new Jugador(jugador2.getText(),vehiculosJugador2);
			jugadores[0]=gamer1;
			jugadores[1]=gamer2;
			
		}
		if(tipoJuego==JUGADOR_PC) {
			jugadores= new Jugador[1];
			for(int i=0;i<3;i++) {
				if(comboBoxVehiculo[i].getSelectedIndex()==0) //avion
					vehiculosJugador1.add(new Avion(textFieldsNombreVehiculo[i].getText()));
				if(comboBoxVehiculo[i].getSelectedIndex()==1) //tanque
					vehiculosJugador1.add(new Tanque(textFieldsNombreVehiculo[i].getText()));
			}
			gamer1= new Jugador(jugador1.getText(),vehiculosJugador1);
			jugadores[0]= gamer1;
		}
		JOptionPane.showMessageDialog(null, "Datos Cargados exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/**
	 * @return the tipoJuego
	 */
	public int getTipoJuego() {
		return tipoJuego;
	}

	/**
	 * @param tipoJuego the tipoJuego to set
	 */
	public void setTipoJuego(int tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	/**
	 * @return the jugadores
	 */
	public Jugador[] getJugadores() {
		return jugadores;
	}

	/**
	 * @param jugadores the jugadores to set
	 */
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	/**
	 * @return the gamer1
	 */
	public Jugador getGamer1() {
		return gamer1;
	}

	/**
	 * @param gamer1 the gamer1 to set
	 */
	public void setGamer1(Jugador gamer1) {
		this.gamer1 = gamer1;
	}

	/**
	 * @return the gamer2
	 */
	public Jugador getGamer2() {
		return gamer2;
	}

	/**
	 * @param gamer2 the gamer2 to set
	 */
	public void setGamer2(Jugador gamer2) {
		this.gamer2 = gamer2;
	}

	/**
	 * @return the tipoEsenario
	 */
	public int getTipoEsenario() {
		return tipoEsenario;
	}

	/**
	 * @param tipoEsenario the tipoEsenario to set
	 */
	public void setTipoEsenario(int tipoEsenario) {
		this.tipoEsenario = tipoEsenario;
	}

	public void agregarTiposDeJuego(JComboBox<String> comboBox) {
		comboBox.addItem("Jugador vs Jugador ");
		comboBox.addItem("Jugador vs Computadora");
	}
	public void agregarTiposDeEsenario(JComboBox<String> comboBox) {
		comboBox.addItem("4 x 4");
		comboBox.addItem("6 x 4");
		comboBox.addItem("8 x 9");
	}
}

