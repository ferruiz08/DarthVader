package marioParty;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner entrada;

	public static void main(String[] args) throws IOException {
		
		int cant=1, limite=0;
		GameController gameController = new GameController();
		entrada = new Scanner(System.in);
		System.out.print("Ingresa la cantidad de JUGADORES: ");
		cant = entrada.nextInt();
		System.out.print("Ingresa la cantidad de puntos MAXIMA: ");
		limite = entrada.nextInt();
		
		gameController.startGame(cant,limite);

	}

}
