package com.kevin;

import java.awt.Color;
import java.util.Random;

public class Agua extends Casilla{
	
	private int vida;
	
	
	public Agua() {
		super(AGUA);
		this.vida=calcularVidaAleatoria();
	}
	
	private int calcularVidaAleatoria() {
		return new Random().nextInt(20)+40; //rango entre 40 y 59
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
		return Color.blue;
	}

}
