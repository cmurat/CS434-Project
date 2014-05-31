package smbModel.tiles;

import smbModel.Command;
import smbModel.Tile;
import smbModel.commands.collisionCommands.EmptyCollisionCommand;

public class BlankTile extends Tile{
	
	private static final String IMAGE_PATH = "";
	private static EmptyCollisionCommand command = new EmptyCollisionCommand();
	
	public BlankTile(int row, int column) {
		super(row, column, IMAGE_PATH);
	}
	
	public Command collide() {
		return command;
	}

	public String toString() {
		return "n";
	}
}
