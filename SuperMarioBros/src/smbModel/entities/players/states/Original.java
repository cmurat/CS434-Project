package smbModel.entities.players.states;

import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class Original extends PlayerState {

	public Original(Player player) {
		super(player, "Assets/MarioImages/Original/marioIdleLeft.png");
		System.out.println("original");
		
	}

	@Override
	public void nextState() {
		player.setState(new Grown(player));

	}

	@Override
	public void previousState() {
		System.out.println("Deadd");

	}
}
