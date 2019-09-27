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
	
	//Ejecuta el turno del jugador. Se llama en el GameController en cada turno
	public void ejecutarTurno() throws IOException {
		imprimirUbicacion();
		ArrayList<String> movimientosPosibles = new ArrayList<String>();
		int movimientosRestantes = tirarDado();
		System.out.println("Dado: " + movimientosRestantes);
		int movimientoHechos = 0;
		while (movimientoHechos < movimientosRestantes) {
			//Pregunto que movimientos puede hacer
			movimientosPosibles = GameBoard.movimientosPosibles(ubicacion, ubicacionAnterior);
			if (movimientosPosibles.size() > 1) {
				//Si hay mas de uno posible, pido que se ingrese por pantalla
				for (int i = 0 ; i < movimientosPosibles.size() ; i++ )
					System.out.println("Movimiento Posible: " + movimientosPosibles.get(i));
				InputStreamReader in = new InputStreamReader(System.in);
	            BufferedReader br = new BufferedReader(in);
	            String movimientoInput = br.readLine();
	            //Chequeo que el movimiento ingresado sea posible
	            if (movimientosPosibles.contains(movimientoInput)) {
	            	mover(movimientoInput);
	            	movimientoHechos++;
	            }
	            
			}
			else {
				mover(movimientosPosibles.get(0));
				movimientoHechos++;
			}
			imprimirUbicacion();
			System.out.println("Movimientos Hecho: " + movimientoHechos);
			System.out.println("Movimientos Restantes: " + (movimientosRestantes - movimientoHechos));
				
		}
	}
	
	//Mueve al jugador una posicion en la direccion indicada
	private void mover(String direccion) {
		//Guardo la ubicacion para saber que en el proximo movimiento no puedo volver
		ubicacionAnterior.setUbicacion(ubicacion.positionX, ubicacion.positionY);
		this.ubicacion = GameBoard.mover(ubicacion, direccion);
		//Despues de mover inserto el jugador en el casillero
		GameBoard.setJugadorCasillero(this, ubicacion);
		//Chequeo si en el casillero hay un powerup
		GameBoard.accionPowerUp(this, ubicacion);
	}
	
	public void imprimirUbicacion() {
		System.out.println("Posicion Actual X: " + ubicacion.positionX);
		System.out.println("Posicion Actual Y: " + ubicacion.positionY);
	}
	
	private int tirarDado() {
		Random random = new Random();
		return random.nextInt(6)+1;
	}
	
}
