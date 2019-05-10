package com.kevin;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class Agua extends Casilla{
	
	private int vida;
	private static Color colorCeleste=new Color(0,129,150);
	
	public Agua(int i, int j) {
		super(AGUA,i,j);
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
	public void setVida(int vida, Casilla casilla ) {
		this.vida = vida;
		if(this.vida<= 0) {
			JOptionPane.showMessageDialog(null, "La casilla ha sido destruida ");
			convertirEnTerreno(casilla);
		}
	}
	
	public Color getColor() {
		return colorCeleste;
	}
	private void convertirEnTerreno(Casilla casilla) {
		casilla = new Terreno(casilla.getFila(), casilla.getCol());
	}
}
