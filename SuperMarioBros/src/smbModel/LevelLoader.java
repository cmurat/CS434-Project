package smbModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import smbModel.tiles.BlankTile;
import smbModel.tiles.Brick;
import smbModel.tiles.CoinBox;
import smbModel.tiles.Floor;

public class LevelLoader {
	public static void main(String[] args){
		new LevelLoader().loadLevel();
	}
	public Level loadLevel() {
		
		return null;
	}
	
	private Map createMap() {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		Tile[][] tiles = new Tile[charList.size()][];
		for (int i = 0; i<tileChars.length; i++) {
			tileChars[i] = charList.get(i);
			tiles[i] = getTileLayer(tileChars[i]);
		}
		return new Map(tileChars, tiles);
	}
	
	private ArrayList<char[]> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("smbDemoStage.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file");
			System.exit(1);
		}
		
		return loopOverMapFile(fileScanner);
	}
	
	private ArrayList<char[]> loopOverMapFile(Scanner fileScanner) {
		ArrayList<char[]> charMap = new ArrayList<char[]>();
		while(fileScanner.hasNextLine()) {
			charMap.add(fileScanner.nextLine().toCharArray());
		}
		return charMap;
	}
	
	private Tile[] getTileLayer(char[] tileChars) {
		Tile[] tiles = new Tile[tileChars.length];
		for (int i = 0; i < tileChars.length; i++) {
			tiles[i] = getTile(tileChars[i]);
		}
		return tiles;
	}
	
	private Tile getTile(char tileChar) {
		Tile tile = null;
		switch(tileChar) {
		case 'c':
			tile = new CoinBox();
			break;
		case 'b':
			tile = new Brick();
			break;
		case 'f':
			tile = new Floor();
			break;
		default:
			tile = new BlankTile();
			break;
		}
		return tile;
	}
	
	private void createLevel(Map map) {
		
	}
}
