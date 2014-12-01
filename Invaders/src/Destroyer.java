import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;


public class Destroyer extends Boss {
	
	private ArrayList<EnemyBullet> bulletList;
	private int parentWidth;
	private int parentHeight;
	private int width;
	private int height;
	private Point position;
	private BufferedImage img;
	private int playerSpeed =5;
	final int score =200;
	private boolean active=false;
	Random rnd=new Random();
	
	public Destroyer(int parentWidth, int parentHeight)
	{
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
		
		this.position = new Point(0,rnd.nextInt(parentHeight)+1);
	}
		
		public void draw(Graphics g) {
			
			//draws the player image in its current position
			g.drawImage(img, position.x, position.y, width, height, null);
			
			//this code uses an iterator to run through the bullets, if a bullet has bee maked as inactive it is removed,
			//otherwise the bullets move and draw methods are called to update it on the screen
			Iterator<EnemyBullet> iterator = bulletList.iterator();
			while (iterator.hasNext()) {
			    EnemyBullet b = iterator.next();
			    
			    if(b!=null && b.isActive()){
			    	b.move();
			    	b.draw(g);
			    }
			    else{
			    	iterator.remove();
			    }
			}
			
		}
		
		public int kill()
		{
			active=false;
			return score;
		}
		
		public void fire(){
			bulletList.add(new EnemyBullet(new Point(position.x+(width/2), position.y)));
		}
		
		public EnemyBullet getBullet(int i){
			return bulletList.get(i);
			
		}
		
		public int getBulletCount(){
			return bulletList.size();
		}
		
		public void move(){
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
