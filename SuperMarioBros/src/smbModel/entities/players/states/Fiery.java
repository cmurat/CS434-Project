package smbModel.entities.players.states;

import smbModel.entities.Player;
import smbModel.entities.Tile;
import smbModel.entities.players.PlayerState;

public class Fiery extends PlayerState{

	public Fiery(Player player) {
		super(player, "");
		player.setLocation(player.getX(), player.getY() - Tile.BASE_SIZE);
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
