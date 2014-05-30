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
	
	public void refresh(){
		level.moveEntities();
		
	}

	public void stopPlayerLeft() {
		level.stopPlayerLeft();
		
	}

	public void stopPlayerUp() {
		level.stopPlayerUp();
		
	}

	public void stopPlayerRight() {
		level.stopPlayerRight();
		
	}

	public void stopPlayerDown() {
		level.stopPlayerDown();
		
	}

}
