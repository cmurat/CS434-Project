package smbModel;

import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

import smbModel.commands.collisionCommands.CollideTileCommand;
import smbModel.tiles.BlankTile;
import smbModel.tiles.Brick;
import smbModel.tiles.Floor;

public abstract class MovingEntity extends Entity {
	public static final double ACCELERATION = 0.24;
	public static final double MAX_SPEED = 8;

	protected Level level;
	protected double horizontalSpeed;
	protected double verticalSpeed;
	protected double horizontalAcceleration;
	protected double verticalAcceleration;

	protected boolean canGoDown = false;
	protected boolean jumping = false;
	protected boolean idle = true;
	protected boolean pressedUp = false;
	
	protected boolean continueHorizontally = false;
	protected boolean horizontallyCollidedWithTile = false;

	protected int count = 0;
	protected Point prevLocation = new Point(0, 0);

	public MovingEntity(int row, int column, Level level, String imagePath) {
		super(row, column, imagePath);
		setLevel(level);
	}
	
	public void move() {
		checkCollision();
		checkDown();
		normalizeHorizontalSpeed();
		normalizeVerticalSpeed();
		changeX(horizontalSpeed);
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

	private void checkDown() {
		Rectangle stepDownRectangle = new Rectangle(bounds.x, bounds.y
				+ bounds.height, bounds.width, (int) MAX_SPEED / 2);
		ArrayList<Tile> tiles = level.getRespectiveTiles(stepDownRectangle
				.getLocation());
		boolean intersects = false;
		for (Tile tile : tiles) {
			intersects = intersects || tile.intersects(stepDownRectangle);
		}
		canGoDown = !intersects;
		if (!canGoDown) {
			jumping = false;
		}

	}

	public void normalizeVerticalSpeed() {
		if (pressedUp) {
			verticalSpeed = -MAX_SPEED;
			pressedUp = false;
		}

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

		if (!continueHorizontally && idle
				&& (horizontalSpeed < ACCELERATION && horizontalSpeed > -ACCELERATION)) {
			horizontalSpeed = 0;
			horizontalAcceleration = 0;
		}
	}

	public void goUp() {
		verticalAcceleration = -ACCELERATION;
		pressedUp = true;
		canGoDown = true;
	}

	public void goDown() {
		verticalAcceleration = ACCELERATION;
	}

	public void goLeft() {
		horizontalAcceleration = -ACCELERATION;
		idle = false;
	}

	public void goRight() {
		horizontalAcceleration = ACCELERATION;
		idle = false;
	}
	
	public void decelerateHorizontally(){
		if(Math.abs(horizontalSpeed + horizontalAcceleration) > Math.abs(horizontalSpeed)) {
			horizontalAcceleration *= -1;
		}
		idle = true;
	}

	public void decelerateUp() {
		if (verticalSpeed < 0) {
			verticalAcceleration = ACCELERATION;
			idle = true;
		}
	}

	public void decelerateDown() {
		if (verticalSpeed > 0) {
			verticalAcceleration = -ACCELERATION;
			idle = true;
			jumping = false;
		}
	}

	public void stopRight() {
		if (horizontalSpeed > 0) {
			horizontalSpeed = 0;
			horizontalAcceleration = 0;
			idle = true;
			horizontallyCollidedWithTile = true;
		}
	}

	public void stopLeft() {
		if (horizontalSpeed < 0) {
			horizontalSpeed = 0;
			horizontalAcceleration = 0;
			idle = true;
			horizontallyCollidedWithTile = true;
		}
	}

	public void stopUp() {
		if (verticalSpeed < 0) {
			verticalSpeed = 0;
			verticalAcceleration = 0;
			idle = true;
		}
	}

	public void stopDown() {
		if (verticalSpeed > 0) {
			verticalSpeed = 0;
			verticalAcceleration = 0;
			idle = true;
			jumping = false;
		}
	}

	public void setLevel(Level level) {
		this.level = level;
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
}
