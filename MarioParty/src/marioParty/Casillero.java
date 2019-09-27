package marioParty;

import java.util.ArrayList;

public class Casillero {
	
	ArrayList<Player> ListPlayer = new ArrayList<Player>();
	PowerUp powerUp;
	Camino camino;
	

	
	public Casillero(String[] tipoCamino) {
		camino = new Camino(tipoCamino);
	}
	
	public void setPlayer(Player player){
		ListPlayer.add(player);
	}
	
	public void removePlayer(Player player) {
		ListPlayer.remove(player);
	}
	
	public void setPowerUp(PowerUp powerUp){
		this.powerUp = powerUp;
	}
	
	public void removePowerUp(PowerUp powerUp) {
		this.powerUp = null;
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
