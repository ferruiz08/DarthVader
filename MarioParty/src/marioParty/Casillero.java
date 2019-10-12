package marioParty;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Casillero {
	
	private Ubicacion ubicacion;
	private ArrayList<Player> listPlayer = new ArrayList<Player>();
	private ArrayList<Casillero> listCasillero = new ArrayList<Casillero>();
	private PowerUp powerUp;
	
	public Casillero(int x , int y) {
		
		ubicacion.positionX = x;
		ubicacion.positionY = y;
		
	}
	
	public void setPlayer(Player player){
		listPlayer.add(player);
	}
	
	public void removePlayer(Player player) {
		listPlayer.remove(player);
		//Hay que buscar en que indice de la lista esta el objecto player y removerlo por indice
	}
	
	public boolean canGoUp() {
		return true;
	}
	
	public boolean canGoDown() {
		return true;
	}
	
	public boolean canGoLeft() {
		return true;
	}

	public boolean canGoRight() {
		return true;
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
				int tipoPowerUp = random.nextInt(PowerUp.cantTipos)+1;
				if (tipoPowerUp == 1)
					powerUp = new Monedita(1,10);
				if (tipoPowerUp == 2)
					powerUp = new Estrella(2);
			}
		}
		
	}
	
	//Ejecuta la accion del powerup cuando el player entra en el casillero
	public void accionPowerUp(Player player) {
		if (powerUp != null) {
			powerUp.accionPowerUp(player);
			if (powerUp.tipo == 1)
				System.out.println("AGARRASTE UNA MONEDITA");
			if (powerUp.tipo == 2)
				System.out.println("AGARRASTE UNA ESTRELLA");
			powerUp = null;
		}
		
	}
	
}
