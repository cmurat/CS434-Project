package smbModel.entities.players.states;

import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class Fiery extends PlayerState{

	public Fiery(Player player) {
		super(player, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextState() {
		// TODO Auto-generated method stub
	}

	@Override
	public void previousState() {
		player.setState(new Grown(player));
		
	}

	@Override
	protected void setVerticalImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setHorizontalImage() {
		// TODO Auto-generated method stub
		
	}
}
