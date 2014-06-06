package smbModel.entities;

import smbModel.Command;
import smbModel.MusicPlayer;
import smbModel.commands.collisionCommands.CollidePlayerCommand;
import smbModel.entities.players.PlayerState;
import smbModel.entities.players.states.Original;


public class Player extends MovingEntity {
    PlayerState state;
    private static CollidePlayerCommand command = new CollidePlayerCommand();
   
    
	public Player(int px, int py) {
		super(px, py, null);
		setState(new Original(this));
	}	
	
	public void setState(PlayerState state){
		this.state = state;
		this.imagePath = state.getImagePath();
	}
	
	public PlayerState getState(){
		return state;
	}
	
	public void move() {
		state.refresh();
		imagePath = state.getImagePath();
		super.move();
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}
	
	public void goUp() {
		if(!getCanGoDown() && !jumping) {
			MusicPlayer.getInstance().playJumpSound();
			jumping = true;
			super.goUp();
		}
	}

	@Override
	public void removeFromView() {
	}
	
	public double getHorizontalSpeed() {
		return horizontalSpeed;
	}
	
	public double getVerticalSpeed() {
		return verticalSpeed;
	}

	public void die() {
		level.setPlayerDead(true);
	}
	
}
