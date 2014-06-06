package smbModel.entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import smbModel.Command;
import smbModel.commands.collisionCommands.CollideEnemyCommand;

public class Enemy extends MovingEntity {

	private static CollideEnemyCommand command = new CollideEnemyCommand();
	private String className;
	private double prevHorizontalSpeed;

	private Timer walkTimer;
	private int walkDelay = 300;
	private int walkCount = 0;

	public Enemy(int px, int py) {
		super(px, py, null);
		className = getClass().getSimpleName();
		imagePath = "Assets/Enemy/" + className + "1.png";
		horizontalSpeed = -MAX_SPEED / 4;
		continueHorizontally = true;
		setTimer();
	}

	private void setTimer() {
		walkTimer = new Timer(walkDelay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				walkTimer.stop();
			}
		});
	}

	public void move() {
		walkAnimation();
		prevHorizontalSpeed = horizontalSpeed;
		super.move();
		if (horizontallyCollidedWithTile) {
			horizontalSpeed = -prevHorizontalSpeed;
			changeX(horizontalSpeed);
			horizontallyCollidedWithTile = false;
		}
	}

	private void walkAnimation() {
		if (!walkTimer.isRunning()) {
			imagePath = "Assets/Enemy/" + className + walkCount + ".png";
			walkCount++;
			walkCount %= 2;
			walkTimer.start();
		}
	}

	public void removeFromView() {
		super.removeFromView();
	}

	@Override
	public Command collide() {
		command.setSender(this);
		return command;
	}
}
