package smbModel.players.states;

import smbModel.Player;
import smbModel.players.PlayerState;

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
	
}
