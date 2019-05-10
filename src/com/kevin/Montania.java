package com.kevin;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class Montania extends Casilla{

	private static Color colorCafe= new Color(115,51,30);
	private static Color colorBlanco = new Color(11,111,11);
	
	private int vida;
	
	public Montania(int i, int j) {
		super(MONTANIA,i,j);
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
	public void setVida(int vida,Casilla casilla) {
		this.vida = vida;
		if(this.vida<= 0) {
			JOptionPane.showMessageDialog(null, "La casilla ha sido destruida ");
			convertirEnTerreno(casilla);
		}
	}
	
	public Color getColor() {
		return colorCafe;
	}

	private void convertirEnTerreno(Casilla casilla) {
		casilla = new Terreno(casilla.getFila(), casilla.getCol());
	}
	
}
