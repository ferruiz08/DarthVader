package marioParty;

public class Monedita extends PowerUp {

	public int puntosMoneda;
	
	public Monedita(int puntosMoneda) {
		
		this.puntosMoneda = puntosMoneda;
	}
	
	public void accionPowerUp(Player player) {
		
		player.addPoints(puntosMoneda);
		
	}
	
}
