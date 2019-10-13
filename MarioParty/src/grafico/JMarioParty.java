package grafico;

import java.io.IOException;

import javax.swing.JFrame;

public class JMarioParty extends JFrame {

	public JMarioParty() throws IOException {
		init();
	}
	
	 private void init() throws IOException {
	        
	        setSize(1920,1000);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	add(new JTablero());
	        setResizable(false);
	        setTitle("Mario Party");
	        setLocationRelativeTo(null);
	        
	    }
	
	public static void main(String[] args) throws IOException {
           
		JMarioParty ex = new JMarioParty();
        ex.setVisible(true);

	}

}
