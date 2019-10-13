package marioParty;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	
	public Movimientos mov;
	public Teclado() {
		mov = Movimientos.NULL;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (mov == Movimientos.NULL) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
					this.mov = Movimientos.ABAJO;
				break;
			case KeyEvent.VK_RIGHT:
					this.mov = Movimientos.DERECHA;
				break;
			case KeyEvent.VK_LEFT:
					this.mov = Movimientos.IZQUIERDA;
				break;
			case KeyEvent.VK_UP:
					this.mov = Movimientos.ARRIBA;
				break;
			case KeyEvent.VK_ESCAPE:
				break;
			default:
				break;
			}
		}
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
		case KeyEvent.VK_ESCAPE:
			//Agregar comando para salir
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}