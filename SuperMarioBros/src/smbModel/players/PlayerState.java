package smbModel.players;

import smbModel.Player;

public abstract class PlayerState {
	protected Player player;
	protected String imagePath;
	
	public PlayerState(Player player, String imagePath){
		this.player = player;	
		this.imagePath = imagePath;
	}
	public abstract void nextState();
	public abstract void previousState();
	
	public String getImagePath() {
		return imagePath;
	}
	
}
