package smbModel;

public class Map {
	private char[][] charMap;
	private Tile[][] map;
	public Map(char[][] mapRepresentation, Tile[][] map) {
		this.charMap = mapRepresentation;
		this.map = map;
	}
	
	public char[][] getCharMap() {
		return charMap;
	}
}
