package smbModel.entities.tiles;

import smbModel.MusicPlayer;
import smbModel.entities.Tile;

public class Brick extends Tile {

	private static final String IMAGE_PATH = "Assets/smbBrick.png";

	public Brick(int row, int column) {
		super(row, column, IMAGE_PATH);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "b";
	}

	public void removeFromView() {
		super.removeFromView();
		MusicPlayer.getInstance().playBreakblockSound();
		int row = this.bounds.y / BASE_SIZE;
		int col = this.bounds.x / BASE_SIZE;
		for (int i = 0; i < 4; i++) {
			BrickPiece piece = new BrickPiece(row, col, IMAGE_PATH);
			piece.setSpeed(-Math.abs(6 - i * 4), 3 - i * 2);
			level.addEntity(piece);
		}
	}

}
