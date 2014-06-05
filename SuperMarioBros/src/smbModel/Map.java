package smbModel;

import java.awt.Point;
import java.util.Arrays;

public class Map {
	private char[][] charMap;
	private Tile[][] tiles;
	public Map(char[][] mapRepresentation, Tile[][] tiles) {
		this.charMap = mapRepresentation;
		this.tiles = tiles;
	}
	
	public char[][] getCharMap() {
		return charMap;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public Tile[][] getRespectiveTiles(Point location) {
		Tile[][] respectiveTiles = new Tile[5][5];
		int x = (int) (location.getX()/Tile.BASE_SIZE) - 1;
		int y = (int) (location.getY()/Tile.BASE_SIZE) - 1;
		
		for (int i = 0; i < respectiveTiles.length; i++) {
			for (int j = 0; j < respectiveTiles[0].length; j++) {
				try {
					respectiveTiles[i][j] = tiles[i + y][j + x];
				} catch(RuntimeException e) {
					continue;
				}
			}
		}
		
		
		return respectiveTiles;
	}
	
	public void printMap() {
		for (int i = 0; i < tiles.length; i++) {
			System.out.println(Arrays.toString(tiles[i]));
		}
	}
}
