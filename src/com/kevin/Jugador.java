package com.kevin;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre ;
	private int cantidadDeOro;
	private  ArrayList<Vehiculo> vehiculos;
	private int puntosDeVida;
	private int puntosDePoder;
	private Batalla batallas[];
	private int contadorDeBatallas;
	private Vehiculo vehiculoUsando;
	private Reparador [] reparadoresPontenciales;
	
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
	}
	
}
