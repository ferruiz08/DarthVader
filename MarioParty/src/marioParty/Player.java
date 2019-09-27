package marioParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	int id;
	int points;
	Ubicacion ubicacion; //Ubicacion actual en el tablero
	Ubicacion ubicacionAnterior; //Ubicacion anterior en el tablero para que no me deje regresar
	boolean extraTurn; //Si agarro una estrella tengo que setear este bit e informar al gameController que tengo otro turno mas
	
	public Player(int id) {
		this.id = id;
		this.points = 0;
		ubicacion = new Ubicacion(0,0);
		ubicacionAnterior = new Ubicacion(0,0);
	}
	
	public void ejecutarTurno() throws IOException {
		imprimirUbicacion();
		ArrayList<String> movimientosPosibles = new ArrayList<String>();
		Random random = new Random();
		int movimientosRestantes = random.nextInt(6)+1;
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
	
	void mover(String direccion) {
		//Guardo la ubicacion para saber que en el proximo movimiento no puedo volver
		ubicacionAnterior.setUbicacion(ubicacion.positionX, ubicacion.positionY);
		GameBoard.mover(ubicacion, direccion);
	}
	
	void imprimirUbicacion() {
		System.out.println("Posicion Actual X: " + ubicacion.positionX);
		System.out.println("Posicion Actual Y: " + ubicacion.positionY);
	}
	
	
}
