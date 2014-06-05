package smbModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import smbModel.commands.collisionCommands.CollidePlayerCommand;
import smbModel.players.PlayerState;
import smbModel.players.states.Original;


public class Player extends MovingEntity {
    PlayerState state;
    private static CollidePlayerCommand command = new CollidePlayerCommand();
   
    
	public Player(int px, int py, Level level) {
		super(px, py, level, null);
		setState(new Original(this));
	}	
	
	public void setState(PlayerState state){
		this.state = state;
		this.imagePath = state.getImagePath();
	}
	
	public PlayerState getState(){
		return state;
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}

	public void goLeft() {
		super.goLeft();
		state.goLeft();
		this.imagePath = state.getImagePath();
	}

	public void goRight() {
		super.goRight();
		state.goRight();
		this.imagePath = state.getImagePath();
	}
	
	public void goUp() {
		if(!getCanGoDown() && !jumping) {
			jumping = true;
			super.goUp();
		}
	}

	@Override
	public void removeFromView() {
	}
	
}
