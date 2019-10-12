package grafico;

import javax.swing.JFrame;

public class JMarioParty extends JFrame {

	public JMarioParty() {
		init();
	}
	
	 private void init() {
	        
	        setSize(1920,1000);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	add(new JTablero());
	        setResizable(false);
	        setTitle("Mario Party");
	        setLocationRelativeTo(null);
	        
	    }
	
	public static void main(String[] args) {
           
		JMarioParty ex = new JMarioParty();
        ex.setVisible(true);

	}

}
