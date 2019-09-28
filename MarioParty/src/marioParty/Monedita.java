package marioParty;

public class Monedita extends PowerUp {

	public int puntosMoneda;
	
	public Monedita(int tipo , int puntosMoneda) {
		this.tipo = tipo;
		this.puntosMoneda = puntosMoneda;
	}
	
	public void accionPowerUp(Player player) {
		
		player.addPoints(puntosMoneda);
		
	}
	
}
