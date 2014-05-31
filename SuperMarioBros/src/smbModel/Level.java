package smbModel;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import smbModel.commands.movementCommands.MovementCommand;
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

	private void setLevelOfEntities(
			ArrayList<? extends MovingEntity> movingEntities) {
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

}
