package grafico;

import java.io.IOException;

import javax.swing.JFrame;

import marioParty.GameController;

public class JMarioParty extends JFrame {

	GameController gameController;
	JTablero jTablero;
	
	public JMarioParty(GameController gameController) throws IOException {
		this.gameController = gameController;
		init();
		
	}
	
	 private void init() throws IOException {
	        
	        setSize(1920,1000);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	jTablero = new JTablero(gameController);
	        add(jTablero);
	        pack();
	        setVisible(true); 	
	        setTitle("Mario Party");
	        //setLocationRelativeTo(null);
	        
	        ThreadPaint threadPaint = new ThreadPaint(jTablero);
	        threadPaint.start();
	    }
	

}
