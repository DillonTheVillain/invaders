
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
