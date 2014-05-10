package smbView;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smbModel.Enemy;
import smbModel.Entity;
import smbModel.Level;
import smbModel.Map;
import smbModel.Tile;

public class LevelView extends JPanel {
	Level level;
	Map map;
	ArrayList<EntityView> entityViews;
	ArrayList<JLabel> tileViews;

	public LevelView(Level level) {
		this.level = level;
		this.map = level.getMap();
		this.entityViews = new ArrayList<EntityView>();
		this.tileViews = new ArrayList<JLabel>();
		setLayout(null);	
	}
	
	public void printLevel() {
		createTileViews();
		createEntityViews();
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
		//TODO player ekle
	}
	
	private void refreshEntites() {
		for (EntityView entityView : entityViews) {
			entityView.refresh();
		}
	}
}
