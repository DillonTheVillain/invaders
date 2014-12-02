import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Mothership extends Boss{

private int points = 100;
private int lives = 3;
private int speed = 7;
private int width;
private int height;
private BufferedImage img;
private Point position;
private int parentWidth;
private boolean isActive = false;

public Mothership(Point point,int parentWidth){
	super(point, parentWidth);
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
			this.position.x=0;
			this.position.y=0;
			this.parentWidth = parentWidth;
			point=this.position;
}
			public int kill()
			{
				lives--;
				if(lives==0){
				isActive=false;
				return points;
				}
				return 0;
				
			}

public void move()
		{
			while(isActive=true)
			{
				if (position.x >= parentWidth);
				{
				position.x -= (10*speed);
				speed++;
				}
				position.y -= (10*speed);
				if(position.x <= 0)
				{
				position.x += (10*speed);
				speed++;
				}
				position.y -= (10*speed);
			}
		}
}

