package marioParty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameBoard {
	
	HashMap<Ubicacion,Casillero> casillero;
	
	public GameBoard () {
		casillero = new HashMap<Ubicacion,Casillero>();
		
	}
	
	public void generarCaminos() {
		
	}
	
	public boolean canGoUp(int x, int y) {
		return true;
	}
	
	public boolean canGoDown(int x, int y) {
		return true;
	}
	
	public boolean canGoLeft(int x, int y) {
		return true;
	}

	public boolean canGoRight(int x, int y) {
		return true;
	}
	
	public Ubicacion mover(Ubicacion ubicacion, String direccion) {
		
		if (direccion.contains("w") && canGoUp(ubicacion.positionX,ubicacion.positionY)) 
			ubicacion.positionY--; 
		if (direccion.contains("s") && canGoDown(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionY++;
		if (direccion.contains("a") && canGoLeft(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionX--;
		if (direccion.contains("d") && canGoRight(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionX++; 
		return ubicacion;
	}

	public ArrayList<String> movimientosPosibles(Ubicacion ubicacion, Ubicacion ubicacionAnterior) {
		ArrayList<String> movimientosPosibles = new ArrayList<String>();
		boolean canGoUp = canGoUp(ubicacion.positionX,ubicacion.positionY);
		boolean canGoDown = canGoDown(ubicacion.positionX,ubicacion.positionY);
		boolean canGoLeft = canGoLeft(ubicacion.positionX,ubicacion.positionY);
		boolean canGoRight = canGoRight(ubicacion.positionX,ubicacion.positionY);
		if (ubicacionAnterior.positionX > ubicacion.positionX)
			canGoRight = false;
		if (ubicacionAnterior.positionX < ubicacion.positionX)
			canGoLeft = false;
		if (ubicacionAnterior.positionY > ubicacion.positionY)
			canGoDown = false;
		if (ubicacionAnterior.positionY < ubicacion.positionY)
			canGoUp = false;
		if (canGoRight)
			movimientosPosibles.add("d");
		if (canGoLeft)
			movimientosPosibles.add("a");
		if (canGoUp)
			movimientosPosibles.add("w");
		if (canGoDown)
			movimientosPosibles.add("s");
		return movimientosPosibles;
	}
	
	public void setJugadorCasillero(Player player , Ubicacion ubicacion) {
		casillero[ubicacion.positionX][ubicacion.positionY].setPlayer(player);
	}
	
	public void removeJugadorCasillero(Player player , Ubicacion ubicacion) {
		casillero[ubicacion.positionX][ubicacion.positionY].removePlayer(player);
	}
	
	public void generarPowerUp(Ubicacion ubicacion) {
		casillero[ubicacion.positionX][ubicacion.positionY].generarPowerUp();
	}
	
	public void generarPowerUpTurno() {
		Random random = new Random();
		int x = random.nextInt(casillero.length);
		int y = random.nextInt(casillero[1].length);
		casillero[x][y].generarPowerUp();
	}
	
	public void generarPowerUpInicio() {
		for (int x = 0 ; x < casillero.length ; x++)
			for (int y = 0 ; y < casillero[x].length ; y++)
				casillero[x][y].generarPowerUp();
	}
	
	public void accionPowerUp(Player player , Ubicacion ubicacion) {
		casillero[ubicacion.positionX][ubicacion.positionY].accionPowerUp(player);
	}
	
}
