package smbModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import smbModel.enemies.Shellcreeper;
import smbModel.enemies.Sidestepper;
import smbModel.items.Coin;
import smbModel.tiles.BlankTile;
import smbModel.tiles.Brick;
import smbModel.tiles.CoinBox;
import smbModel.tiles.Floor;

public class LevelLoader {
	public static void main(String[] args){
		System.out.println(new LevelLoader().loadLevel());
	}
	
	public Level loadLevel() {
		Map map = createMap();
		Level level = createLevel(map);
		return level;
	}
	
	private Map createMap() {
		ArrayList<char[]> charList = readMapFile();
		char[][] tileChars = new char[charList.size()][];
		Tile[][] tiles = new Tile[charList.size()][];
		for (int row = 0; row<tileChars.length; row++) {
			tileChars[row] = charList.get(row);
			tiles[row] = getTileLayer(tileChars[row], row);
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
	
	private Tile[] getTileLayer(char[] tileChars, int row) {
		Tile[] tiles = new Tile[tileChars.length];
		for (int column = 0; column < tileChars.length; column++) {
			tiles[column] = getTile(tileChars[column], column, row);
		}
		return tiles;
	}
	
	private Tile getTile(char tileChar, int column, int row) {
		Tile tile = null;
		switch(tileChar) {
		case 'x':
			System.out.println("x");
			break;
		case 'c':
			tile = new CoinBox(row, column);
			break;
		case 'b':
			tile = new Brick(row, column);
			break;
		case 'f':
			tile = new Floor(row, column);
			break;
		default:
			tile = new BlankTile(row, column);
			break;
		}
		return tile;
	}
	
	private Level createLevel(Map map) {
		char[][] charMap = map.getCharMap();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		ArrayList<Item> items = new ArrayList<Item>();
		for (int row = 0; row < charMap.length; row++) {
			for (int column = 0; column < charMap.length; column++) {
				Enemy enemy = getEnemy(charMap[row][column], column, row);
				Item item = getItem(charMap[row][column], column, row);
				if(enemy != null) {
					enemies.add(enemy);
				}
				if(item != null) {
					items.add(item);
				}
			}
		}
		
		Level level = new Level(map, enemies, items);
		return level;
	}
	
	private Enemy getEnemy(char tileChar, int column, int row) {
		Enemy enemy = null;
		switch(tileChar) {
		case 'x':
			enemy = new Shellcreeper(row, column);
			break;
		case 'y':
			enemy = new Sidestepper(row, column);
			break;
		}
		return enemy;
	}
	
	private Item getItem(char tileChar, int column, int row) {
		Item item = null;
		switch(tileChar) {
		case 'c':
			item = new Coin(row, column);
			break;
		}
		return item;
	}
}
