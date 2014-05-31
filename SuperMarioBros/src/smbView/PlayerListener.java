package smbView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import smbController.GameController;

public class PlayerListener extends KeyAdapter {
	GameController controller;

	public PlayerListener(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		controller.playerHasPressedButton(event);
	}
	
	public void keyReleased(KeyEvent event) {
		controller.playerHasReleasedButton(event);
	}
}
