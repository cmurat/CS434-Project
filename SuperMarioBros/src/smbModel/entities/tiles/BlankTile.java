package smbModel.entities.tiles;

import java.awt.Rectangle;

import smbModel.Command;
import smbModel.commands.collisionCommands.EmptyCollisionCommand;
import smbModel.entities.Tile;

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
	
	public boolean intersects(Rectangle r){
		return false;
	}
}
