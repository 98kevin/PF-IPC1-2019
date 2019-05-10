package com.kevin;

import java.util.Random;

public class Dado {
	
	private static final int CARAS_DADO_COMODIN = 4;
	private static final int CARAS_DADO_ATAQUE = 100;
	private static final int CARAS_DADO_MOVIMIENTO = 6;
	
	private static final int DADO_DE_MOVIMIENTO = 0;
	private static final int DADO_DE_ATAQUE = 1;
	private static final int DADO_DE_COMODIN = 2;
	
	public static int getValorDelDado(int tipoDeDado) {
		Random r= new Random();
		switch(tipoDeDado) {
		case DADO_DE_MOVIMIENTO:
			return r.nextInt(CARAS_DADO_MOVIMIENTO)+1;
		case DADO_DE_ATAQUE:
			return r.nextInt(CARAS_DADO_ATAQUE)+1;
		case DADO_DE_COMODIN:
			return r.nextInt(CARAS_DADO_COMODIN)+1;
		default: 
			return 0;
		}
	}
}
