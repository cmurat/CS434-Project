package smbModel;

import smbController.GameController;
import smbModel.players.Mario;

public class Game {
	
	MovingEntity entity;
	public Game(GameController gameController) {
		entity = new Mario(0,0);
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
