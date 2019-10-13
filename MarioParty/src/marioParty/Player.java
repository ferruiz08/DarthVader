package marioParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	private int id;
	private int points;
	private Casillero casillero; //Ubicacion actual en el tablero
	private Casillero casilleroAnterior; //Ubicacion anterior en el tablero para que no me deje regresar
	private Ubicacion ubicacion;
	private int ubicacionOffsetX;
	private int ubicacionOffsetY;
	private int movimiento = 150;
	private boolean extraTurn; //Si agarro una estrella tengo que setear este bit e informar al gameController que tengo otro turno mas
	
	
	public Player(int id , Casillero casillero) {
		this.id = id;
		if (id == 0) {
			ubicacionOffsetX = 0;
			ubicacionOffsetY = 0;
		}
		if (id == 1) {
			ubicacionOffsetX = 100;
			ubicacionOffsetY = 100;
		}
			
		this.points = 0;
		this.casillero = casillero;
		this.casilleroAnterior = casillero;
		this.ubicacion = new Ubicacion(casillero.getUbicacionX() + ubicacionOffsetX,casillero.getUbicacionY() + ubicacionOffsetY);
	}
	
	public int getId() {
		return this.id;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public int getUbicacionX() {
		return ubicacion.positionX;
	}
	
	public int getUbicacionY() {
		return ubicacion.positionY;
	}
	
	//Suma puntos al jugador. Se utiliza cuando agarra una monedita o segun el ranking del minijuego
	public void addPoints (int points) {
		this.points += points;
	}
	
	//Devuelve los puntos actuales del jugador
	public int getPoints () {
		return this.points;
	}
	
	//Genera un turno extra para el jugador. Se utiliza cuando agarra una estrella
	public void setExtraTurn() {
		this.extraTurn = true;
	}
	
	//Devuelve verdadero si tiene un turno extra. Se utilza en el GameController antes de avanzar de turno
	public boolean hasExtraTurn() {
		return extraTurn;
	}
	
	public Casillero getCasillero() {
		return this.casillero;
	}
	public Casillero getCasilleroAnterior() {
		return this.casilleroAnterior;
	}
	
	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}
	
	public void setCasilleroAnterior(Casillero casillero) {
		this.casilleroAnterior = casillero;
	}
	
	
	public int tirarDado() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}
	
	public void updateUbicacion() {
		this.ubicacion = new Ubicacion(casillero.getUbicacionX() + ubicacionOffsetX,casillero.getUbicacionY() + ubicacionOffsetY);
	}
	
}
