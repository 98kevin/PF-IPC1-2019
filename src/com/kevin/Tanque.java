package com.kevin;

import javax.swing.ImageIcon;

public final class Tanque extends Vehiculo{
	
	public Tanque(String nombre) {
		super(nombre);
		this.ataque = 10;
		this.defensa = 6;
		this.punteria = 60;
		// TODO Auto-generated constructor stub
	}

	protected ImageIcon getDefaultIcon() {
		return new ImageIcon("Iconos/tanque32.png");
	}
}
