package marioParty;

public class Estrella extends PowerUp {

	public void accionPowerUp(Player player) {
		
		player.setExtraTurn();
	}
	
	public boolean soyEstrella() {
		return true;
	}
	
}
