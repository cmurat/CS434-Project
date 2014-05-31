package smbController;

import java.awt.event.KeyEvent;
import java.io.IOException;

import smbModel.Game;
import smbModel.Level;
import smbModel.commands.movementCommands.MovementCommand;
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
		game.movePlayer(new MovementCommand(MovementCommand.START, event));
	}
	
	public void playerHasReleasedButton(KeyEvent event) {
		game.movePlayer(new MovementCommand(MovementCommand.STOP, event));
	}
	
	

	public Level getLevel() {
		return level;
	}

	public void refresh() {
		game.refresh();
		gameScreen.refresh();
		
	}

}
