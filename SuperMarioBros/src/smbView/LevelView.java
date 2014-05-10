package smbView;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	ArrayList<JLabel> enemyLabels;

	public LevelView(Level level) {
		this.level = level;
		map = level.getMap();
		setLayout(null);
		enemyLabels = new ArrayList<JLabel>();
	}

	public void addImages() {
		JLabel label = null;
		for (int i = 0; i < map.getTiles().length; i++) {
			for (int j = 0; j < map.getTiles()[0].length; j++) {
				Tile tile = map.getTiles()[i][j];
				if (tile != null) {
					label = new JLabel(new ImageIcon(tile.getImagePath()));
					label.setLocation(tile.getLocation());
					label.setSize(Entity.BASE_SIZE, Entity.BASE_SIZE);
					add(label);
				}
			}
		}
	}

	public void addEnemies() {
		JLabel label = null;
		ArrayList<Enemy> enemies = level.getEnemies();
		for (Enemy enemy : enemies) {
			System.out.println(enemies.size());
			label = new JLabel(new ImageIcon(enemy.getImagePath()));
			label.setLocation(enemy.getLocation());
			label.setSize(Entity.BASE_SIZE, Entity.BASE_SIZE);
			enemyLabels.add(label);
			add(label);
		}
	}

	public void refresh() {
		ArrayList<Enemy> enemies = level.getEnemies();
		for (int i = 0; i < enemies.size(); i++) {
			enemyLabels.get(i).setLocation(enemies.get(i).getLocation());
		}
	}
}
