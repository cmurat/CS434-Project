package smbModel.commands.collisionCommands;

import smbModel.Command;
import smbModel.commands.CollideCommand;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class CollideEnemyCommand extends CollideCommand{

	@Override
	public void execute(MovingEntity entity) {
		
		if(entity instanceof Player){
			sender.removeFromView();
			Player player = (Player) entity;
			PlayerState playerState = player.getState();
			playerState.previousState();
		}
	
	}

	@Override
	protected void leftCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void rightCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void upCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void downCollision() {
		// TODO Auto-generated method stub
		
	}

}
