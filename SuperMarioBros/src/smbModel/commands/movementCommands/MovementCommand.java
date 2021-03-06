package smbModel.commands.movementCommands;

import java.awt.event.KeyEvent;

import smbModel.Command;
import smbModel.entities.MovingEntity;

public class MovementCommand extends Command {

	public static final int STOP = 1;
	public static final int START = 2;

	private int commandType;
	private KeyEvent event;

	public MovementCommand(int commandType, KeyEvent event) {
		this.commandType = commandType;
		this.event = event;
	}

	@Override
	public void execute(MovingEntity entity) {
		if (commandType == STOP)
			executeStop(entity);
		else
			executeStart(entity);
	}

	private void executeStop(MovingEntity entity) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_RIGHT) {
			entity.decelerateHorizontally();
		} else if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {
			entity.decelerateVertically();
		}
	}

	private void executeStart(MovingEntity entity) {
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			entity.goLeft();
		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			entity.goUp();
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			entity.goRight();
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			entity.goDown();
		}
	}
}
