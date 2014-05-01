package smbModel;

import smbModel.players.Mario;

public class MovingEntity extends Entity{
	private double speed;
	private Level level;

	public MovingEntity(int row, int column, Level level, String imagePath) {
		super(row, column, imagePath);
		setLevel(level);
	}

	public void moveUp() {

	}
	
	public void moveDown() {

	}

	public void moveLeft() {
		changeX(-speed);
		System.out.println(getX());
	}

	public void moveRight() {
		changeX(speed);
		System.out.println(getX());

	}

	public double getSpeed() {
		return speed;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	protected double setSpeed(double speed) {
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
