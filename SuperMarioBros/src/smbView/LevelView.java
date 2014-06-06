package smbView;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smbModel.Entity;
import smbModel.entities.Enemy;
import smbModel.entities.Item;
import smbModel.entities.MovingEntity;
import smbModel.entities.Tile;
import smbModel.level.Level;
import smbModel.level.Map;

public class LevelView extends JPanel {
	Level level;
	Map map;
	ArrayList<EntityView> entityViews;
	ArrayList<EntityView> entityViewsToDelete;
	ArrayList<EntityView> tileViews;
	EntityView playerView;

	public LevelView(Level level) {
		
		this.level = level;
		this.map = level.getMap();
		this.entityViews = new ArrayList<EntityView>();
		this.entityViewsToDelete = new ArrayList<EntityView>();
		this.tileViews = new ArrayList<EntityView>();
		this.playerView = new EntityView(level.getPlayer());

		setLayout(null);
	}

	public void printLevel() {
		createTileViews();
		createEntityViews();
		addPlayerView();
		addLabels(entityViews);
		addLabels(tileViews);
	}

	private void createTileViews() {
		EntityView tileView = null;
		for (int i = 0; i < map.getTiles().length; i++) {
			for (int j = 0; j < map.getTiles()[0].length; j++) {
				Tile tile = map.getTiles()[i][j];
				if (tile != null) {
					tileView = new EntityView(tile);
					tileView.setImage(tile.getImagePath());
					tileView.refresh();
					tileView.setOpaque(false);
					tileViews.add(tileView);
					entityViews.add(tileView);
				}
			}
		}
	}

	private void createEntityViews() {
		ArrayList<Enemy> enemies = level.getEnemies();
		for (Enemy enemy : enemies) {
			entityViews.add(new EntityView(enemy));
		}
		ArrayList<Item> items = level.getItems();
		for (Item item : items) {
			entityViews.add(new EntityView(item));
		}
		
	}

	private void addPlayerView() {
		entityViews.add(playerView);
	}

	private void addLabels(List<? extends JLabel> labels) {
		for (JLabel label : labels) {
			add(label);
		}
	}

	public void refresh() {
		refreshEntites();
		refreshPlayer();
		
	}

	private void refreshPlayer() {
		// TODO player ekle
	}

	private void refreshEntites() {
		ArrayList<Entity> entities = level.getEntitiesToDelete();
		for (EntityView entityView : entityViews) {
			if (entities.contains(entityView.entity)) {
				entityViewsToDelete.add(entityView);
				remove(entityView);
			} 	
		}
		
		for (EntityView entityView : entityViews) {
				entityView.refresh();
		}
		
		ArrayList<MovingEntity> entitiesToAdd = level.getEntitiesToAdd();
		for (Entity entity : entitiesToAdd) {
			EntityView entityView = new EntityView(entity);
			entityViews.add(entityView);
			add(entityView);
			entityView.refresh();
		}
		
		repaint();
		entityViews.removeAll(entityViewsToDelete);
	}
}
