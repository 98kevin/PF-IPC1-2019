package com.kevin;

import javax.swing.ImageIcon;

public final class Tanque extends Vehiculo{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	public Tanque(String nombre) {
		super(nombre);
		this.ataque = 10;
		this.defensa = 4;
		// TODO Auto-generated constructor stub
	}

	protected ImageIcon getDefaultIcon() {
		return new ImageIcon("Iconos/tanque32.png");
	}
}
