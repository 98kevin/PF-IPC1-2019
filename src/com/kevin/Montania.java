package com.kevin;

import java.awt.Color;

public class Montania extends Casilla{

	private static Color colorCafe= new Color(115,51,30);
	private static Color colorVerdeFuerte = new Color(11,111,11);
	
	public Montania(int i, int j) {
		super(MONTANIA,i,j);
		this.vida=calcularVidaAleatoria();
	}
	
	public Color getColor() {
		return colorCafe;
	}
}
