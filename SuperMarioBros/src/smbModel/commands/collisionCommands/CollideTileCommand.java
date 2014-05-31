package smbModel.commands.collisionCommands;

import java.awt.Point;

import smbModel.Command;
import smbModel.MovingEntity;
import smbModel.Player;

public class CollideTileCommand extends Command {

	@Override
	public void execute(MovingEntity entity) {
		Point senderLocation = sender.getLocation();
		Point entityLocation = entity.getLocation();

		double dx = senderLocation.getX() - entityLocation.getX();
		double dy = senderLocation.getY() - entityLocation.getY();

		if(entity instanceof Player) {
			System.out.println(dx + " " + dy);
		}
		
		if (Math.abs(dx) > Math.abs(dy)) {
			if (dx < 0) {
				entity.stopLeft();
			}

			if (dx > 0) {
				entity.stopRight();
			}
		}
		if (Math.abs(dx) < Math.abs(dy)) {
			if (dy < 0) {
				entity.stopUp();
				entity.changeY(1);
			}

			if (dy > 0) {
				entity.stopDown();
				entity.changeY(-1);
			}
		}
	}

}
