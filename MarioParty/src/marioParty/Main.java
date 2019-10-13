package marioParty;

import java.io.IOException;
import java.util.Scanner;

import grafico.JMarioParty;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		GameController gameController = new GameController();
		gameController.generarCasilleros();
		
		JMarioParty ex = new JMarioParty(gameController);
        
        
        Thread.sleep(1000);
        gameController.startGame();
	}

}
