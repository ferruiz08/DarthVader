package marioParty;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner entrada;
	private static Scanner teclado;
	private static String seguir;

	public static void main(String[] args) throws IOException {
		
		int cant=1, limite=0;
		GameController gameController = new GameController();
		entrada = new Scanner(System.in);
		System.out.println("\t \t \t \t ******* Instrucciones de Juego: *******");
		System.out.print("Tenes que ingresar por teclado la cantidad de jugadores y el puntaje maximo por el que van a cometir \n"
				       + "Gana el primer jugador que llegue a ese puntaje \n"
				       + "MOVIMIENTOS:\n DESPLAZARSE A LA IZQUIERDA: tecla a \n DESPLAZARSE A LA DERECHA: tecla d \n DESPLAZARSE ARRIBA: tecla w \n DESPLAZARSE ABAJO: tecla a\n");
	    
		teclado = new Scanner(System.in);
	    System.out.println("Presiona una tecla para continuar...");
	    seguir = teclado.nextLine();
		System.out.print("Ingresa la cantidad de JUGADORES: ");
		cant = entrada.nextInt();
		System.out.print("Ingresa la cantidad de puntos MAXIMA: ");
		limite = entrada.nextInt();

		gameController.startGame(cant,limite);

	}

}
