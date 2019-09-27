package marioParty;

import java.util.ArrayList;

public class Casillero {
	
	ArrayList<Player> ListPlayer = new ArrayList<Player>();
	Camino camino;
	boolean hayMonedita; //La moneda da puntos
	boolean hayEstrella; //La estrella de un turno extra
	

	
	public Casillero(String[] tipoCamino) {
		camino = new Camino(tipoCamino);
	}
	
	public void setPlayer(Player player){
		ListPlayer.add(player);
	}
	
	public void removePlayer(Player player) {
		ListPlayer.remove(player);
		//Hay que buscar en que indice de la lista esta el objecto player y removerlo por indice
	}
	
	public boolean canGoUp() {
		return this.camino.canGoUp();
	}
	
	public boolean canGoDown() {
		return this.camino.canGoDown();
	}
	
	public boolean canGoLeft() {
		return this.camino.canGoLeft();
	}

	public boolean canGoRight() {
		return this.camino.canGoRight();
	}
	
	
}
