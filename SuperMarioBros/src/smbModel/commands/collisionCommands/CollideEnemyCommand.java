package smbModel.commands.collisionCommands;

import java.awt.Point;

import smbModel.Command;
import smbModel.MovingEntity;
import smbModel.Player;
import smbModel.players.PlayerState;

public class CollideEnemyCommand extends Command{

	@Override
	public void execute(MovingEntity entity) {
		sender.removeFromView();
		
		if(entity instanceof Player){
			Player player = (Player) entity;
			PlayerState playerState = player.getState();
			playerState.previousState();
		}
	
	}

}
