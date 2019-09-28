package marioParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameController {
	
	int contTurnos;
	int turnoPlayer;
	int cantPlayers;
	int puntajeGanador;
	boolean finDeJuego;
	GameBoard gameboard = new GameBoard();
	ArrayList<Player> listPlayer = new ArrayList<Player>();

	
	public void startGame(int cantPlayers, int puntajeGanador) throws IOException {
		this.puntajeGanador = puntajeGanador;
		this.contTurnos = 0;
		this.turnoPlayer = 0;
		this.cantPlayers = cantPlayers;
		for (int i = 0 ; i < cantPlayers ; i++) {
			Player player = new Player(i);
			listPlayer.add(player);
		}
		
		//Genera los caminos del tablero cuando inicia el juego
		gameboard.generarCaminos();
		//Genera los powerups iniciales
		gameboard.generarPowerUpInicio();
		
		while(!finDeJuego) {
			iniciarTurno();
		}
		
	}
		
	
	public void iniciarTurno() throws IOException {
		
			System.out.println("----------- NUEVO TURNO ------------");
			System.out.println("Inicia el turno nro: " + contTurnos);
			System.out.println("Es el turno del jugador nro: " + turnoPlayer);
			ejecutarTurno(listPlayer.get(turnoPlayer));
			contTurnos++;
			//Genero un powerup en un lugar aleatorio
			gameboard.generarPowerUpTurno();
			//Si el jugador tiene un turno extra no cambio el turno al siguiente jugador
			if (!listPlayer.get(turnoPlayer).hasExtraTurn())
				turnoPlayer++;
			if (turnoPlayer >= cantPlayers)
				turnoPlayer = 0;
	}
	
	//Ejecuta el turno del jugador. Se llama en el GameController en cada turno
		public void ejecutarTurno(Player player) throws IOException {
			player.imprimirUbicacion();
			System.out.println("Puntaje Actual: " + player.getPoints());
			ArrayList<String> movimientosPosibles = new ArrayList<String>();
			int movimientosRestantes = player.tirarDado();
			System.out.println("Dado: " + movimientosRestantes);
			int movimientoHechos = 0;
			while (movimientoHechos < movimientosRestantes) {
				//Pregunto que movimientos puede hacer
				movimientosPosibles = gameboard.movimientosPosibles(player.getUbicacion(), player.getUbicacionAnterior());
				if (movimientosPosibles.size() > 1) {
					//Si hay mas de uno posible, pido que se ingrese por pantalla
					System.out.print("Movimiento Posible: ");
					for (int i = 0 ; i < movimientosPosibles.size() ; i++ )
						System.out.print(movimientosPosibles.get(i) + " - ");
					System.out.print("Ingresa el Movimiento deseado: ");
					InputStreamReader in = new InputStreamReader(System.in);
		            BufferedReader br = new BufferedReader(in);
		            String movimientoInput = br.readLine();
		            //Chequeo que el movimiento ingresado sea posible
		            if (movimientosPosibles.contains(movimientoInput)) {
		            	mover(player,movimientoInput);
		            	movimientoHechos++;
		            }
		            
				}
				else {
					System.out.println("Unico movimiento posible");
					mover(player,movimientosPosibles.get(0));
					movimientoHechos++;
				}
				player.imprimirUbicacion();
				System.out.println("Movimientos Hecho: " + movimientoHechos + " ------ Movimientos Restantes: " + (movimientosRestantes - movimientoHechos));
					
			}
		}
		
		//Mueve al jugador una posicion en la direccion indicada
		private void mover(Player player , String direccion) {
			//Guardo la ubicacion para saber que en el proximo movimiento no puedo volver
			player.setUbicacionAnterior(player.getUbicacion());
			player.setUbicacion(gameboard.mover(player.getUbicacion(), direccion));
			//Despues de mover inserto el jugador en el casillero
			gameboard.setJugadorCasillero(player, player.getUbicacion());
			//Retiro el jugador del casillero
			gameboard.removeJugadorCasillero(player, player.getUbicacionAnterior());
			//Chequeo si en el casillero hay un powerup
			gameboard.accionPowerUp(player, player.getUbicacion());
			//Imprimo el puntaje del jugador
			System.out.println("Puntaje Actual: " + player.getPoints());
			
			if(player.getPoints()>=puntajeGanador) {
				 finDeJuego = true;
				 System.out.println("######## El jugador " + player.getId() + "  Gano #########");
			}
		}
		
}
