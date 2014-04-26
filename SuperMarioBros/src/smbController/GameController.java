package smbController;

import smbModel.Game;

public class GameController {
	Game game;
	public GameController() {
		game = new Game(this);	
	}

	public void playerHasPressedButton(int index) {
		if (index == 37) {
			game.movePlayerLeft();
		}
		if (index == 38) {
			game.movePlayerUp();
		}
		if (index == 39) {
			game.movePlayerRight();
		}
		if (index == 40) {
			game.movePlayerDown();
		}

	}
}
