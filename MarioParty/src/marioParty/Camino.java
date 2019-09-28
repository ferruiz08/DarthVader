package marioParty;

import java.util.ArrayList;

public class Camino {
	

	ArrayList<String> movimientosPosibles = new ArrayList<String>();
	
	public Camino(String[] movimientosPosibles) {
		for (int i = 0 ; i < movimientosPosibles.length ; i++)
			this.movimientosPosibles.add(movimientosPosibles[i]);
	}
	
	boolean canGoUp(){
		return movimientosPosibles.contains("w");
	}
	
	boolean canGoDown(){
		return movimientosPosibles.contains("s");
	}
	
	boolean canGoLeft(){
		return movimientosPosibles.contains("a");
	}
	
	boolean canGoRight(){
		return movimientosPosibles.contains("d");
	}
	
	
}
