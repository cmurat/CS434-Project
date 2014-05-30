package smbModel;

import java.util.ArrayList;

import smbModel.players.Mario;

public abstract class MovingEntity extends Entity{
	private double speed;
	private Level level;

	public MovingEntity(int row, int column, Level level, String imagePath) {
		super(row, column, imagePath);
		setLevel(level);
	}
	
	public void  checkCollision(){
		ArrayList<MovingEntity> entities = level.getEntities();
		for(MovingEntity movingEntity : entities){
			if(movingEntity.intersects(bounds)){
				collide(movingEntity);
			}
		}
		
	}
	
	public abstract void collide(MovingEntity movingEntity);
	public abstract void collideWithPlayer();
	public abstract void collideWithEnemy();
	public abstract void collideWithTile();
	
	public void move() {
		
	}

	private void move(double horizontalSpeed, double verticalSpeed) {
		changeX(horizontalSpeed);
		changeY(verticalSpeed);
	}
	public void moveUp() {
		move(0, speed);
	}
	
	public void moveDown() {
		move(0, -speed);
	}

	public void moveLeft() {
		move(-speed, 0);
	}

	public void moveRight() {
		move(speed , 0);

	}

	public double getSpeed() {
		return speed;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	protected double setSpeed(double speed) {
		return this.speed = speed;
	}

	public double getX() {
		return super.getX();
	}

	public double getY() {
		return super.getY();
	}

	public String toString() {
		String str = "Position x: " + getX() + "\n" + "Position y: " + getY() + "\n";
		return str;
	}
	
}
