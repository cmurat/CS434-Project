package smbModel;

import smbController.GameController;
import smbModel.commands.movementCommands.MovementCommand;
import smbModel.level.Level;
import smbModel.level.LevelLoader;

public class Game {

	
	LevelLoader loader;
	private Level level;

	public Game(GameController gameController) {
		loader = new LevelLoader();
		level = loader.loadLevel();
	}

	public Level getLevel() {
		return level;
	}
	
	public void refresh(){
		level.refresh();
	}
	
	public void movePlayer(MovementCommand command) {
		level.movePlayer(command);
	}
	
	public boolean isPlayerDead() {
		return level.isPlayerDead();
	}

}
