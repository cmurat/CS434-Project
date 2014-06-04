package smbModel.items;

import smbModel.Command;
import smbModel.Item;
import smbModel.Level;
import smbModel.commands.collisionCommands.CollideItemCommand;

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
