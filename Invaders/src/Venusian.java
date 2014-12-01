import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Venusian extends Invader {
	
private int points = 20;
private BufferedImage img;
private Point position = new Point(0,0);
private boolean isActive=true;
private int lives=1;
private int width;
private int height;
private int speed=5;

public Venusian(int parentWidth, int parentHeight)
{
	
	//this code loads the image for the player. The try catches are used to catch and file io error
	try {
		img = ImageIO.read(getClass().getResource("/venusian.jpg"));
		System.out.println("***************OK*******************");
	} catch (IOException e) {
		System.out.println("***************CAN'T READ FILE*******************");
		e.printStackTrace();
	}
	
	//the height and width of the player are set via the image size
	this.height = img.getHeight();
	this.width = img.getWidth();
	
	

	
}

}
