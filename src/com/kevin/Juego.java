package com.kevin;

public class Juego {

	static final int JUGADOR_JUGADOR=0;
	static final int JUGADOR_PC=1;

	private int tipoJuego;
	
	Jugador jugadores[];
	
	/**
	 * @return the tipoJuego
	 */
	public int getTipoJuego() {
		return tipoJuego;
	}

	/**
	 * @param tipoJuego the tipoJuego to set
	 */
	public void setTipoJuego(int tipoJuego) {
		this.tipoJuego = tipoJuego;
	}


	public Juego() {
		new Formulario();
	}
	
	public Juego(int tipoJuego) {
		new IngresoDeDatos(tipoJuego);			
	}
	public Juego (Jugador [] jugador) {
		this.jugadores=jugador;
	}
	
}

