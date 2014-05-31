 package smbModel;

import smbModel.commands.collisionCommands.CollideItemCommand;

public class Item extends MovingEntity {

	private static CollideItemCommand command = new CollideItemCommand();
	
	public Item(int px, int py, Level level, String imagePath) {
		super(px, py, level,imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}
}
