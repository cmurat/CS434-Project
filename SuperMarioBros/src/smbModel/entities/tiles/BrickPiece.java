package smbModel.entities.tiles;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideTileCommand;
import smbModel.commands.collisionCommands.EmptyCollisionCommand;
import smbModel.entities.MovingEntity;

public class BrickPiece extends MovingEntity {
	private static final String IMAGE_PATH2 = "Assets/brickPiece.png";
	private static EmptyCollisionCommand command = new EmptyCollisionCommand();
	BrickPiece(int row, int column, String imagePath) {
		super(row, column, IMAGE_PATH2);

	}

	public void checkDown(){
		canGoDown = true;
	}
	@Override
	public Command collide() {
		return command;
	}

	public void setSpeed(int v, int h) {
		horizontalSpeed = h;
		verticalSpeed = v;
	}
}
