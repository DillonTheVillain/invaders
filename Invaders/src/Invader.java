import java.awt.Point;


abstract class Invader extends Enemy {
private Point point;
private int playerSpeed=5;
private int parentWidth;
boolean lastLeft=true;
public Invader(Point point,int parentWidth, int lives) {
		super(point,parentWidth, lives);
		this.point=point;
		this.parentWidth=parentWidth;
	}
		@Override
		public void move()
		{
			if(lastLeft)
			{
				if(point.x < 1000)
				{
				point.x += (2*playerSpeed);
				}
			}
			if(point.x==1000)
			{
				lastLeft=!lastLeft;
				point.y += 20;
			}
			if (!lastLeft)
			{
				if(point.x >= 0)
				{
					point.x -= (2*playerSpeed);
				}
			}
			if(point.x==0)
			{
				lastLeft=!lastLeft;
				point.y += 20;
			}
}	
}
