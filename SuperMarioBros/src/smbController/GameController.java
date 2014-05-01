package smbController;

import smbModel.Game;
import smbModel.Map;

public class GameController {
	Game game;
	Map map;
	public GameController() {
		game = new Game(this);
		map = game.getLevel().getMap();
	}

	public void playerHasPressedButton(int index) {
		if (index == 37) {
			game.movePlayerLeft();
		}
		if (index == 38) {
			game.movePlayerUp();
		}
		if (index == 39) {
			game.movePlayerRight();
		}
		if (index == 40) {
			game.movePlayerDown();
		}

	}
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
