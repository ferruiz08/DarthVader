package marioParty;

public class Estrella extends PowerUp {

	public Estrella(int tipo) {
		this.tipo = tipo;
	}
	
	public void accionPowerUp(Player player) {
		
		player.setExtraTurn();
	}
	
}
