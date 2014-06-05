package smbModel.entities.players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import smbModel.entities.Player;

public abstract class PlayerState {
	protected Player player;
	protected String imagePath;

	private Timer horizontalAnimationTimer;

	private int walkCount = 0;
	private String className = this.getClass().getSimpleName();

	public PlayerState(Player player, String imagePath) {
		this.player = player;
		this.imagePath = imagePath;
		horizontalAnimationTimer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				horizontalAnimationTimer.stop();
			}

		});
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void refresh() {
		setHorizontalImage();
		setVerticalImage();
	}

	protected void setVerticalImage() {

	}

	protected void setHorizontalImage() {
		if (!horizontalAnimationTimer.isRunning()) {
			horizontalAnimationTimer.start();
			
			String direction = "Right";
			if (player.isIdle()) {
				setImagePath("Assets/MarioImages/" + className
						+ "/marioIdleLeft.png");
			} else {
				setImagePath("Assets/MarioImages/" + className + "/move"
						+ direction + (walkCount + 1) + ".png");
				walkCount++;
				walkCount %= 3;
			}
		}
	}

	public abstract void nextState();
	public abstract void previousState();
}
