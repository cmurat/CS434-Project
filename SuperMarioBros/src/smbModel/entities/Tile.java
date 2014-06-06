package smbModel.entities;

import smbModel.Command;
import smbModel.Entity;
import smbModel.commands.collisionCommands.CollideTileCommand;
import smbModel.level.Level;


public class Tile extends Entity{
	
	private static CollideTileCommand command = new CollideTileCommand();
	public Tile(int row, int column, String imagePath) {
		super(row, column, imagePath);
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}
}
