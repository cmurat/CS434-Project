package smbModel.entities.tiles;

import smbModel.entities.Tile;

public class Floor extends Tile{

	private static final String IMAGE_PATH = "Assets/smbFloor.png";
	
	public Floor(int row, int column) {
		super(row, column, IMAGE_PATH);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "f";
	}
	
}
