package smbModel.tiles;

import java.awt.Point;

import smbModel.Tile;

public class BlankTile extends Tile{
	
	private static final String IMAGE_PATH = "Assets/coin.png";
	
	public BlankTile(int row, int column) {
		super(row, column, IMAGE_PATH);
	}

}
