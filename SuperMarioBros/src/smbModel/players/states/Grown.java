package smbModel.players.states;

import smbModel.Player;
import smbModel.players.PlayerState;

public class Grown extends PlayerState{

	public Grown(Player player) {
		super(player, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextState() {
		player.setState(new Fiery(player));
		
	}

	@Override
	public void previousState() {
		player.setState(new Original(player));
		
	}

}
