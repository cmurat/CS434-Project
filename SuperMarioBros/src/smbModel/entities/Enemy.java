package smbModel.entities;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideEnemyCommand;
import smbModel.level.Level;

public class Enemy extends MovingEntity {
	
	private static CollideEnemyCommand command = new CollideEnemyCommand();
	
	private double prevHorizontalSpeed;
	
	public Enemy(int px, int py, String imagePath) {
		super(px, py, imagePath);
		horizontalSpeed = -MAX_SPEED/4;
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
		command.setSender(this);
		return command;
	}
}
