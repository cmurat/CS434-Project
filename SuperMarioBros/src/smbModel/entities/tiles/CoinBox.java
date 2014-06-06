package smbModel.entities.tiles;

import smbModel.entities.Tile;
import smbModel.entities.items.Mushroom;
import smbModel.entities.items.mushrooms.RedMushroom;

public class CoinBox extends Tile {

	private static String IMAGE_PATH = "Assets/questionMarkLightBrown.png";
	boolean enabled = true;

	public CoinBox(int row, int column) {
		super(row, column, IMAGE_PATH);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "c";
	}
	
	public void removeFromView() {
		int row = bounds.y / BASE_SIZE;
		int col = bounds.x / BASE_SIZE;
		Mushroom mushroom = new RedMushroom(row, col);;
		mushroom.setLevel(level);
		
		level.addEntity(mushroom);
		
		setImagePath("Assets/questionMarkDarkBrown.png");
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
