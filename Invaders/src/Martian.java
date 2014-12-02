import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;


public class Martian extends Invader{
	private ArrayList<EnemyBullet> bulletList;
	private int points = 40;
	private BufferedImage img;
	private Point position = new Point(0,0);
	private boolean isActive=true;
	private int lives=1;
	private int width;
	private int height;
	private int speed=5;

	public Martian(Point point,int parentWidth)
	{
		super(point,parentWidth);
		//this code loads the image for the player. The try catches are used to catch and file io error
		try {
			img = ImageIO.read(getClass().getResource("/martian.jpg"));
			System.out.println("***************OK*******************");
		} catch (IOException e) {
			System.out.println("***************CAN'T READ FILE*******************");
			e.printStackTrace();
		}
		
		//the height and width of the player are set via the image size
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.position=point;
		
		bulletList = new ArrayList<EnemyBullet>();
	}
public void draw(Graphics g) {
		
		//draws the player image in its current position
		g.drawImage(img, position.x, position.y, width, height, null);			
	}
public void shoot(){
	bulletList.add(new EnemyBullet(new Point(position.x+(width/2), position.y)));
}

//this returns a specific player bullet
public EnemyBullet getBullet(int i){
	return bulletList.get(i);
	
}
//this returns the current number of bullets
public int getBulletCount(){
	return bulletList.size();
}
}
