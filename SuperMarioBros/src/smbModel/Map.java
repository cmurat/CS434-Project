package smbModel;

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
}
