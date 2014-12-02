import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class InvadersGame extends JFrame  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InvadersGame mp = new InvadersGame();
		mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mp.setSize(1024,768);
		
		
		mp.setVisible(true);
		mp.init();
		mp.run();

	}

	private GamePanel panel;


	//sets up the GUI and Game Components
	private void init() {
		Container pane = this.getContentPane();
		panel = new GamePanel();
		
		pane.add(panel, BorderLayout.CENTER);
		//adds our game panel as the listener for keyevents
		this.addKeyListener(panel);
		
		
	}
	
	
	private void run() {
		//get the available space to draw, ie the size of the game screen without the borders
		int panelWidth  = this.getContentPane().getWidth(); 
		int panelHeight = this.getContentPane().getHeight();
		
		
		
		//starts the game
		panel.startGame(panelWidth, panelHeight);
		
		
	}


	

}
