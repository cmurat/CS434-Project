package smbModel.commands.collisionCommands;

import smbModel.Command;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

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
