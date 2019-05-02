package com.kevin;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class Avion extends Vehiculo{

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

	protected Icon getDefaultIcon() {
		return new ImageIcon("avion-de-guerra64.png");
	}
}
