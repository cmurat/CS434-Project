package smbModel;

import smbModel.players.PlayerState;
import smbModel.players.states.Original;


public class Player extends MovingEntity {
    PlayerState state;
	public Player(int px, int py, Level level) {
		super(px, py, level, null);
		setState(new Original(this));
	}	
	
	public void setState(PlayerState state){
		this.state = state;
		this.imagePath = state.getImagePath();
	}

	@Override
	public void collide(MovingEntity movingEntity) {
		movingEntity.collideWithPlayer();
		
	}

	@Override
	public void collideWithPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithEnemy() {
		state.previousState();
		
	}

	@Override
	public void collideWithTile() {
		// TODO Auto-generated method stub
		
	}

	
}
