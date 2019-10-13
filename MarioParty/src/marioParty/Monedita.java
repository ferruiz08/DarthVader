package marioParty;

public class Monedita extends PowerUp {

	private int puntosMonedita = 10;
	
	public void accionPowerUp(Player player) {
		
		player.addPoints(puntosMonedita);
		
	}
	
	public boolean soyMonedita() {
		return true;
	}
	
}
