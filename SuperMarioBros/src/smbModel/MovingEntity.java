package smbModel;

import smbModel.players.Mario;
import smbModel.tiles.Entity;

public class MovingEntity extends Entity{
	private double speed;

	public MovingEntity(int row, int column) {
		super(row, column);
	}

	public void moveUp() {

	}
	public void moveDown() {

	}

	public void moveLeft() {
		setX(-speed);
		System.out.println(getX());
	}

	public void moveRight() {
		setX(speed);
		System.out.println(getX());

	}

	public double getSpeed() {
		return speed;
	}
	
	public double setSpeed(double speed) {
		return this.speed = speed;
	}

	public double getX() {
		return super.getX();
	}

	public double getY() {
		return super.getY();
	}

	public String toString() {
		String str = "Position x: " + getX() + "\n" + "Position y: " + getY() + "\n";
		return str;
	}
	
}
