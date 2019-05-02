package com.kevin;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class Tanque extends Vehiculo{
	
	public Tanque(String nombre) {
		super(nombre);
		this.ataque = 10;
		this.defensa = 6;
		this.punteria = 60;
		// TODO Auto-generated constructor stub
	}

	protected Icon getDefaultIcon() {
		return new ImageIcon("tanque64.png");
	}
}
