import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Timer;
import javax.imageio.ImageIO;

//Destroyer extending boss class and implementing the canshoot interface
public class Destroyer extends Boss implements ActionListener, canShoot {
	
	//Setting up the variables and initilising timer for cloaking
	private int parentWidth;
	private int parentHeight;
	private int width;
	private int height;
	private Point position;
	private int lives=2;
	private BufferedImage img;
	private int playerSpeed =5;
	private int score =200;
	private boolean active=false;
	private boolean cloak = false;
	Random rnd=new Random();
	Timer cloakTimer = new Timer (2000,this);
	
	public Destroyer(int parentWidth,int parentHeight,Point point, int lives)
	{
		super(point,parentWidth,lives);
		active=true;
		try {
			img = ImageIO.read(getClass().getResource("/Space-invaders.jpg"));
			System.out.println("***************OK*******************");
		} catch (IOException e) {
			System.out.println("***************CAN'T READ FILE*******************");
			e.printStackTrace();
		}
		
		this.height = img.getHeight();
		this.width = img.getWidth();
		
		this.parentWidth=parentWidth;
		this.parentHeight=parentHeight;
		
		this.position.x=0;
		this.position.y = rnd.nextInt(parentHeight)+100;
		point=this.position;
		cloakTimer.start();
	}

		public void actionPerformed(ActionEvent e) { //Checks if the timer has finished and if it has it switches cloak
			{
				
				if (e.getSource() == cloakTimer){
				cloak=!cloak;
				}}
			}
		
public void draw(Graphics g) {
			
			if(!cloak) //Only draw if not cloaked
			{
			//draws the Destroyer image in its current position if not cloaked
			g.drawImage(img, position.x, position.y, width, height, null);
			}
}
		
		public int kill() //when hit take away a life, if lives hit zero set active to flase and return the score
		{
			lives--;
			if(lives==0){
			active=false;
			return score;
			}
			return 0;
			
		}
		
	
		
		public void move(){ //moving destroyer along x as long as it's within the parentwidth
			if(position.x != this.parentWidth)
			{
				
				this.position.x += (10*playerSpeed);
			}
			else
			{
				active=false;
			}
		}

	
		

		

		
}
