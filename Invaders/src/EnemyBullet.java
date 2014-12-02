import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



abstract class Enemy {
	
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
	
	public Enemy(Point point, int parentWidth)
	{
		this.position = point;
	}

public void draw(Graphics g) {
		
		//draws the player image in its current position
		g.drawImage(img, position.x, position.y, width, height, null);			
	}

public void die() {
	lives--;
	if(lives==0){
		isActive=false;
	}
	
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


