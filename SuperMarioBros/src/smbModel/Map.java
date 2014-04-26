package smbModel;

public class Map {
	private char[][] mapRepresentation;
	private Tile[][] map;
	public Map(char[][] mapRepresentation, Tile[][] map) {
		this.mapRepresentation = mapRepresentation;
		this.map = map;
	}
	
	public char[][] getMapRepresentation() {
		return mapRepresentation;
	}
}
