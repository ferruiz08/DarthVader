package marioParty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Tablero {
	
	HashMap<Ubicacion,Casillero> mapCasilleros;
	
	public Tablero () {
		mapCasilleros = new HashMap<Ubicacion,Casillero>();
		
	}
	
	public void generarDosCasilleros(Ubicacion ubicacion1 , Ubicacion ubicacion2) {
		
		mapCasilleros.put(ubicacion1, new Casillero(ubicacion1));
		mapCasilleros.put(ubicacion2, new Casillero(ubicacion2));
		chequearCasilleros();
	}
	
	public Player generarPlayer(int id,Ubicacion ubicacion) {
		Player player = new Player(id,getCasillero(ubicacion));
		mapCasilleros.get(ubicacion).setPlayer(player);
		return player;
	}
	
	public boolean hayPlayer(Ubicacion ubicacion) {
		return mapCasilleros.get(ubicacion).hayPlayer();
	}
	
	public int casillerosContiguos(Ubicacion ubicacion) {
		return mapCasilleros.get(ubicacion).casillerosContiguos();
	}
	
	
	public HashMap<Ubicacion,Casillero> getTablero() {
		return mapCasilleros;
	}
	
	public Casillero getCasillero(Ubicacion ubicacion) {
		return mapCasilleros.get(ubicacion);
	}
	
	
	public void generarCasilleros() {
		
		Ubicacion ubicacion;
		ubicacion = new Ubicacion(100,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(100,250);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(100,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(100,550);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(100,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(250,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(250,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(250,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(400,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(400,250);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(400,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(400,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(550,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(550,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(550,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(700,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(700,250);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(700,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(700,550);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(700,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(850,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(850,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(1000,100);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(1000,250);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(1000,400);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(1000,550);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		ubicacion = new Ubicacion(1000,700);
		mapCasilleros.put(ubicacion, new Casillero(ubicacion));
		chequearCasilleros();
	}
	
	private void chequearCasilleros() {
		Iterator iter = mapCasilleros.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry map = (Map.Entry)iter.next();
			setearCasillerosContiguos(mapCasilleros.get(map.getKey()));
		}
	}
	
	private void setearCasillerosContiguos(Casillero casillero) {
		Iterator iter = mapCasilleros.entrySet().iterator();
		Ubicacion ubicacion = casillero.getUbicacion();
		while(iter.hasNext()) {
			Map.Entry map = (Map.Entry)iter.next();
			Ubicacion ubicacionOtro = mapCasilleros.get(map.getKey()).getUbicacion();
			int difX = Math.abs(ubicacion.positionX - ubicacionOtro.positionX);
			int difY = Math.abs(ubicacion.positionY - ubicacionOtro.positionY);
			
			if(difX == 0 && difY == 150 || difX == 150 && difY == 0 )
				mapCasilleros.get(map.getKey()).setCasillero(casillero);
		}
	}
	
	
	public Casillero goUp(Casillero casillero) { 
		return casillero.goUp();
	}
	
	public Casillero goDown(Casillero casillero) { 
		return casillero.goDown();
	}
	
	public Casillero goLeft(Casillero casillero) { 
		return casillero.goLeft();
	}
	
	public Casillero goRight(Casillero casillero) { 
		return casillero.goRight();
	}
	
	public ArrayList<Casillero> movimientosPosibles(Casillero casillero,Casillero casilleroAnterior) {
		ArrayList<Casillero> movimientosPosibles = new ArrayList<Casillero>();
		movimientosPosibles.addAll(casillero.getListCasillero());
		movimientosPosibles.remove(casilleroAnterior);
		return movimientosPosibles;
	}
	
	public void setJugadorCasillero(Player player , Casillero casillero) {
		mapCasilleros.get(casillero.getUbicacion()).setPlayer(player);
	}
	
	public void removeJugadorCasillero(Player player , Casillero casillero) {
		mapCasilleros.get(casillero.getUbicacion()).removePlayer(player);
	}
	
	public void generarPowerUp(Ubicacion ubicacion) {
		mapCasilleros.get(ubicacion).generarPowerUp();
	}
	
	public void generarPowerUp(Casillero casillero) {
		casillero.generarPowerUp();
	}
	
	public void generarPowerUpTurno() {
		Object[] keys = mapCasilleros.keySet().toArray();
		Object key = keys[new Random().nextInt(keys.length)];
		mapCasilleros.get(key).generarPowerUp();
	}
	
	public void generarPowerUpInicio() {
		Iterator iter = mapCasilleros.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry map = (Map.Entry)iter.next();
			mapCasilleros.get(map.getKey()).generarPowerUp();
		}
			
	}
	
	
	
	public void accionPowerUp(Player player , Ubicacion ubicacion) {
		mapCasilleros.get(ubicacion).accionPowerUp(player);
	}
	
}
