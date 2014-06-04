package smbModel.items;

import smbModel.Command;
import smbModel.Item;
import smbModel.Level;
import smbModel.commands.collisionCommands.CollideItemCommand;

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
