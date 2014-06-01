package smbModel.commands.collisionCommands;

import java.awt.Point;

import smbModel.Command;
import smbModel.MovingEntity;

public class CollideEnemyCommand extends Command{

	@Override
	public void execute(MovingEntity entity) {
		sender.removeFromView();
	}

}
