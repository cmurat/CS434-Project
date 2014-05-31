package smbModel;

import smbModel.commands.collisionCommands.CollideEnemyCommand;

public class Enemy extends MovingEntity {
	
	private static CollideEnemyCommand command = new CollideEnemyCommand();
	
	public Enemy(int px, int py, Level level, String imagePath) {
		super(px, py, level, imagePath);
		setSpeed(1);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		goLeft();
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}


}
