package grafico;

import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import marioParty.*;


public class JTablero extends JPanel {

	private final int WIDTH = 1920;
    private final int HEIGHT = 1000;
	
    private Image iBackground;
    private Image iBlock;
    private Image iMonedita;
    private Image iEstrella;
    private Image iMario;
    private Image iLuigi;
    private Image iMegaman;
    private Image iPrincesa;
    

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private boolean finDeJuego = false;
    private int contTurnos;
    private int turnoPlayer;
	private int cantPlayers;
	private int puntajeGanador;
	private Tablero tablero;
	ArrayList<Player> listPlayer = new ArrayList<Player>();
	
   public JTablero() throws IOException {
	   init();
   }
    
    private void init() throws IOException {
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImages();
        tablero = new Tablero();
        tablero.generarCasilleros();
        
        puntajeGanador = 100;
        contTurnos = 0;
		turnoPlayer = 0;
        cantPlayers = 1;
        listPlayer.add(tablero.generarPlayer(0, new Ubicacion(100,100)));

    }
    
    private void loadImages() {
    	ImageIcon background = new ImageIcon("src/sprites/background.png");
    	iBackground = background.getImage();
    	
    	ImageIcon block = new ImageIcon("src/sprites/block.png");
    	iBlock = block.getImage();
    	aplicarTransparencia(iBlock);
   	
    	ImageIcon mario = new ImageIcon("src/sprites/mario.png");
    	iMario = mario.getImage();
    	aplicarTransparencia(iMario);
    	
    	ImageIcon luigi = new ImageIcon("src/sprites/luigi.png");
    	iLuigi = luigi.getImage();
    	aplicarTransparencia(iLuigi);
    	
    	ImageIcon princesa = new ImageIcon("src/sprites/peach.png");
    	iPrincesa = princesa.getImage();
    	aplicarTransparencia(iPrincesa);
    	
    	ImageIcon megaman = new ImageIcon("src/sprites/megaman.png");
    	iMegaman = megaman.getImage();
    	aplicarTransparencia(iMegaman);
        	
    }
    
    private void aplicarTransparencia(Image image) {
    	BufferedImage tmpImg = new BufferedImage(image.getWidth(this), image.getHeight(this), 
    	BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f)); 

    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        HashMap<Ubicacion,Casillero> mapCasilleros = tablero.getTablero();
    	g.drawImage(iBackground, 0, 0, this);
    	Iterator iter = mapCasilleros.entrySet().iterator();
    	while(iter.hasNext()) {
			Map.Entry map = (Map.Entry)iter.next();
			g.drawImage(iBlock, mapCasilleros.get(map.getKey()).getUbicacionX(), mapCasilleros.get(map.getKey()).getUbicacionY(), this);
			for (int i = 0 ; i < mapCasilleros.get(map.getKey()).cantPlayers() ; i++)
				g.drawImage(iMario, mapCasilleros.get(map.getKey()).getPlayer(i).getUbicacionX(), mapCasilleros.get(map.getKey()).getPlayer(i).getUbicacionY(), this);

		}
		
    	
    	
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
		int movimientosRestantes = player.tirarDado();
		int movimientoHechos = 0;
		while (movimientoHechos < movimientosRestantes && !finDeJuego) {
			//Pregunto que movimientos puede hacer
			movimientosPosibles = tablero.movimientosPosibles(player.getCasillero(), player.getCasilleroAnterior());
			if (movimientosPosibles.size() > 1) {
	            //Chequeo que el movimiento ingresado sea posible
	            if (downDirection && tablero.goDown(player.getCasillero()) != null) 
	            	mover(player,tablero.goDown(player.getCasillero()));
	            if (upDirection && tablero.goUp(player.getCasillero()) != null) 
		            mover(player,tablero.goUp(player.getCasillero()));	
		        if (leftDirection && tablero.goLeft(player.getCasillero()) != null) 
			        mover(player,tablero.goLeft(player.getCasillero()));		
		        if (rightDirection && tablero.goRight(player.getCasillero()) != null) 
			        mover(player,tablero.goRight(player.getCasillero()));	
	            	  	
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
  			repaint();
  		}
	
    

	 private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
	                leftDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
	                rightDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
	                upDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }

	            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
	                downDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }
	        }
	    }
	
}
