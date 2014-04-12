package smbModel;

import smbModel.players.Mario;

public class PlayerCharacter extends Entity {
	private int px;
	private int py;
	private int speed;

	public PlayerCharacter(int px, int py, int speed) {
		this.px = px;
		this.py = py;
		this.speed = speed;
	}

	public void moveUp() {

	}

	public void moveLeft() {
		px -= speed;
	}

	public void moveRight() {
		px += speed;

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

	public static void main(String[] args) {
		PlayerCharacter character = new Mario(0, 0, 5);
		character.moveLeft();
		System.out.println(character.toString());
	}

	

}
