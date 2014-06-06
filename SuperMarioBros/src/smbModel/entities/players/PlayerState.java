package smbModel.entities.players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import smbModel.entities.HorizontalDirection;
import smbModel.entities.Player;

public abstract class PlayerState {
	protected Player player;
	protected String imagePath;

	private Timer horizontalAnimationTimer;

	private int walkCount = 0;
	private int walkTime = 100;
	private int numberOfWalkImages = 3;
	private String className = this.getClass().getSimpleName();

	HorizontalDirection previousDirection;

	public PlayerState(Player player, String imagePath) {
		this.player = player;
		this.imagePath = imagePath;
		previousDirection = HorizontalDirection.Right;
		setTimer();
	}

	public void setTimer() {
		horizontalAnimationTimer = new Timer(walkTime, new ActionListener() {
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
		if (player.isJumping()) {
			setVerticalImage();
		}
	}

	protected void setVerticalImage() {
			setImagePath("Assets/MarioImages/" + className + "/marioJump"
					+ previousDirection.name() + ".png");
	}

	protected void setHorizontalImage() {
		if (!horizontalAnimationTimer.isRunning()) {
			horizontalAnimationTimer.start();

			String direction = player.horizontalDirection.name();

			if (player.horizontalDirection == HorizontalDirection.Idle) {
				setImagePath("Assets/MarioImages/" + className + "/marioIdle"
						+ previousDirection.name() + ".png");
			} else {
				setImagePath("Assets/MarioImages/" + className + "/mario"
						+ direction + (walkCount + 1) + ".png");
				previousDirection = player.horizontalDirection;
				walkCount++;
				walkCount %= numberOfWalkImages;
			}
		}
	}

	public abstract void nextState();
	public abstract void previousState();
}
