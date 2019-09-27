package marioParty;

import java.util.ArrayList;

public class GameBoard {
	
	static Casillero[][] casillero;
	
	public GameBoard () {
		casillero = new Casillero [5][5];
		
	}
	
	public void generarCaminos() {
		
		//Genero el tablero de la foto de la consigna
		String[] s1 = {"Arriba","Derecha"};
		String[] s2 = {"Izquierda","Derecha"};
		String[] s3 = {"Izquierda","Abajo"};
		String[] s4 = {"Derecha","Abajo"};
		String[] s5 = {"Arriba","Derecha"};
		String[] s6 = {"Arriba","Abajo","Derecha"};
		String[] s7 = {"Arriba","Abajo","Izquierda"};
		String[] s8 = {"Arriba","Abajo"};
		String[] s9 = {"Arriba","Izquierda"};
		String[] s10 = {"Arriba","Abajo","Izquierda","Derecha"};
		
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
	
	public static boolean canGoUp(int x, int y) {
		return casillero[x][y].canGoUp();
	}
	
	public static boolean canGoDown(int x, int y) {
		return casillero[x][y].canGoDown();
	}
	
	public static boolean canGoLeft(int x, int y) {
		return casillero[x][y].canGoLeft();
	}

	public static boolean canGoRight(int x, int y) {
		return casillero[x][y].canGoRight();
	}
	
	public static Ubicacion mover(Ubicacion ubicacion, String direccion) {
		
		if (direccion.contains("Arriba") && canGoUp(ubicacion.positionX,ubicacion.positionY)) 
			ubicacion.positionY--; 
		if (direccion.contains("Abajo") && canGoDown(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionY++;
		if (direccion.contains("Izquierda") && canGoLeft(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionX--;
		if (direccion.contains("Derecha") && canGoRight(ubicacion.positionX,ubicacion.positionY))
			ubicacion.positionX++; 
		return ubicacion;
	}

	public static ArrayList<String> movimientosPosibles(Ubicacion ubicacion, Ubicacion ubicacionAnterior) {
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
			movimientosPosibles.add("Derecha");
		if (canGoLeft)
			movimientosPosibles.add("Izquierda");
		if (canGoUp)
			movimientosPosibles.add("Arriba");
		if (canGoDown)
			movimientosPosibles.add("Abajo");
		return movimientosPosibles;
	}
	
}
