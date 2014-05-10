package smbView;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import smbModel.Entity;

public class EntityView extends JLabel{
	private Entity entity;
	
	
	public EntityView(Entity entity) {
		this.entity = entity;
	}
	
	public void setImage(String imagePath) {
		setIcon(new ImageIcon(imagePath));
	}	
	
	public void refresh() {
		setImage(entity.getImagePath());
		setLocation(entity.getLocation());
		setSize(entity.getSize());
	}
}
