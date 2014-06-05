package smbModel.items;

import smbModel.Command;
import smbModel.Item;
import smbModel.Level;
import smbModel.commands.collisionCommands.CollideItemCommand;

public class Coin extends Item {

	public Coin(int px, int py, Level level) {
		super(px, py, level, "Assets/coin.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command getCommand() {
		
		return new CollideItemCommand(COIN);
	}

}
