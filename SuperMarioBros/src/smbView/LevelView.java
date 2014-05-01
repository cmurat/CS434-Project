package smbView;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smbModel.Entity;
import smbModel.Map;
import smbModel.Tile;

public class LevelView extends JPanel {
	Map map;

	public LevelView(Map map) {
		this.map = map;
		this.setLayout(null);
	}

	public void addImages() {
		JLabel label = null;
		for (int i = 0; i < this.map.getTiles().length; i++) {
			for (int j = 0; j < this.map.getTiles().length; j++) {
				Tile tile = this.map.getTiles()[i][j];
				label = new JLabel(new ImageIcon(tile.getImagePath()));
				label.setLocation(tile.getLocation());
				label.setSize(Entity.BASE_SIZE, Entity.BASE_SIZE);
				add(label);
			}
		}
	}
}
