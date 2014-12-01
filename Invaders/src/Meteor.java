import java.awt.Graphics;
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
	Random rnd = new Random();
	
	public Meteor(int parentWidth, int parentHeight, int playerSpeed, int score)
	{
		super(parentWidth,parentHeight,playerSpeed,score,isActive());//check isActive
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
		
		this.position.x = rnd.nextInt(parentWidth)+1;
	}
	
	
		@Override
		public void move(){
			
			if(position.y != parentHeight)
			{
				this.position.y += (10*playerSpeed);
			}
			else
			{
				Player.die();//Only works if lives + methods are static. Maybe change to check position, then kill player.
				setActive(false);
			}
	}
}

