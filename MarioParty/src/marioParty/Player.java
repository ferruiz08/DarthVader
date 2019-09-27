package marioParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	private int id;
	private int points;
	private Ubicacion ubicacion; //Ubicacion actual en el tablero
	private Ubicacion ubicacionAnterior; //Ubicacion anterior en el tablero para que no me deje regresar
	private boolean extraTurn; //Si agarro una estrella tengo que setear este bit e informar al gameController que tengo otro turno mas
	
	public Player(int id) {
		this.id = id;
		this.points = 0;
		ubicacion = new Ubicacion(0,0);
		ubicacionAnterior = new Ubicacion(0,0);
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
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	public Ubicacion getUbicacionAnterior() {
		return this.ubicacionAnterior;
	}
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion.positionX = ubicacion.positionX;
		this.ubicacion.positionY = ubicacion.positionY;
	}
	
	public void setUbicacionAnterior(Ubicacion ubicacion) {
		this.ubicacionAnterior.positionX = ubicacion.positionX;
		this.ubicacionAnterior.positionY = ubicacion.positionY;
	}
	
	public void imprimirUbicacion() {
		System.out.println("Posicion Actual X: " + ubicacion.positionX);
		System.out.println("Posicion Actual Y: " + ubicacion.positionY);
	}
	
	public int tirarDado() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}
	
}
