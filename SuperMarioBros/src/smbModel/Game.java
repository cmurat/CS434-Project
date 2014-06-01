package smbModel;

import smbController.GameController;
import smbModel.commands.movementCommands.MovementCommand;

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
		level.removeEntities();
		level.moveEntities();	
	}
	
	public void movePlayer(MovementCommand command) {
		level.movePlayer(command);
	}

}
