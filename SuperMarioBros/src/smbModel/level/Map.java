package smbModel.level;

import java.awt.Point;
import java.util.Arrays;

import smbModel.Entity;
import smbModel.entities.Tile;
import smbModel.entities.tiles.BlankTile;

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
	
	public void moveTiles(double playerOffset) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j].changeX(playerOffset);
			}
		}
	}
	
	public void printMap() {
		for (int i = 0; i < tiles.length; i++) {
			System.out.println(Arrays.toString(tiles[i]));
		}
	}
	
	public void removeTile(Entity tile) {
		int i = (int) (tile.getY()/Tile.BASE_SIZE);
		int j = (int) (tile.getX()/Tile.BASE_SIZE);
		tiles[i][j] = new BlankTile(i, j);
		System.out.println(tile.getClass());
		tile = null;
	}
 }
