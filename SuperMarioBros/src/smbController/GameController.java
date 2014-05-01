package smbController;

import java.awt.event.KeyEvent;
import smbModel.Game;
import smbModel.Level;

public class GameController {
	Game game;
	Level level;
	public GameController() {
		game = new Game(this);
		level = game.getLevel();
		
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

	public Level getLevel() {
		return level;
	}

}
