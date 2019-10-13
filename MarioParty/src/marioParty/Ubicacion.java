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
	
	public Ubicacion getUbicacion(int x , int y) {
		if(positionX == x && positionY == y)
			return this;
		else
			return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		Ubicacion ubicacion = (Ubicacion) obj; 
		if (this.positionX == ubicacion.positionX && this.positionY == ubicacion.positionY)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * positionX * positionY;
		return hash;
	}

	
}
