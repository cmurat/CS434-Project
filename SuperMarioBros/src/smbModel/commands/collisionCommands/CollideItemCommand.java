package smbModel.commands.collisionCommands;

import smbModel.Command;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class CollideItemCommand extends Command{
	int type;
	
	public CollideItemCommand(int type) {
		this.type = type;
	}
	
	@Override
	public void execute(MovingEntity entity) {
		sender.removeFromView();
		if(type == 1 && (entity instanceof Player)){
			Player player = (Player) entity;
			PlayerState playerState = player.getState();
			playerState.nextState();
		}
	
		
	}



	
	

}
