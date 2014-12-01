import java.awt.Point;
import java.awt.image.BufferedImage;


abstract class Enemy {
	
	private BufferedImage img;
	private Point position = new Point(0,0);
	private boolean isActive=true;
	private int points;
	private int lives;

	public void die() {
		lives--;
		if(lives==0){
			isActive=false;
		}
		
	}
	
	public int getScore() {
		return points;
		
	}
	
	//public Point getPosition() {
	//	return position;
	//}

	public void move(int x, int y)
	{
		position.x=0;
		position.y=0;
		while(isActive=true)
		{
		
			for(int y1=0; y1<12; y1++){
		
	for(position.x=0; position.x<300; position.x++){
		
		
		}
	position.x=0;
	position.y--;
			}
	
		}
	}
	
	


	public void update()
	{
		
	}
}
