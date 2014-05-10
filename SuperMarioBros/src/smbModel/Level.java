package smbModel;

import java.util.ArrayList;

import smbModel.players.Mario;

public class Level {
	private Map map;
	private ArrayList<Enemy> enemies;
	private ArrayList<Item> items;
	Player playerCharacter;
	
	public Level(Map map, ArrayList<Enemy> enemies, ArrayList<Item> items) {
		this.map = map;
		this.enemies = enemies;
		this.items = items;
		this.playerCharacter = new Mario(12, 2, this);
		
		setLevelOfEntities(enemies);
		setLevelOfEntities(items);
	}
	
	private void setLevelOfEntities(ArrayList<? extends MovingEntity> movingEntities) {
		for (MovingEntity movingEntity : movingEntities) {
			movingEntity.setLevel(this);
		}
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

	public Player getPlayer() {
		return playerCharacter;
	}
	

	public void movePlayerLeft() {
		playerCharacter.moveLeft();
	}

	public void movePlayerRight() {
		playerCharacter.moveRight();
	}

	public void movePlayerUp() {
		playerCharacter.moveUp();
	}

	public void movePlayerDown() {
		playerCharacter.moveDown();
	}
	
}
