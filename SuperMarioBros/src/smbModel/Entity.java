package smbModel;

import smbModel.players.Mario;

public class Entity {
	private int px;
	private int py;
	private int speed;

	public Entity(int px, int py, int speed) {
		this.px = px;
		this.py = py;
		this.speed = speed;
	}

	public void moveUp() {

	}
	public void moveDown() {

	}

	public void moveLeft() {
		px -= speed;
		System.out.println(px);
	}

	public void moveRight() {
		px += speed;
		System.out.println(px);

	}

	public int getSpeed() {
		return speed;
	}

	public int getPx() {
		return this.px;
	}

	public int getPy() {
		return this.py;
	}

	public String toString() {
		String str = "Position x: " + px + "\n" + "Position y: " + py + "\n";
		return str;
	}
	
}
