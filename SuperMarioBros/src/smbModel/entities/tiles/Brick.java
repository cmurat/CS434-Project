package smbModel.entities.tiles;

import smbModel.entities.Tile;

public class Brick extends Tile{

	private static final String IMAGE_PATH = "Assets/smbBrick.png";
	
	public Brick(int row, int column) {
		super(row, column, IMAGE_PATH);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "b";
	}
}
