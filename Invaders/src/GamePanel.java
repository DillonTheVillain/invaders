import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Random rnd = new Random();
	private int width;
	private int height;

	//his is the class where most of the game code occurs
	private Player player;

	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); //Adding the enemies to the game in rows with for loops at a new point for each.
;
	Timer redrawTimer, enemyTimer, enemyShoot;
	
	public GamePanel(){
		// this starts the time that controls how often the screen is redrawn 
		redrawTimer = new Timer(10, this);
		
		enemyTimer = new Timer((rnd.nextInt(10)*100), this);
		enemyShoot = new Timer((rnd.nextInt(10)*2000), this);
		
		redrawTimer.start();
		enemyTimer.start();
		
	}
	
	//method to start the game
	public void startGame(int width, int height){
		
		this.width=width;
		this.height=height;
		player = new Player(width,height);
		for (int i = 0; i < 6; i++) {
			enemyList.add(new Martian(new Point(((i * 150) + 10), 200), width));
		}
		for (int i = 0; i < 6; i++) {
			enemyList.add(new Venusian(new Point(((i * 150) + 10), 10), width));
		}
		for (int i = 0; i < 6; i++) {
			enemyList.add(new Mercurian(new Point(((i * 150) + 10), 100), width));
		}

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
		
		
		if (e.getSource() == enemyTimer){
			System.out.println("OK timer works");
		Random randomGen = new Random();
		// random number gen decides whether to spawn which one, 80% chance of meteor, 20% destroyer
		int rand = randomGen.nextInt(5);

			
		if (rand <= 3) {
			enemyList.add(new Meteor(width,height, null)); 
		}
			else if (rand > 3) {
			enemyList.add(new Destroyer(width,height, null)); // 
		
		}
		enemyTimer.restart();
}
	if (e.getSource() == enemyShoot){
			//Enemy.Martian.shoot;//needs changing!
			
		}
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
		
			for(int i=0;i<enemyList.size();i++)
			{
				while(enemyList.get(i).isActive)
				{
				enemyList.get(i).move();
				enemyList.get(i).draw(g);
				}
				if(!enemyList.get(i).isActive)
				{
				enemyList.remove(i);
				}
			}
		
			if (enemyList.isEmpty())
			{
				
			enemyList.add(new Mothership(new Point(10,10), width));
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


		
