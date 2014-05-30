package smbController;

import java.awt.event.KeyEvent;
import java.io.IOException;

import smbModel.Game;
import smbModel.Level;
import smbView.GameScreen;

public class GameController {
	Game game;
	Level level;
	GameScreen gameScreen;
	public GameController() throws IOException {
		game = new Game(this);
		level = game.getLevel();
		gameScreen = new GameScreen(this);
		
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
	
	public void playerHasReleasedButton(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			game.stopPlayerLeft();
		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			game.stopPlayerUp();
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.stopPlayerRight();
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			game.stopPlayerDown();
		}

	}
	
	

	public Level getLevel() {
		return level;
	}

	public void refresh() {
		game.refresh();
		gameScreen.refresh();
		
	}

}
