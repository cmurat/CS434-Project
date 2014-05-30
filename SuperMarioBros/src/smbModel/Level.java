package smbModel;

import java.util.ArrayList;

import smbModel.players.Mario;

public class Level {
	private Map map;
	private ArrayList<MovingEntity> entities;
	private ArrayList<Enemy> enemies;
	private ArrayList<Item> items;
	Player playerCharacter;
	
	public Level(Map map, ArrayList<Enemy> enemies, ArrayList<Item> items) {
		this.map = map;
		this.enemies = enemies;
		this.items = items;
		this.playerCharacter = new Mario(12, 2, this);
		this.entities = new ArrayList<MovingEntity>();
		this.entities.add(playerCharacter);
		this.entities.addAll(enemies);
		this.entities.addAll(items);
		
		
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
	public ArrayList<MovingEntity> getEntities() {
		return entities;
	}
	
	
	public String toString() {
		return enemies.size() + " " + items.size();
	}

	public Player getPlayer() {
		return playerCharacter;
	}
	
	public void moveEntities() {
		for (MovingEntity entity : entities) {
			entity.move();
			entity.checkCollision();
		}
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

	public void stopPlayerLeft() {
		
		
	}

	public void stopPlayerUp() {
		// TODO Auto-generated method stub
		
	}

	public void stopPlayerRight() {
		// TODO Auto-generated method stub
		
	}

	public void stopPlayerDown() {
		// TODO Auto-generated method stub
		
	}
	
}
