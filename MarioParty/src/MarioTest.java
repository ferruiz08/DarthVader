import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import marioParty.Tablero;
import marioParty.GameController;
import marioParty.Ubicacion;

class MarioTest {

	@Test
	void test() {
		
		Tablero gameboard = new Tablero();
		Ubicacion ubicacion1 = new Ubicacion(100, 100);
		Ubicacion ubicacion2 = new Ubicacion(100, 250);
		
		gameboard.generarDosCasilleros(ubicacion1, ubicacion2);
		gameboard.generarPlayer(1, ubicacion1);
		
		//assertEquals(true, gameboard.hayPlayer(ubicacion1));
		//assertEquals(false, gameboard.hayPlayer(ubicacion2));
		
		assertEquals(1,gameboard.casillerosContiguos(ubicacion1));
	}

}
