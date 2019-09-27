package marioParty;

public class Ubicacion {

	int positionX;
	int positionY;
	
	public Ubicacion(int x , int y) {
		this.positionX = x;
		this.positionY = y;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.positionX = ubicacion.positionX;
		this.positionY = ubicacion.positionY;
	}
	
	
	
	
}
