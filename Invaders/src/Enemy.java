import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



abstract class Enemy {
	//declaring variables
	private int parentWidth;
	private int parentHeight;
	private int width;
	private int height;
	private Point position;
	private int playerSpeed =7;
	private BufferedImage img;
	boolean isActive=true;
	private int score;
	private int lives;
	private int points;
	
	public Enemy(Point point, int parentWidth) //setting enemy position
	{
		this.position = point;
	} 

public void draw(Graphics g) { //drawing enemy
		
		//draws the player image in its current position
		g.drawImage(img, position.x, position.y, width, height, null);			
	}

public int die() { //minus lives if it dies, if lives hit 0 it's not active and return the score
	lives--;
	if(lives==0){
		isActive=false;
		return points;
	}
	return 0;
	
}

public int getScore() {
	return points;
}

public Point getPosition() {
	return position;
}

public void move(){
}
}


