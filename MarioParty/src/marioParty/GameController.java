package marioParty;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController  {
	
	int contTurnos;
	int turnoPlayer;
	int cantPlayers;
	int puntajeGanador;
	boolean finDeJuego;
	private Tablero tablero = new Tablero();
	ArrayList<Player> listPlayer = new ArrayList<Player>();
	private Teclado teclado = new Teclado();
    
	public HashMap<Ubicacion,Casillero> getTablero() {
		return tablero.getTablero();
	}
	
	public GameController getGameController() {
		return this;
	}
	
	public void startGame() {
    	
		this.puntajeGanador = 100;
		this.contTurnos = 0;
		this.turnoPlayer = 0;
		this.cantPlayers = 1;
		listPlayer.add(tablero.generarPlayer(0, new Ubicacion(100,100)));
		
	}

	public void generarCasilleros() {
		tablero.generarCasilleros();
	}
	
	 private void iniciarTurno() {
	    	
	    	ejecutarTurno(listPlayer.get(turnoPlayer));
			contTurnos++;
			//Genero un powerup en un lugar aleatorio
			tablero.generarPowerUpTurno();
			//Si el jugador tiene un turno extra no cambio el turno al siguiente jugador
			if (!listPlayer.get(turnoPlayer).hasExtraTurn())
				turnoPlayer++;
			if (turnoPlayer >= cantPlayers)
				turnoPlayer = 0;
	    }
	
	 public void ejecutarTurno(Player player) {
	    	ArrayList<Casillero> movimientosPosibles;
			int movimientosRestantes = 0;
			//while(teclado.mov != null)
			//	if (teclado.mov == Movimientos.DADO)
					movimientosRestantes = player.tirarDado();
			int movimientoHechos = 0;
			while (movimientoHechos < movimientosRestantes && !finDeJuego) {
				//Pregunto que movimientos puede hacer
				movimientosPosibles = tablero.movimientosPosibles(player.getCasillero(), player.getCasilleroAnterior());
				if (movimientosPosibles.size() > 1) {
		            //Chequeo que el movimiento ingresado sea posible
				//	while(teclado.mov != null) {
		            	if (teclado.mov == Movimientos.ABAJO && tablero.goDown(player.getCasillero()) != null) 
			            	mover(player,tablero.goDown(player.getCasillero()));
			            if (teclado.mov == Movimientos.ARRIBA && tablero.goUp(player.getCasillero()) != null) 
				            mover(player,tablero.goUp(player.getCasillero()));	
				        if (teclado.mov == Movimientos.IZQUIERDA && tablero.goLeft(player.getCasillero()) != null) 
					        mover(player,tablero.goLeft(player.getCasillero()));		
				        if (teclado.mov == Movimientos.DERECHA && tablero.goRight(player.getCasillero()) != null) 
					        mover(player,tablero.goRight(player.getCasillero()));	
		      //      }	  	
		            movimientoHechos++;	            
		          
				}
				else {
				    mover(player,movimientosPosibles.get(0));
					movimientoHechos++;

				}
			}	
	    }
	    
	    
	    //Mueve al jugador una posicion en la direccion indicada
	  		private void mover(Player player , Casillero casillero) {
	  			//Guardo la ubicacion para saber que en el proximo movimiento no puedo volver
	  			player.setCasilleroAnterior(player.getCasillero());
	  			player.setCasillero(casillero);
	  			player.updateUbicacion();
	  			//Despues de mover inserto el jugador en el casillero
	  			tablero.setJugadorCasillero(player, player.getCasillero());
	  			//Retiro el jugador del casillero
	  			tablero.removeJugadorCasillero(player, player.getCasilleroAnterior());
	  			//Chequeo si en el casillero hay un powerup
	  			tablero.accionPowerUp(player, player.getUbicacion());	
	  			if(player.getPoints()>=puntajeGanador) {
	  				 finDeJuego = true;
	  			}
	  			
	  		}
}
