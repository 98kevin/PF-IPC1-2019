package com.kevin;

import java.util.Random;

public class Arma {

	private static final int MUNICIONES_INICIALES = 10;
	private static final int NUMERO_ARMAS_BASICAS=3;
	private static final int PRECIO_AMETRALLADORA = 5;
	private static final int PRECIO_GRANADA = 8;
	private static final int PRECIO_BOMBA_NUCLEAR = 12;
	private  Arma armasBasicas[];
	
	private String nombre;
	private int ataque;
	private int punteria;
	private int precio;
	private int municiones;
	
/**
 * Crea una nueva arma vacia. 
 */
	public Arma() {}
	
	public Arma(String nombre, int ataque, int punteria, int precio) {
		super();
		this.nombre = nombre;
		this.ataque = ataque;
		this.punteria = punteria;
		this.municiones=MUNICIONES_INICIALES;
		this.precio=precio;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ataque
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * @param ataque the ataque to set
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * @return the punteria
	 */
	public int getPunteria() {
		return punteria;
	}

	/**
	 * @param punteria the punteria to set
	 */
	public void setPunteria(int punteria) {
		this.punteria = punteria;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the municiones
	 */
	public int getMuniciones() {
		return municiones;
	}

	/**
	 * @param municiones the municiones to set
	 */
	public void setMuniciones(int municiones) {
		this.municiones = municiones;
	}

	
	/**
	 * Metodo que retorna un arma basica en base a un arreglo estatico, el cual pertenece a la clase. 
	 * @return Un arma basica
	 */
	public  Arma getArmaBasica() {
		armasBasicas= new Arma[3];
		armasBasicas[0]= new Arma("Ametralladora", 20,80,PRECIO_AMETRALLADORA);
		armasBasicas[1]= new Arma("Granada", 30,60,PRECIO_GRANADA);
		armasBasicas[2]=	new  Arma("Bomba Nucelar", 40,90,PRECIO_BOMBA_NUCLEAR);	
		Random aleatorio = new Random();
		return armasBasicas[aleatorio.nextInt(NUMERO_ARMAS_BASICAS)];
	}
	
}
