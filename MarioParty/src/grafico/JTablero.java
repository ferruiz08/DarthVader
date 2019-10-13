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
import java.awt.event.KeyListener;
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


public class JTablero extends JPanel implements KeyListener {

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
    GameController gameController;
    public Movimientos mov;
	
   public JTablero(GameController gameController) throws IOException {
	   this.gameController = gameController;
	   init();
	   
   }
    
    private void init() throws IOException {
    	addKeyListener(this);
    	setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImages();
        
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
        HashMap<Ubicacion,Casillero> mapCasilleros = gameController.getTablero();
    	g.drawImage(iBackground, 0, 0, this);
    	Iterator iter = mapCasilleros.entrySet().iterator();
    	while(iter.hasNext()) {
			Map.Entry map = (Map.Entry)iter.next();
			g.drawImage(iBlock, mapCasilleros.get(map.getKey()).getUbicacionX(), mapCasilleros.get(map.getKey()).getUbicacionY(), this);
			for (int i = 0 ; i < mapCasilleros.get(map.getKey()).cantPlayers() ; i++)
				g.drawImage(iMario, mapCasilleros.get(map.getKey()).getPlayer(i).getUbicacionX(), mapCasilleros.get(map.getKey()).getPlayer(i).getUbicacionY(), this);

		}
 	
    }
    
    @Override
	public void keyPressed(KeyEvent e) {
		
		//if (mov == Movimientos.NULL) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
					mov = Movimientos.ABAJO;
				break;
			case KeyEvent.VK_RIGHT:
					mov = Movimientos.DERECHA;
				break;
			case KeyEvent.VK_LEFT:
					mov = Movimientos.IZQUIERDA;
				break;
			case KeyEvent.VK_UP:
					mov = Movimientos.ARRIBA;
				break;
			case KeyEvent.VK_ENTER:
				mov = Movimientos.DADO;
				break;
			default:
				break;
			}
			gameController.movimiento = mov;
		//}
	}

	@Override
	public void keyReleased(KeyEvent e) {


		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			this.mov = Movimientos.NULL;
			break;
		case KeyEvent.VK_RIGHT:
			this.mov = Movimientos.NULL;
			break;
		case KeyEvent.VK_LEFT:
			this.mov = Movimientos.NULL;
			break;
		case KeyEvent.VK_UP:
			this.mov = Movimientos.NULL;
			break;
		case KeyEvent.VK_ENTER:
			this.mov = Movimientos.NULL;
			break;
		default:
			break;
		}
		gameController.movimiento = mov;
	
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    

	
}
