package com.kevin;

import java.awt.Color;

public class Terreno extends Casilla{

	static Color colorVerde = new Color(135,164,9);
	
	public Terreno(int i, int j) {
		super(TERRENO,i,j);
	}

	public Color getColor() {
		return colorVerde;
	}
	
	
}
