package smbModel.commands.collisionCommands;

import smbModel.commands.CollideCommand;
import smbModel.entities.Player;

public class CollideTileCommand extends CollideCommand {

	@Override
	protected void leftCollision() {
		receiver.stopHorizontally();
		receiver.changeX((dx + sender.getBounds().getWidth()));
	}

	@Override
	protected void rightCollision() {
		receiver.changeX((dx - receiver.getBounds().getWidth()));
		receiver.stopHorizontally();
	}

	@Override
	protected void upCollision() {
		if (receiver instanceof Player) {
			sender.removeFromView();
		}
		receiver.stopVertically();
		receiver.changeY(dy + sender.getBounds().getHeight());

	}

	@Override
	protected void downCollision() {
		receiver.stopVertically();
		receiver.setCanGoDown(false);
		receiver.changeY(dy - receiver.getBounds().getHeight());
	}

}
