import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Bullet {
	
	private Point position;
	private int height, width;
	private BufferedImage img;
	private int speed = 20;
	private boolean active;

	
	public Bullet(Point playerPosition){
		
		//same as the player class this simply loads the image for the bullet.
		try {
			img = ImageIO.read(getClass().getResource("/playerbullet.jpg"));
			//System.out.println("***************OK*******************");
		} catch (IOException e) {
			//System.out.println("***************CAN'T READ FILE*******************");
			e.printStackTrace();
		}
		
		height = img.getHeight();
		width = img.getWidth();
		
		//sets the bullet position we have to do a little offset wit the bullet image so our bullet appears in the (horizontal) centre of our player
		position = new Point(playerPosition.x - (width/2), playerPosition.y);
		
		active = true;
	}
	
	//draws the bullet
	public void draw(Graphics g) {
	
		g.drawImage(img, position.x, position.y, width, height, null);
		
	}
	
	//moves the bullet unless it has gone off the top of the screen in which case the bullet is destroyed
	public void move(){
		if(position.y < 0){
			destroy();
		}
		else{
			position.y-=speed;
		}
		
	}
	
	
	
	//sets the bullet as inactive
	public void destroy(){
		active = false;
	}
	
	//returns whether the bullet is active or not
	public boolean isActive(){
		return active;
	}

	//returns the bullets current position
	public Point getPosition() {
		// TODO Auto-generated method stub
		return position;
	}
	
	// this method will flag as an error until you create your enemy classes
	public void detectCollision(Enemy e)
//	{
//		
		//checks if meteor has been hit by anything
		if(e instanceof Meteor){
			if (position.x <= (e.getPos().x + 50)
					&& position.x >= e.getPos().x && e.isActive() == true) {
				if (position.y <= (e.getPos().y + 50)
						&& position.y >= e.getPos().y) {
					die();
				}
			}
		}
		// checks if bosses have been hit by anything
		if (e instanceof Bosses) {
			if (position.x <= (e.getPos().x + 100)
					&& position.x >= e.getPos().x && e.isActive() == true) {
				if (position.y <= (e.getPos().y + 68)
						&& position.y >= e.getPos().y) {
				die();
				}
			}

		} else { //normal invaders
			if (position.x <= (e.getPos().x + 50) && position.x >= e.getPos().x
					&& e.isActive() == true) {
				if (position.y <= (e.getPos().y + 50)
						&& position.y >= e.getPos().y) {
				die();
				}
			}
		}
//	}
	
	

}
