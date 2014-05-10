package smbModel.players;

import smbModel.Level;
import smbModel.PlayerCharacter;

public class Mario extends PlayerCharacter {
	public Mario(int px, int py, Level level) {
		super(px, py, level, "Assets/");
		setSpeed(10);
	}
}
