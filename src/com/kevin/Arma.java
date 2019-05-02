package com.kevin;

import java.util.Random;

public class Arma {

	private Arma armasBasicas[];
	private final int NUMERO_ARMAS_BASICAS=3;

	/**
	 * Metodo que retorna un arma basica en base a un arreglo estatico, el cual pertenece a la clase. 
	 * @return Un arma basica
	 */
	public  Arma getArmaBasica() {
		Random aleatorio = new Random();
		return armasBasicas[aleatorio.nextInt(NUMERO_ARMAS_BASICAS)];
	}
	
}
