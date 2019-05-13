package com.kevin;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class Agua extends Casilla{
	
	private static Color colorCeleste=new Color(0,129,150);
	
	public Agua(int i, int j) {
		super(AGUA,i,j);
		this.vida=calcularVidaAleatoria();
	}
	
	public Color getColor() {
		return colorCeleste;
	}
	
}
