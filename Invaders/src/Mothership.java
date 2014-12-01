
public class Mothership extends Boss implements canShoot{

private int points = 100;
private int lives = 3;
private int speed = 7;

public void die(){
  if (lives==0)
  {
    active=false;
    return points;
  }
}

public void move()
		{
			while(isActive=true)
			{
				if (position.x >= parentWidth);
				{
				position.x -= (10*speed);
				speed++
				}
				position.y -= (10*speed);
				if(position.x <= 0)
				{
				position.x += (10*speed);
				speed++
				}
				position.y -= (10*speed);
			}
		}

public void shoot(){
			bulletList.add(new EnemyBullet(new Point(position.x+(width/2), position.y)));
		}
		
		public EnemyBullet getBullet(int i){
			return bulletList.get(i);
			
		}
		
		public int getBulletCount(){
			return bulletList.size();
		}
		
}
