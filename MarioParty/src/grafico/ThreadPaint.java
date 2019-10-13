package grafico;

import javax.swing.JPanel;


public class ThreadPaint extends Thread{

	JPanel jTablero;
	
	public ThreadPaint(JPanel jTablero) {
		this.jTablero = jTablero;

	}
	
	public void run() {
		while(true) {
			
			jTablero.repaint();
		}
	}
}
