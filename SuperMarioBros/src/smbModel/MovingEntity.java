package smbModel;

import java.util.ArrayList;

import smbModel.tiles.BlankTile;

public abstract class MovingEntity extends Entity {
	public static final double ACCELERATION = 0.02;
	public static final double MAX_SPEED = 0.02;
	
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;
	public static final int LEFT = 4;
	
	private double speed;
	protected Level level;
	protected double horizontalSpeed;
	protected double verticalSpeed;
	protected double horizontalAcceleration;
	protected double verticalAcceleration;

	public MovingEntity(int row, int column, Level level, String imagePath) {
		super(row, column, imagePath);
		setLevel(level);
	}

	public void checkCollision() {
		ArrayList<MovingEntity> entities = level.getEntities();
		for (MovingEntity movingEntity : entities) {
			if (movingEntity.intersects(bounds)) {
				movingEntity.collide().execute(this);
			}
		}

		ArrayList<Tile> tiles = level.getRespectiveTiles(getLocation());

		for (Tile tile : tiles) {
			if (tile.intersects(bounds)) {
				tile.collide().execute(this);
			}
		}
	}

	public void move() {
		checkCollision();
		normalizeHorizontalSpeed();
		normalizeVerticalSpeed();
		changeX(horizontalSpeed);
		changeY(verticalSpeed);
	}
	
	public void normalizeVerticalSpeed() {
		if (verticalSpeed >= -MAX_SPEED && verticalSpeed <= MAX_SPEED)
			verticalSpeed += verticalAcceleration;
		else
			verticalAcceleration = 0;
		

		if (verticalSpeed < 0 ){
			verticalSpeed = 0;
		}
			
		if (verticalSpeed > MAX_SPEED) {
			verticalSpeed = MAX_SPEED;
		}
	}

	public void normalizeHorizontalSpeed() {
		System.out.println(horizontalAcceleration);
		System.out.println(horizontalSpeed);
		if (horizontalSpeed >= 0 && horizontalSpeed <= MAX_SPEED)
			horizontalSpeed += horizontalAcceleration;
		else
			horizontalAcceleration = 0;
		

		if (horizontalSpeed < 0){
			horizontalSpeed = 0;
		}
			
		if (horizontalSpeed > MAX_SPEED) {
			horizontalSpeed = MAX_SPEED;
		}
	}
	
	public void goUp() {
		verticalAcceleration = -ACCELERATION;
	}

	public void goDown() {
		verticalAcceleration = ACCELERATION;
	}

	public void goLeft() {
		horizontalAcceleration = -ACCELERATION;
	}

	public void goRight() {
		horizontalAcceleration = ACCELERATION;
	}

	public void stopLeft() {
		if (horizontalAcceleration < 0) {
			goRight();
		}
	}

	public void stopRight() {
		if (horizontalAcceleration > 0) {
			goLeft();
		}
	}

	public void stopUp() {
		if (verticalSpeed < 0) {
			verticalSpeed = 0;
		}
	}

	public void stopDown() {
		if (verticalSpeed > 0) {
			verticalSpeed = 0;
		}
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
		String str = "Position x: " + getX() + "\n" + "Position y: " + getY()
				+ "\n";
		return str;
	}

}
