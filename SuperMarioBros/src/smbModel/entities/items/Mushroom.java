package smbModel.entities.items;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideItemCommand;
import smbModel.entities.Item;
import smbModel.level.Level;

public class Mushroom extends Item {

	public Mushroom(int px, int py, Level level, String imagePath) {
		super(px, py, level, imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command getCommand() {
		
		return new CollideItemCommand(MUSHROOM);
	}

}
