package smbView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import smbController.GameController;

public class PlayerListener implements KeyListener {
	GameController controller;

	public PlayerListener(GameController controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		controller.playerHasPressedButton(event.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
