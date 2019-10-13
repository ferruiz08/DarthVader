package marioParty;

import java.util.ArrayList;
import java.util.Random;

public class Casillero {
	
	private Ubicacion ubicacion;
	private ArrayList<Player> listPlayer = new ArrayList<Player>();
	private ArrayList<Casillero> listCasillero = new ArrayList<Casillero>();
	private PowerUp powerUp;
	
	public Casillero(Ubicacion ubicacion) {
		
		this.ubicacion = ubicacion;
		
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	public Ubicacion getUbicacion(int x , int y) {
		return ubicacion.getUbicacion(x, y);
	}
	
	public int getUbicacionX() {
		return ubicacion.positionX;
	}
	
	public int getUbicacionY() {
		return ubicacion.positionY;
	}
	
	public void setPlayer(Player player){
		listPlayer.add(player);
	}
	
	public void removePlayer(Player player) {
		listPlayer.remove(player);
	}
	
	public boolean hayPlayer() {
		return !listPlayer.isEmpty();
	}
	
	public int cantPlayers() {
		return listPlayer.size();
	}
	
	public ArrayList<Player> getListPlayer(){
		return listPlayer;
	}
	
	public ArrayList<Casillero> getListCasillero(){
		return listCasillero;
	}
	
	public Player getPlayer(int i) {
		return listPlayer.get(i);
	}
	
	public int casillerosContiguos() {
		return listCasillero.size();
	}
	
	public void setCasillero(Casillero casillero) {
		listCasillero.add(casillero);
	}
	
	public void removeCasillero(Casillero casillero) {
		listCasillero.remove(casillero);
	}
	
	public Casillero goUp() {
		for (int i = 0 ; i < listCasillero.size() ; i++) {
			if (listCasillero.get(i).ubicacion.positionY < this.ubicacion.positionY)
				return listCasillero.get(i);
		}
		return null;
	}
	
	public Casillero goDown() {
		for (int i = 0 ; i < listCasillero.size() ; i++) {
			if (listCasillero.get(i).ubicacion.positionY > this.ubicacion.positionY)
				return listCasillero.get(i);
		}
		return null;
	}
	
	public Casillero goLeft() {
		for (int i = 0 ; i < listCasillero.size() ; i++) {
			if (listCasillero.get(i).ubicacion.positionX < this.ubicacion.positionX)
				return listCasillero.get(i);
		}
		return null;
	}

	public Casillero goRight() {
		for (int i = 0 ; i < listCasillero.size() ; i++) {
			if (listCasillero.get(i).ubicacion.positionX > this.ubicacion.positionX)
				return listCasillero.get(i);
		}
		return null;
	}
	
	public boolean casilleroVacio() {
		return (listPlayer.isEmpty() && powerUp == null);
	}
	
	//Genera aleatoriamente un powerup en el casillero de un tipo aleatorio solo si el casillero esta vacio
	public void generarPowerUp(){
		if (casilleroVacio()) {
			Random random = new Random();
			//Hay un 25% de probabilidades de que se genere un powerup
			if (random.nextInt(4)+1 == 1 ) {
				int tipoPowerUp = random.nextInt(2)+1;
				if (tipoPowerUp == 1)
					powerUp = new Monedita();
				if (tipoPowerUp == 2)
					powerUp = new Estrella();
			}
		}
		
	}
	
	public void generarMonedita() {
		if (casilleroVacio())
			powerUp = new Monedita();
	}
	
	public void generarEstrella() {
		if (casilleroVacio())
			powerUp = new Estrella();
	}
	
	//Ejecuta la accion del powerup cuando el player entra en el casillero
	public void accionPowerUp(Player player) {
		if (powerUp != null) {
			powerUp.accionPowerUp(player);
			powerUp = null;
		}
		
	}
	
}
