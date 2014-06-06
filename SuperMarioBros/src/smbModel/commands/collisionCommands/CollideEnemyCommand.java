package smbModel.commands.collisionCommands;

import smbModel.commands.CollideCommand;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class CollideEnemyCommand extends CollideCommand {

	@Override
	protected void leftCollision() {
		playerCollision();
	}

	@Override
	protected void rightCollision() {
		playerCollision();
	}

	@Override
	protected void upCollision() {
		playerCollision();
	}

	@Override
	protected void downCollision() {
		sender.removeFromView();
	}

	private void playerCollision() {
		if (receiver instanceof Player) {
			Player player = (Player) receiver;
			PlayerState playerState = player.getState();
			playerState.previousState();
		}
	}

}
