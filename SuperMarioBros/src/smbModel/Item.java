 package smbModel;

public class Item extends MovingEntity {

	public Item(int px, int py, Level level, String imagePath) {
		super(px, py, level,imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collide(MovingEntity movingEntity) {
		
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
