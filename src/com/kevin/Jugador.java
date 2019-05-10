package com.kevin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Jugador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5000L;
	private static int contadorDeJugadores=0;
	private static final String CONTADOR_DE_JUGADORES="ContadorDeJugadores.ctr";
	private static final String EXTENSION = ".gmr";
	
	private String nombre ;
	private int cantidadDeOro;
	private  ArrayList<Vehiculo> vehiculos;
	private int puntosDeVida;
	private int puntosDePoder;
	private Batalla batallas[];
	private int contadorDeBatallas;
	private Vehiculo vehiculoUsando;
	private Reparador [] reparadoresPontenciales;
	
	public Jugador() {}
	
	/**
	 * @param nombre
	 * @param cantidadDeOro
	 * @param vehiculos
	 */
	public Jugador(String nombre,ArrayList<Vehiculo> vehiculos) {
		super();
		this.nombre = nombre;
		this.cantidadDeOro = 10;
		this.vehiculos = null;
		this.puntosDeVida=50;
		this.puntosDePoder=3;
		this.batallas=null;
		this.contadorDeBatallas=0;
		this.vehiculos=vehiculos;
		this.vehiculoUsando=vehiculos.get(0); //el primer vehiculo es el que esta usando. 
		this.reparadoresPontenciales=null;
		Archivos.escribirObjeto(this, getDireccion());
	}

	public Jugador(String nombreJugador,String nombreVehiculo1, int vehiculo1,String nombreVehiculo2, int vehiculo2, String nombreVehiculo3,int vehiculo3) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		if(vehiculo1==Juego.AVION)
		vehiculos.add(new Avion(nombreVehiculo1));
		if(vehiculo1==Juego.TANQUE)
			vehiculos.add(new Tanque(nombreVehiculo1));
		if(vehiculo2==Juego.AVION)
			vehiculos.add(new Avion(nombreVehiculo2));
		if(vehiculo2==Juego.TANQUE)
			vehiculos.add(new Tanque(nombreVehiculo2));
		if(vehiculo3==Juego.AVION)
			vehiculos.add(new Avion(nombreVehiculo3));
		if(vehiculo3==Juego.TANQUE)
			vehiculos.add(new Tanque(nombreVehiculo3));
		new Jugador(nombreJugador,vehiculos);
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the cantidadDeOro
	 */
	public int getCantidadDeOro() {
		return cantidadDeOro;
	}
	/**
	 * @param cantidadDeOro the cantidadDeOro to set
	 */
	public void setCantidadDeOro(int cantidadDeOro) {
		this.cantidadDeOro = cantidadDeOro;
	}
	/**
	 * @return the vehiculos
	 */
	public ArrayList getVehiculos() {
		return vehiculos;
	}
	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(ArrayList vehiculos) {
		this.vehiculos = vehiculos;
	}
	/**
	 * @return the puntosDeVida
	 */
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
	/**
	 * @param puntosDeVida the puntosDeVida to set
	 */
	public void setPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}
	/**
	 * @return the puntosDePoder
	 */
	public int getPuntosDePoder() {
		return puntosDePoder;
	}
	/**
	 * @param puntosDePoder the puntosDePoder to set
	 */
	public void setPuntosDePoder(int puntosDePoder) {
		this.puntosDePoder = puntosDePoder;
	}
	/**
	 * @return the batallas
	 */
	public Batalla[] getBatallas() {
		return batallas;
	}
	/**
	 * @param batallas the batallas to set
	 */
	public void setBatallas(Batalla[] batallas) {
		this.batallas = batallas;
	}
	/**
	 * @return the contadorDeBatallas
	 */
	public int getContadorDeBatallas() {
		return contadorDeBatallas;
	}
	/**
	 * @param contadorDeBatallas the contadorDeBatallas to set
	 */
	public void setContadorDeBatallas(int contadorDeBatallas) {
		this.contadorDeBatallas = contadorDeBatallas;
	}
	/**
	 * @return the vehiculoUsando
	 */
	public Vehiculo getVehiculoUsando() {
		return vehiculoUsando;
	}
	/**
	 * @param vehiculoUsando the vehiculoUsando to set
	 */
	public void setVehiculoUsando(Vehiculo vehiculoUsando) {
		this.vehiculoUsando = vehiculoUsando;
	}
	/**
	 * @return the reparadoresPontenciales
	 */
	public Reparador[] getReparadoresPontenciales() {
		return reparadoresPontenciales;
	}
	/**
	 * @param reparadoresPontenciales the reparadoresPontenciales to set
	 */
	public void setReparadoresPontenciales(Reparador[] reparadoresPontenciales) {
		this.reparadoresPontenciales = reparadoresPontenciales;
	}
	
	private String getDireccion() {
		contadorDeJugadores=(Integer) Archivos.leerObjeto(CONTADOR_DE_JUGADORES);
		contadorDeJugadores++;
		Archivos.escribirObjeto(new Integer(contadorDeJugadores),CONTADOR_DE_JUGADORES);
		return "Jugador"+contadorDeJugadores+EXTENSION;
	}
	
	public String getDireccion(String numero) {
		return "Jugador"+numero+EXTENSION;
	}

	public void agregarItemsDeJugadores(JComboBox comboBoxJugador1) {
		try {
			int cantidadDeJugadores= (Integer) Archivos.leerObjeto(CONTADOR_DE_JUGADORES);
			for (int i = 1; i <=cantidadDeJugadores; i++) {
				Jugador tmp =(Jugador) Archivos.leerObjeto(getDireccion(String.valueOf(i)));
				comboBoxJugador1.addItem(tmp.getNombre());
			}		
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,e.getMessage() , "Jugador.NullPointerException", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean estaVivo(Jugador jugador) {
		boolean estaVivo=false;
		Iterator<Vehiculo> it = jugador.getVehiculos().iterator();
		while (it.hasNext()) {
			if(it.next().isEstado())
				estaVivo=true;
		}
		return estaVivo;
	}
}
