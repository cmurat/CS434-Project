package smbModel;

import smbController.GameController;
import smbModel.players.Mario;

public class Game {

	MovingEntity movingEntity;
	LevelLoader loader;
	private Level level;

	public Game(GameController gameController) {
		loader = new LevelLoader();
		level = loader.loadLevel();
		movingEntity = level.getEnemies().get(0);
		movingEntity.setSpeed(5);
	}

	public Level getLevel() {
		return level;
	}

	public void movePlayerLeft() {
		movingEntity.moveLeft();
	}

	public void movePlayerRight() {
		movingEntity.moveRight();
	}

	public void movePlayerUp() {
		movingEntity.moveUp();
	}

	public void movePlayerDown() {
		movingEntity.moveDown();
	}

}
