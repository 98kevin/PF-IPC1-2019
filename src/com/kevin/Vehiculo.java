package com.kevin;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2000L;
	protected int ataque;
	protected int defensa;
	protected double punteria;
	protected String nombre;
	protected ImageIcon imagen;
	protected boolean estado;  //True significa estar activo: false, destruido. 
	protected int cantidadEnemigosDestruidos;
	protected int numeroVecesDestruido;
	protected int nivel;
	protected int puntosDeVida;
	protected int puntosDePoder;
	protected int experiencia;
	protected int fila;
	protected int columna;
	protected ArrayList<Arma> armas;

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
	 * @return the defensa
	 */
	public int getDefensa() {
		return defensa;
	}
	/**
	 * @param defensa the defensa to set
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	/**
	 * @return the punteria
	 */
	public double getPunteria() {
		return punteria;
	}
	/**
	 * @param punteria the punteria to set
	 */
	public void setPunteria(double punteria) {
		this.punteria = punteria;
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
	 * @return the imagen
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	/**
	 * Retorna si esta vivo o no. 
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/**
	 * @return the cantidadEnemigosDestruidos
	 */
	public int getCantidadEnemigosDestruidos() {
		return cantidadEnemigosDestruidos;
	}
	/**
	 * @param cantidadEnemigosDestruidos the cantidadEnemigosDestruidos to set
	 */
	public void setCantidadEnemigosDestruidos(int cantidadEnemigosDestruidos) {
		this.cantidadEnemigosDestruidos = cantidadEnemigosDestruidos;
	}
	/**
	 * @return the numeroVecesDestruido
	 */
	public int getNumeroVecesDestruido() {
		return numeroVecesDestruido;
	}
	/**
	 * @param numeroVecesDestruido the numeroVecesDestruido to set
	 */
	public void setNumeroVecesDestruido(int numeroVecesDestruido) {
		this.numeroVecesDestruido = numeroVecesDestruido;
	}
	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the puntosDeVida
	 */
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
	/**
	 * @param puntosDeVida the puntosDeVida to set
	 */
	public void setPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}
	/**
	 * @return the puntosDePoder
	 */
	public int getPuntosDePoder() {
		return puntosDePoder;
	}
	/**
	 * @param puntosDePoder the puntosDePoder to set
	 */
	public void setPuntosDePoder(int puntosDePoder) {
		this.puntosDePoder = puntosDePoder;
	}
	/**
	 * @return the experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}
	/**
	 * @param experiencia the experiencia to set
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	/**
	 * @return the fila
	 */
	public int getFila() {
		return fila;
	}
	/**
	 * @param fila the fila to set
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}
	/**
	 * @return the columna
	 */
	public int getColumna() {
		return columna;
	}
	/**
	 * @param columna the columna to set
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}	
	

	public Vehiculo(String nombre) {
		super();
		armas= new ArrayList<Arma>();
		armas.add(new Arma().getArmaBasica());
		this.imagen = getDefaultIcon();
		this.estado = true; 
		this.cantidadEnemigosDestruidos = 0;
		this.numeroVecesDestruido = 0;
		this.puntosDeVida=100;
		this.puntosDePoder=3+2*nivel;
		this.experiencia=0;
	}
	
	protected ImageIcon getDefaultIcon() {
		return null;
	}
	/**
	 * @return the armas
	 */
	public ArrayList<Arma> getArmas() {
		return armas;
	}
	/**
	 * @param armas the armas to set
	 */
	public void setArmas(ArrayList<Arma> armas) {
		this.armas = armas;
	}
	
	public void atacar(Vehiculo vehiculoSeleccionado,  Casilla casillaDelJuagador, Casilla casillaEnemiga, 
			Jugador enemigo,Esenario esenario, int indiceDeArma, int valorDelDado) {
		try {
			int ataque = vehiculoSeleccionado.getAtaque();
			int defensaDelEnemigo= casillaEnemiga.getVehiculo().getDefensa();
			int casillasDesplazado=Math.abs(casillaDelJuagador.getFila() - casillaEnemiga.getFila()) 
					+Math.abs(casillaDelJuagador.getCol()-casillaEnemiga.getCol() -2);
			int porcentajeRestanteAdicional=Math.abs(valorDelDado-4*casillasDesplazado);
			int ataqueResultante = (int) ((ataque*porcentajeRestanteAdicional)/(100));
			if(defensaDelEnemigo<ataqueResultante) {
				casillaEnemiga.getVehiculo().setPuntosDeVida(getPuntosDeVida()-ataqueResultante);
				JOptionPane.showMessageDialog(null, "El objetivo fue golpeado con un ataque de: " + String.valueOf(ataqueResultante));
			}else {
				JOptionPane.showMessageDialog(null, "No se concreto el ataque al objetivo porque su defensa era mayor");
			}
		if(casillaEnemiga instanceof Agua)
			((Agua) casillaEnemiga).setVida(getPuntosDeVida()-ataqueResultante, casillaEnemiga);
		if(casillaEnemiga instanceof Montania) 
			((Montania) casillaEnemiga).setVida(getPuntosDeVida()-ataqueResultante,casillaEnemiga);
		//evaluamos su vida y pasamos al siguiente turno 
		if(new Jugador().estaVivo(enemigo)) {
			esenario.setTurnoActivo(enemigo);
			JOptionPane.showMessageDialog(null, "Siguiente turno");
		}
		if(! new Jugador().estaVivo(enemigo)) {//si el enemigo no esta vivo ejecutamos este codigo
			  
		}
		
		} catch (NullPointerException e) {
			//no hacemos nada en caso de que no exista vehiculo en la casilla
		} 
	}
}