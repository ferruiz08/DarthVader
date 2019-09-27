package marioParty;

import java.io.IOException;
import java.util.ArrayList;

public class GameController {
	
	int contTurnos;
	int turnoPlayer;
	int cantPlayers;
	GameBoard gameboard = new GameBoard();
	ArrayList<Player> listPlayer = new ArrayList<Player>();

	
	public void startGame(int cantPlayers) {
		this.contTurnos = 0;
		this.turnoPlayer = 0;
		this.cantPlayers = cantPlayers;
		for (int i = 0 ; i < cantPlayers ; i++) {
			Player player = new Player(i);
			listPlayer.add(player);
		}
		
		//Genera los caminos del tablero cuando inicia el juego
		gameboard.generarCaminos();
			
	}
	
	public void iniciarTurno() throws IOException {
		System.out.println("Inicia el turno nro: " + contTurnos);
		System.out.println("Es el turno del jugador nro: " + turnoPlayer);
		listPlayer.get(turnoPlayer).ejecutarTurno();
		contTurnos++;
		//Si el jugador tiene un turno extra no cambio el turno al siguiente jugador
		if (!listPlayer.get(turnoPlayer).hasExtraTurn())
			turnoPlayer++;
		if (turnoPlayer >= cantPlayers)
			turnoPlayer = 0;
	}
}
