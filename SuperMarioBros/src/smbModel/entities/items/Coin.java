package smbModel.entities.items;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideItemCommand;
import smbModel.entities.Item;
import smbModel.level.Level;

public class Coin extends Item {

	public Coin(int px, int py) {
		super(px, py, "Assets/coin.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command getCommand() {
		
		return new CollideItemCommand(COIN);
	}

}
