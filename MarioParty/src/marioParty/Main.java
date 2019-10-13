package marioParty;

import java.io.IOException;
import java.util.Scanner;

import grafico.JMarioParty;

public class Main {

	public static void main(String[] args) throws IOException {
		

		GameController gameController = new GameController();
		gameController.generarCasilleros();
		gameController.startGame();
		JMarioParty ex = new JMarioParty(gameController);
        ex.setVisible(true);
	}

}
