package smbController;

import java.awt.event.KeyEvent;
import java.io.IOException;

import smbModel.Game;
import smbModel.MusicPlayer;
import smbModel.commands.movementCommands.MovementCommand;
import smbModel.level.Level;
import smbView.GameScreen;

public class GameController {
	Game game;
	GameScreen gameScreen;

	public GameController() throws IOException {
		game = new Game(this);
		gameScreen = new GameScreen(this);
		MusicPlayer.getInstance();

	}

	public void playerHasPressedButton(KeyEvent event) {
		game.movePlayer(new MovementCommand(MovementCommand.START, event));
	}

	public void playerHasReleasedButton(KeyEvent event) {
		game.movePlayer(new MovementCommand(MovementCommand.STOP, event));
	}

	public Level getLevel() {
		return game.getLevel();
	}

	public void refresh() {
		if (!game.isPlayerDead()) {
			game.refresh();
		}
		gameScreen.refresh();

	}

	public boolean isPLayerDead() {
		return game.isPlayerDead();
	}

}
