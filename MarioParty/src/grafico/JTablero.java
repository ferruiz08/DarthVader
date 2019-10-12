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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import marioParty.GameController;

public class JTablero extends JPanel implements ActionListener{

	private final int WIDTH = 1920;
    private final int HEIGHT = 1000;
	
    private GameController gameController;
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
    private boolean inGame = true;
   
   public JTablero() {
	   init();
   }
    
    private void init() {
    	addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImages();
        gameController = new GameController();
 
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
    
    	g.drawImage(iBackground, 0, 0, this);
    	g.drawImage(iBlock, 100, 100, this);
    	g.drawImage(iBlock, 100, 250, this);
    	g.drawImage(iBlock, 100, 400, this);
    	g.drawImage(iBlock, 100, 550, this);
    	g.drawImage(iBlock, 100, 700, this);
    	g.drawImage(iBlock, 250, 100, this);
    	g.drawImage(iBlock, 250, 400, this);
    	g.drawImage(iBlock, 250, 700, this);
    	g.drawImage(iBlock, 400, 100, this);
    	g.drawImage(iBlock, 400, 250, this);
    	g.drawImage(iBlock, 400, 400, this);
    	g.drawImage(iBlock, 400, 700, this);
    	g.drawImage(iBlock, 550, 100, this);
    	g.drawImage(iBlock, 550, 400, this);
    	g.drawImage(iBlock, 550, 700, this);
    	g.drawImage(iBlock, 700, 100, this);
    	g.drawImage(iBlock, 700, 250, this);
    	g.drawImage(iBlock, 700, 400, this);
    	g.drawImage(iBlock, 700, 550, this);
    	g.drawImage(iBlock, 700, 700, this);
    	g.drawImage(iBlock, 850, 100, this);
    	g.drawImage(iBlock, 850, 700, this);
    	g.drawImage(iBlock, 1000, 100, this);
    	g.drawImage(iBlock, 1000, 250, this);
    	g.drawImage(iBlock, 1000, 400, this);
    	g.drawImage(iBlock, 1000, 550, this);
    	g.drawImage(iBlock, 1000, 700, this);
    	g.drawImage(iMario, 120, 100, this);
    	g.drawImage(iLuigi, 180, 100, this);
    	g.drawImage(iPrincesa, 120, 175, this);
    	g.drawImage(iMegaman, 180, 175, this);

    	
    }

    @Override
	public void actionPerformed(ActionEvent arg0) {
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
