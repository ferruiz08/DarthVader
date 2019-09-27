package marioParty;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		GameController gameController = new GameController();
		gameController.startGame(2);
		while(true)
		gameController.iniciarTurno();
	}

}
