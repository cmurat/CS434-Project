package smbModel.entities.items;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideItemCommand;
import smbModel.entities.Item;
import smbModel.entities.Tile;

public class Mushroom extends Item {
	
	private boolean firstTime = true;
	private int firstTimeCount = 0;

	public Mushroom(int px, int py, String imagePath) {
		super(px, py, imagePath);
		// TODO Auto-generated constructor stub
	}
	
	public void move() {
		if(firstTime) {
			firstTimeAnimation();
		} else {
			super.move();
		}
	}
	
	public void firstTimeAnimation() {
		int firstTimeSpeed = 2;
		if(firstTimeSpeed*firstTimeCount == Tile.BASE_SIZE) {
			firstTime = false;
		}
		changeY(-2);
		firstTimeCount++;
	}

	@Override
	protected Command getCommand() {
		return new CollideItemCommand(MUSHROOM);
	}

}
