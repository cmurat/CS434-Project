package smbModel.level;

import java.awt.Point;
import java.util.ArrayList;

import smbModel.Command;
import smbModel.Entity;
import smbModel.entities.Enemy;
import smbModel.entities.Item;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.Tile;
import smbModel.entities.players.Mario;

public class Level {
	private Map map;
	private ArrayList<MovingEntity> entities;
	private ArrayList<Enemy> enemies;
	private ArrayList<Item> items;
	private ArrayList<Entity> entitiesToDelete;
	private ArrayList<MovingEntity> entitiesToAdd;
	
	Player playerCharacter;

	public Level(Map map, ArrayList<Enemy> enemies, ArrayList<Item> items) {
		this.map = map;
		this.enemies = enemies;
		this.items = items;
		this.playerCharacter = new Mario(12, 2);
		playerCharacter.setLevel(this);
		this.entities = new ArrayList<MovingEntity>();
		this.entitiesToDelete = new ArrayList<Entity>();
		this.entitiesToAdd = new ArrayList<MovingEntity>();
		this.entities.add(playerCharacter);
		this.entities.addAll(enemies);
		this.entities.addAll(items);

		setLevelOfEntities(enemies);
		setLevelOfEntities(items);
		setLEvetOfTiles();
	}

	private void setLevelOfEntities(ArrayList<? extends Entity> entities) {
		for (Entity entity : entities) {
			entity.setLevel(this);
		}
	}
	
	private void setLEvetOfTiles() {
		Tile[][] tiles = map.getTiles();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j].setLevel(this);
			}
		}
		
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public ArrayList<Entity> getEntitiesToDelete() {
		return entitiesToDelete;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public ArrayList<MovingEntity> getEntities() {
		return entities;
	}
	
	public ArrayList<MovingEntity> getEntitiesToAdd() {
		return entitiesToAdd;
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
		}
	}

	public void movePlayer(Command command) {
		command.execute(playerCharacter);
	}

	public ArrayList<Tile> getRespectiveTiles(Point location) {
		Tile[][] tiles = map.getRespectiveTiles(location);
		ArrayList<Tile> respectiveTiles = new ArrayList<Tile>();
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				if (tiles[i][j] != null)
					respectiveTiles.add(tiles[i][j]);
			}
		}

		return respectiveTiles;
	}

	public void addEntitiesToDelete(Entity entity) {
		entitiesToDelete.add(entity);	
		map.removeTile(entity);
	}
	
	public void addEntity(MovingEntity entity) {
		entitiesToAdd.add(entity);
		entity.setLevel(this);
	}
	
	public void removeAddedEntities() {
		entitiesToAdd.clear();
	}
	
	public void removeEntities() {
		entities.removeAll(entitiesToDelete);
		enemies.removeAll(entitiesToDelete);
		entities.addAll(entitiesToAdd);
		entitiesToAdd.clear();
		entitiesToDelete.clear();
	}


}
