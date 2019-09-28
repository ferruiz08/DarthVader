package marioParty;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
	
	Casillero[][] casillero;
	
	public GameBoard () {
		casillero = new Casillero [5][5];
		
	}
	
	public void generarCaminos() {
		
		//Genero el tablero de la foto de la consigna
		String[] s1 = {"w","d"};
		String[] s2 = {"a","d"};
		String[] s3 = {"a","s"};
		String[] s4 = {"d","s"};
		String[] s5 = {"w","d"};
		String[] s6 = {"w","s","d"};
		String[] s7 = {"w","s","a"};
		String[] s8 = {"w","s"};
		String[] s9 = {"w","a"};
		String[] s10 = {"w","s","a","d"};
		
		casillero[0][0] = new Casillero(s4);
		casillero[1][0] = new Casillero(s2);
		casillero[2][0] = new Casillero(s3);
		casillero[3][0] = new Casillero(s4);
		casillero[4][0] = new Casillero(s3);
		
		casillero[0][1] = new Casillero(s6);
		casillero[1][1] = new Casillero(s3);
		casillero[2][1] = new Casillero(s6);
		casillero[3][1] = new Casillero(s7);
		casillero[4][1] = new Casillero(s8);
		
		casillero[0][2] = new Casillero(s6);
		casillero[1][2] = new Casillero(s10);
		casillero[2][2] = new Casillero(s10);
		casillero[3][2] = new Casillero(s10);
		casillero[4][2] = new Casillero(s7);
		
		casillero[0][3] = new Casillero(s6);
		casillero[1][3] = new Casillero(s4);
		casillero[2][3] = new Casillero(s3);
		casillero[3][3] = new Casillero(s1);
		casillero[4][3] = new Casillero(s7);
		
		casillero[0][4] = new Casillero(s1);
		casillero[1][4] = new Casillero(s9);
		casillero[2][4] = new Casillero(s5);
		casillero[3][4] = new Casillero(s2);
		casillero[4][4] = new Casillero(s9);
	}
	
	public boolean canGoUp(int x, int y) {
		return casillero[x][y].canGoUp();
	}
	
	public boolean canGoDown(int x, int y) {
		return casillero[x][y].canGoDown();
	}
	
	public boolean canGoLeft(int x, int y) {
		return casillero[x][y].canGoLeft();
	}

	public boolean canGoRight(int x, int y) {
		return casillero[x][y].canGoRight();
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
