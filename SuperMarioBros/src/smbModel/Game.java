package smbModel;

import smbController.GameController;
import smbModel.players.Mario;

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

	public void movePlayerLeft() {
		level.movePlayerLeft();
	}

	public void movePlayerRight() {
		level.movePlayerRight();
	}

	public void movePlayerUp() {
		level.movePlayerUp();
	}

	public void movePlayerDown() {
		level.movePlayerDown();
	}

}
