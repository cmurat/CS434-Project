package smbModel.entities;

import java.util.Random;

import smbModel.Command;
import smbModel.level.Level;

public abstract class Item extends MovingEntity {

	public static final int MUSHROOM = 1;
	public static final int COIN = 2;
	public static final int FLOWER = 3;
	public static final int STAR = 4;

	private double prevHorizontalSpeed;
	public Item(int px, int py, String imagePath) {
		super(px, py, imagePath);
		horizontalSpeed = MAX_SPEED / 4;
		continueHorizontally = true;
	}

	public void move() {
		prevHorizontalSpeed = horizontalSpeed;
		super.move();
		if (horizontallyCollidedWithTile) {
			horizontalSpeed = -prevHorizontalSpeed;
			changeX(horizontalSpeed);
			horizontallyCollidedWithTile = false;
		}
	}

	@Override
	public Command collide() {
		Command command = getCommand();
		command.setSender(this);
		return command;
	}

	protected abstract Command getCommand();

	@Override
	public void removeFromView() {
		level.addEntitiesToDelete(this);

	}
}
