package smbModel.commands.collisionCommands;

import smbModel.Command;
import smbModel.commands.CollideCommand;
import smbModel.entities.Item;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class CollideItemCommand extends CollideCommand{
	int type;
	
	public CollideItemCommand(int type) {
		this.type = type;
	}
	
	@Override
	public void execute(MovingEntity entity) {
		if(type == Item.MUSHROOM && (entity instanceof Player)){
			
			sender.removeFromView();
			Player player = (Player) entity;
			PlayerState playerState = player.getState();
			System.out.println(playerState.getClass());
			playerState.nextState();
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
