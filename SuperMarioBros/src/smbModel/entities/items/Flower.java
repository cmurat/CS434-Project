package smbModel.entities.items;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideItemCommand;
import smbModel.entities.Item;
import smbModel.level.Level;

public class Flower extends Item {

	public Flower(int px, int py, Level level) {
		super(px, py, level, " ");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command getCommand() {
		
		return new CollideItemCommand(FLOWER);
	}

}
