package smbModel.entities.tiles;

import smbModel.entities.Tile;

public class CoinBox extends Tile {

	private static final String IMAGE_PATH = "Assets/questionMarkLightBrown.png";

	public CoinBox(int row, int column) {
		super(row, column, IMAGE_PATH);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "c";
	}
}
