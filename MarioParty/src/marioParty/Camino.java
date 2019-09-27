package marioParty;

import java.util.ArrayList;

public class Camino {
	

	ArrayList<String> movimientosPosibles = new ArrayList<String>();
	
	public Camino(String[] movimientosPosibles) {
		for (int i = 0 ; i < movimientosPosibles.length ; i++)
			this.movimientosPosibles.add(movimientosPosibles[i]);
		this.movimientosPosibles.sort(null);
	}
	
	boolean canGoUp(){
		return movimientosPosibles.contains("Arriba");
	}
	
	boolean canGoDown(){
		return movimientosPosibles.contains("Abajo");
	}
	
	boolean canGoLeft(){
		return movimientosPosibles.contains("Izquierda");
	}
	
	boolean canGoRight(){
		return movimientosPosibles.contains("Derecha");
	}
	
	
}
