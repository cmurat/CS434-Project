package smbModel.players.states;

import smbModel.Player;
import smbModel.players.PlayerState;

public class Original extends PlayerState{

	public Original(Player player) {
		super(player, "Assets/marioIdleRight.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextState() {
		player.setState(new Grown(player));
		
	}

	@Override
	public void previousState() {
		System.out.println("Deadd");
		
	}

	@Override
	public void goLeft() {
		System.out.println("left");
		super.setImagePath("Assets/marioIdleLeft.png");
		
	}

	@Override
	public void goRight() {
		System.out.println("right");
		super.setImagePath("Assets/marioIdleRight.png");
		
	}

}
