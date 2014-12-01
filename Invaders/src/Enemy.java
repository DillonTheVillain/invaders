import java.awt.Point;
import java.awt.image.BufferedImage;


abstract class Enemy {
	
	private int parentWidth;
	private int parentHeight;
	private int width;
	private int height;
	private Point position;
	private int playerSpeed =7;
	private BufferedImage img;
	private boolean active =true;
	private int score;
	
	try {		
		img = ImageIO.read(getClass().getResource("/Space-invaders.jpg"));//change sprite
		System.out.println("***************OK*******************");
		} catch (IOException e) {
		System.out.println("***************CAN'T READ FILE*******************");
		e.printStackTrace();
		}
	
				
		//the height and width of the player are set via the image size
		this.height = img.getHeight();
		this.width = img.getWidth();
				
		//this is the height and width of the game screen, passed through from or main application
		this.parentHeight = parentHeight;
		this.parentWidth = parentWidth;
				
		//we set the player to initially appear in the middle (Horizontally) 
		//and at the bottom (vertically) of the game screen 
		this.position = new Point(parentWidth/2,parentHeight - this.height);
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

	public void move()
		{
			while(isActive())
			{
				while (position.x != parentWidth)//Might be other way round
				{
				position.x += position.x;
				}
				position.y -= position.y;
				while (position.x != 0)
				{
				position.x -= position.x;
				}
			}
		}
}
