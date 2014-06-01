package smbView;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import smbModel.Enemy;
import smbModel.Entity;

public class EntityView extends JLabel {
	public Entity entity;

	public EntityView(Entity entity) {
		this.entity = entity;
	}

	public void setImage(String imagePath) {
		ImageIcon img = new ImageIcon(imagePath);
		setIcon(img);
		entity.setSize(img.getIconWidth(), img.getIconHeight());
	}

	public void refresh() {
		setImage(entity.getImagePath());
		setLocation(entity.getLocation());
		setSize(entity.getSize());

	}

	public void remove() {
		remove();
	}
}
