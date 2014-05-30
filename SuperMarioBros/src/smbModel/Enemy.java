package smbModel;

public class Enemy extends MovingEntity {
	public Enemy(int px, int py, Level level, String imagePath) {
		super(px, py, level, imagePath);
		setSpeed(2);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		moveLeft();
	}

	@Override
	public void collide(MovingEntity movingEntity) {
		movingEntity.collideWithEnemy();
		
	}

	@Override
	public void collideWithPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithEnemy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithTile() {
		// TODO Auto-generated method stub
		
	}



}
