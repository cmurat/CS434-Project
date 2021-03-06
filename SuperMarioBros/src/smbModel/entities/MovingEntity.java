package smbModel.entities;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import smbModel.Entity;

public abstract class MovingEntity extends Entity {
	public static final double ACCELERATION = 0.25;
	public static final double MAX_SPEED = 8;

	protected double horizontalSpeed;
	protected double verticalSpeed;
	protected double horizontalAcceleration;
	protected double verticalAcceleration;

	protected boolean canGoDown = false;
	protected boolean jumping = false;
	protected boolean idle = true;

	protected boolean continueHorizontally = false;
	protected boolean horizontallyCollidedWithTile = false;

	public HorizontalDirection horizontalDirection;

	protected int count = 0;
	protected Point prevLocation = new Point(0, 0);

	public MovingEntity(int row, int column, String imagePath) {
		super(row, column, imagePath);
		horizontalDirection = HorizontalDirection.Idle;
	}

	public void move() {
		checkCollision();
		checkDown();
		normalizeHorizontalSpeed();
		normalizeVerticalSpeed();
		changeX(horizontalSpeed + level.getPlayerOffset());
		changeY(verticalSpeed);
	}

	public void checkCollision() {
		ArrayList<MovingEntity> entities = level.getEntities();
		for (MovingEntity movingEntity : entities) {
			if (movingEntity.intersects(bounds)
					&& movingEntity.bounds != bounds) {
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

	protected void checkDown() {
		Rectangle stepDownRectangle = new Rectangle(bounds.x, bounds.y
				+ bounds.height, bounds.width, (int) MAX_SPEED / 2);
		ArrayList<Tile> tiles = level.getRespectiveTiles(stepDownRectangle
				.getLocation());
		boolean intersects = false;
		for (Tile tile : tiles) {
			intersects = intersects || tile.intersects(stepDownRectangle);
		}
		canGoDown = !intersects;
		jumping = !intersects;
		System.out.println(bounds + " " + tiles.size());
	}

	public void normalizeVerticalSpeed() {
		if (canGoDown) {
			verticalSpeed += ACCELERATION;
		} else if (verticalSpeed > 0) {
			verticalSpeed = 0;
		}

		if (verticalSpeed > MAX_SPEED) {
			verticalSpeed = MAX_SPEED;
		}

		if (verticalSpeed < -MAX_SPEED) {
			verticalSpeed = -MAX_SPEED;
		}

	}

	public void normalizeHorizontalSpeed() {
		if (horizontalSpeed >= -MAX_SPEED && horizontalSpeed <= MAX_SPEED) {
			horizontalSpeed += horizontalAcceleration;
		} else if (horizontalSpeed > 0) {
			horizontalSpeed = MAX_SPEED;
		} else {
			horizontalSpeed = -MAX_SPEED;
		}

		if (!continueHorizontally
				&& horizontalDirection == HorizontalDirection.Idle
				&& (horizontalSpeed < ACCELERATION && horizontalSpeed > -ACCELERATION)) {
			horizontalSpeed = 0;
			horizontalAcceleration = 0;
		}
	}

	public void goUp() {
		verticalSpeed = -MAX_SPEED;
	}

	public void goDown() {
		verticalAcceleration = ACCELERATION;
	}

	public void goLeft() {
		horizontalAcceleration = -ACCELERATION;
		horizontalDirection = HorizontalDirection.Left;
	}

	public void goRight() {
		horizontalAcceleration = ACCELERATION;
		horizontalDirection = HorizontalDirection.Right;
	}

	public void decelerateHorizontally() {
		if (Math.abs(horizontalSpeed + horizontalAcceleration) > Math
				.abs(horizontalSpeed)) {
			horizontalAcceleration *= -1;
		}
		horizontalDirection = HorizontalDirection.Idle;
	}

	public void decelerateVertically() {
		if (Math.abs(verticalSpeed + verticalAcceleration) > Math
				.abs(verticalSpeed)) {
			verticalAcceleration *= -1;
		}

		if (verticalAcceleration < 0) {
			jumping = false;
		}
	}

	public void stopHorizontally() {
		horizontalSpeed = 0;
		horizontalAcceleration = 0;
		horizontallyCollidedWithTile = true;
		horizontalDirection = HorizontalDirection.Idle;
	}

	public void stopVertically() {
		if (verticalSpeed > 0) {
			jumping = false;
		}
		verticalSpeed = 0;
		verticalAcceleration = 0;
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

	public void setCanGoDown(boolean cannotGoDown) {
		this.canGoDown = cannotGoDown;
	}

	public boolean getCanGoDown() {
		return canGoDown;
	}

	public boolean isHorizontallyCollidedWithTile() {
		return horizontallyCollidedWithTile;
	}

	public void setHorizontallyCollidedWithTile(boolean collidedWithTile) {
		this.horizontallyCollidedWithTile = collidedWithTile;
	}

	public boolean isIdle() {
		return idle;
	}

	public boolean isJumping() {
		return jumping;
	}
}
