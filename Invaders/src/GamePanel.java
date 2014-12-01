import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener{

	//his is the class where most of the game code occurs
	private Player player;

	private ArrayList<Enemy> enemyList;
	Timer redrawTimer;
	
	public GamePanel(){
		
		enemyList = new ArrayList<Enemy>();
		enemyList.add(new Martian); //Can't get my enemies added to this list
		// this starts the time that controls how often the screen is redrawn 
		redrawTimer = new Timer(10, this);
	}
	
	//method to start the game
	public void startGame(int width, int height){
		
		player = new Player(width,height);
		redrawTimer.start();
	}
	
	//method to pause the game
	public void pauseGame(){
		redrawTimer.restart();
	}
	
	
	//handles the timer event, so this method repeats based on the interval set in your timer 
	@Override
	public void actionPerformed(ActionEvent e) {	
		//causes the screen to be redrawn
		this.repaint();
	}
	
	//our paint component methiod that draws every thing we need to the screen
	public void paintComponent(Graphics g) {
		//this line ensures that every that would usually be drawn by a panel is
		super.paintComponent(g);
		//clear the screen
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//on some occasions the player has not been fully created when the panel is first drawn. 
		//The code here prevents a non existant player being drawn.
		
		if(player!= null){
			//finally draw the player
			player.draw(g);
		} 
		
		//your code for drawing the enemies should go in here. 
		//You should use a collection of type Enemy and not multiple collections of different types.
	}

		//code here controls the keyevents
		@Override
		public void keyPressed(KeyEvent event) {
			switch(event.getKeyCode())
			{
				case KeyEvent.VK_RIGHT: player.move(1); break;
				case KeyEvent.VK_LEFT: player.move(-1); break;
				case KeyEvent.VK_SPACE: player.fire(); break;
			}
			
		}
		
		//you can ignore these methods they are siple here to complete the keylistener
		@Override
		public void keyReleased(KeyEvent event) {
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}



	
}
