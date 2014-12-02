
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Meteor extends Enemy {
	
	private Point position;
	private BufferedImage img;
	private int parentWidth;
	private int parentHeight;
	private int playerSpeed;
	private int width;
	private int height;
	private int lives=1;
	private int score=100;
	Random rnd = new Random();
	
	public Meteor(int parentWidth, int parentHeight,Point point, int lives)
	{
		super(point,parentWidth, lives);
		try {
			img = ImageIO.read(getClass().getResource("/Space-invaders.jpg"));//Change to Meteor sprite
			System.out.println("***************OK*******************");
		} catch (IOException e) {
			System.out.println("***************CAN'T READ FILE*******************");
			e.printStackTrace();
		}
		
		//the height and width of the player are set via the image size
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.parentWidth=parentWidth;
		this.parentHeight=parentHeight;
		this.position.y=0;
		this.position.x = rnd.nextInt(parentWidth)+1;
		point=this.position;
	}
	
	public int die() //when hit take away a life, if lives hit zero set active to flase and return the score
		{
			lives--;
			if(lives==0){
			active=false;
			return score;
			}
			return 0;
			
		}
	
	
		@Override
		public void move(){
			
			if(position.y != parentHeight)
			{
				this.position.y += (10*playerSpeed);
			}
	}
}

