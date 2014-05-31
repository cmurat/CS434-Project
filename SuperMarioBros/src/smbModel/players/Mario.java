package smbModel.players;

import smbModel.Level;
import smbModel.Player;

public class Mario extends Player {
	public Mario(int px, int py, Level level) {
		super(px, py, level);
		setSpeed(2);
	}
}
