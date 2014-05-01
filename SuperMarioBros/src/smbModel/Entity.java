package smbModel;

import java.awt.Point;
import java.awt.Rectangle;

public class Entity {
	private String imagePath; 
	
	public static final int BASE_SIZE = 32;
	
	private Point location;
	protected Rectangle bounds;
	
	public Entity(int row, int column, String imagePath) {
		location = new Point(column*BASE_SIZE, row*BASE_SIZE);
		bounds = new Rectangle(BASE_SIZE, BASE_SIZE);
		bounds.setLocation(location);
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void changeX(double px) {
		setLocation(location.getX() + px, location.getY());
	}
	
	public void changeY(double py) {
		setLocation(location.getX(), location.getY() + py);
	}
	
	public void setLocation(Point p) {
		location.setLocation(p);
		bounds.setLocation(p);
	}
	
	public void setLocation(double x, double y) {
		location.setLocation(x, y);
		bounds.setLocation(location);
	}
	
	public Point getLocation() {
		return location;
	}
	
	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}
	
	public boolean intersects(Rectangle r) {
		return bounds.intersects(r);
	}
}
