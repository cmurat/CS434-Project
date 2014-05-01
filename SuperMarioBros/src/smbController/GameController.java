package smbController;

import java.awt.event.KeyEvent;
import smbModel.Game;
import smbModel.Map;

public class GameController {
	Game game;
	Map map;
	public GameController() {
		game = new Game(this);
		map = game.getLevel().getMap();
	}

	public void playerHasPressedButton(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			game.movePlayerLeft();
		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			game.movePlayerUp();
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.movePlayerRight();
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
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
