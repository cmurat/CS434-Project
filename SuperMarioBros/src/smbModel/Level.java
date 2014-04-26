package smbModel;

import java.util.ArrayList;

public class Level {
	private Map map;
	private ArrayList<Enemy> enemies;
	private ArrayList<Item> items;
	
	public Level(Map map, ArrayList<Enemy> enemies, ArrayList<Item> items) {
		this.map = map;
		this.enemies = enemies;
		this.items = items;
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public String toString() {
		return enemies.size() + " " + items.size();
	}
	
}
