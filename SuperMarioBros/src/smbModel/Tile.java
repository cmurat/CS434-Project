package smbModel;

import java.awt.Point;


public class Tile extends Entity{
	private String imagePath; 
	
	public Tile(int row, int column, String imagePath) {
		super(row, column);
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
}
