package com.kevin;

import java.awt.Color;
import java.util.Random;

public class Montania extends Casilla{

	private static Color colorCafe= new Color(82,35,2);
	
	private int vida;
	
	public Montania() {
		super(MONTANIA);
		this.vida=calcularVidaAleatoria();
	}

	private int calcularVidaAleatoria() {
		return new Random().nextInt(20)+30; //rango entre 30 y 49
	}

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Color getColor() {
		return colorCafe;
	}

}
