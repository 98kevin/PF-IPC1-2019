package com.kevin;

import java.awt.Color;

import javax.swing.JButton;

public class Casilla extends JButton{
	
	/**
	 * Serializacion de la clase casilla
	 */
	private static final long serialVersionUID = 16000L;
	
	protected static final int TERRENO=0;
	protected static final int AGUA=1;
	protected static final int MONTANIA=2;
	
	protected Vehiculo vehiculo;
	protected int tipo;
	protected Color color;
	protected boolean tieneVehiculo;
	protected int fila;
	protected int col;
/**
 * 
 * @param tipo
 */
	public Casilla(int tipo,int fila, int col) {
		super();
		this.vehiculo = null;  //cuando se crea una casilla no tiene originalmente un vehiculo
		this.tipo = tipo;
		this.color=getColor();
		this.tieneVehiculo=false;
		this.fila=fila;
		this.col= col;
	}
	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	/**
	 * @param object the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		this.tieneVehiculo=true;
	}
	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the fila
	 */
	public int getFila() {
		return fila;
	}
	/**
	 * @param fila the fila to set
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}
	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
}