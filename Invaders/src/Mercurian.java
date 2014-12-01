import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Mercurian extends Invader implements canCloak {

private int points = 40;
private BufferedImage img;
private Point position = new Point(0,0);
private boolean isActive=true;
private int lives=1;
private int width;
private int height;
private int speed=5;
private boolean cloak = false;
Random rnd=new Random();
timer cloakTime = new Timer (2000,this)




public Mercurian(int parentWidth, int parentHeight)
{
	
	//this code loads the image for the player. The try catches are used to catch and file io error
	try {
		img = ImageIO.read(getClass().getResource("/mercurian.jpg"));
		System.out.println("***************OK*******************");
	} catch (IOException e) {
		System.out.println("***************CAN'T READ FILE*******************");
		e.printStackTrace();
	}
	
	//the height and width of the player are set via the image size
	this.height = img.getHeight();
	this.width = img.getWidth();
	cloakTime.start();
	}
		public void actionPerformed(ActionEvent e) {
			{
				if (e.getSource() == cloakTimer){
				cloak=!cloak;
				}
			}
			
		public void draw(Graphics g) {
			
			if(!cloak)
			{
			//draws the Destroyer image in its current position if not cloaked
			g.drawImage(img, position.x, position.y, width, height, null);
			}
			
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
		
