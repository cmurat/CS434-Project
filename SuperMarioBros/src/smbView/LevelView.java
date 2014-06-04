package smbView;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.PlainView;

import smbModel.Enemy;
import smbModel.Entity;
import smbModel.Item;
import smbModel.Level;
import smbModel.Map;
import smbModel.Tile;

public class LevelView extends JPanel {
	Level level;
	Map map;
	ArrayList<EntityView> entityViews;
	ArrayList<EntityView> entityViewsToDelete;
	ArrayList<JLabel> tileViews;
	EntityView playerView;

	public LevelView(Level level) {
		this.level = level;
		this.map = level.getMap();
		this.entityViews = new ArrayList<EntityView>();
		this.entityViewsToDelete = new ArrayList<EntityView>();
		this.tileViews = new ArrayList<JLabel>();
		System.out.println(level.getPlayer().getImagePath());
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
		JLabel tileView = null;
		for (int i = 0; i < map.getTiles().length; i++) {
			for (int j = 0; j < map.getTiles()[0].length; j++) {
				Tile tile = map.getTiles()[i][j];
				if (tile != null) {
					tileView = new JLabel(new ImageIcon(tile.getImagePath()));
					tileView.setLocation(tile.getLocation());
					tileView.setSize(Entity.BASE_SIZE, Entity.BASE_SIZE);
					tileViews.add(tileView);
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
				entityView.entity = null;
			}
		}

		for (EntityView entityView : entityViews) {
			if (entityView.entity == null) {
				remove(entityView);
				repaint();
			} else {
				entityView.refresh();
			}

		}
		entityViews.removeAll(entityViewsToDelete);
	}
}
