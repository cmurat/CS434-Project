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

import smbModel.Map;
import smbModel.Tile;

public class LevelView extends JPanel {
	Map map;
	
	public LevelView(Map map){
		this.map = map;
	}

	public void addImages() {
		 for(int i = 0; i < this.map.getTiles().length; i++) {
				for(int j = 0; j < this.map.getTiles().length; j++) {
					Tile tile = this.map.getTiles()[i][j];
					System.out.println(tile.getImagePath());
					JLabel label = new JLabel (new ImageIcon(tile.getImagePath()));
					label.setLocation(tile.getLocation());
					add();
			
				}
		 }
	}
}
