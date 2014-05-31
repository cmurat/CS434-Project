package smbModel;

import java.util.ArrayList;

import smbModel.tiles.BlankTile;

public abstract class MovingEntity extends Entity {
	private double speed;
	private Level level;
	protected double horizontalSpeed;
	protected double verticalSpeed;
	int count = 0;

	public MovingEntity(int row, int column, Level level, String imagePath) {
		super(row, column, imagePath);
		setLevel(level);
	}

	public void checkCollision() {
		ArrayList<MovingEntity> entities = level.getEntities();
		for (Entity movingEntity : entities) {
			if (movingEntity.intersects(bounds)) {
				collide().execute(this);
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
		changeX(horizontalSpeed);
		changeY(verticalSpeed);
	}

	public void goUp() {
		verticalSpeed = -speed;
	}

	public void goDown() {
		verticalSpeed = speed;
	}

	public void goLeft() {
		horizontalSpeed = -speed;
	}

	public void goRight() {
		horizontalSpeed = speed;
	}

	public void stopLeft() {
		if (horizontalSpeed < 0) {
			horizontalSpeed = 0;
		}
	}

	public void stopRight() {
		if (horizontalSpeed > 0) {
			horizontalSpeed = 0;
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
