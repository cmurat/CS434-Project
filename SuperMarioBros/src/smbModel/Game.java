package smbModel;

import smbController.GameController;
import smbModel.players.Mario;

public class Game {
	
	MovingEntity entity;
	LevelLoader loader;
	private Level level;
	
	public Game(GameController gameController) {
		entity = new Mario(0,0);
		loader = new LevelLoader();
		level = loader.loadLevel();
	}

	public Level getLevel() {
		return level;
	}

	public void movePlayerLeft() {
		entity.moveLeft();
	}
	public void movePlayerRight() {
		entity.moveRight();
	}
	public void movePlayerUp() {
		entity.moveUp();
	}
	public void movePlayerDown() {
		entity.moveDown();
	}

}
