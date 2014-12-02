
public interface canShoot {
private ArrayList<EnemyBullet> bulletList;
bulletList = new ArrayList<EnemyBullet>();

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
