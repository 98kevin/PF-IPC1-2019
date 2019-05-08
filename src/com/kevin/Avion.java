package com.kevin;

import javax.swing.ImageIcon;

public final class Avion extends Vehiculo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 13000L;
	private double velocidadDeDisparo;
	
	public double getVelocidadDeDisparo() {
		return velocidadDeDisparo;
	}

	public void setVelocidadDeDisparo(double velocidadDeDisparo) {
		this.velocidadDeDisparo = velocidadDeDisparo;
	}

	public Avion(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.ataque = 7;
		this.defensa = 3;
		this.punteria = 70;
		velocidadDeDisparo=1;
	}

	protected ImageIcon getDefaultIcon() {
		return new ImageIcon("Iconos/avion32.png");
	}
}
