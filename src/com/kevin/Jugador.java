package com.kevin;

public class Jugador {
	private String nombre ;
	private int cantidadDeOro;
	private Vehiculo vehiculos;
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
	public Vehiculo getVehiculos() {
		return vehiculos;
	}
	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(Vehiculo vehiculos) {
		this.vehiculos = vehiculos;
	}
	/**
	 * @param nombre
	 * @param cantidadDeOro
	 * @param vehiculos
	 */
	public Jugador(String nombre, int cantidadDeOro, Vehiculo vehiculos) {
		super();
		this.nombre = nombre;
		this.cantidadDeOro = cantidadDeOro;
		this.vehiculos = vehiculos;
		
	}
	
	
	
}
