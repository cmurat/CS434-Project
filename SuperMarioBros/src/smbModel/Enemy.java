package smbModel;

import smbModel.commands.collisionCommands.CollideEnemyCommand;

public class Enemy extends MovingEntity {
	
	private static CollideEnemyCommand command = new CollideEnemyCommand();
	
	private double prevHorizontalSpeed;
	
	public Enemy(int px, int py, Level level, String imagePath) {
		super(px, py, level, imagePath);
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
		System.out.println(horizontallyCollidedWithTile);
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}

	@Override
	public void removeFromView() {
		level.addEntitiesToDelete(this);
	}


}
