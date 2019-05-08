package com.kevin;

import java.awt.Color;

public class Terreno extends Casilla{

	public Terreno() {
		super(TERRENO);
	}

	public Color getColor() {
		return Color.green;
	}
}
