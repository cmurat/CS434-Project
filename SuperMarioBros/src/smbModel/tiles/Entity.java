package smbModel.tiles;

import java.awt.Point;

public class Entity {
	public static final int BASE_SIZE = 32;
	private Point point;
	
	public Entity(int row, int column) {
		point = new Point(column*BASE_SIZE, row*BASE_SIZE);
	}
	
	public void setX(double px) {
		setLocation(point.getX() + px, point.getY());
	}
	
	public void setY(double py) {
		setLocation(point.getX(), point.getY() + py);
	}
	
	public void setLocation(double x, double y) {
		point.setLocation(x, y);
	}
	
	public Point getPoint() {
		return point;
	}
	
	public double getX() {
		return point.getX();
	}
	
	public double getY() {
		return point.getY();
	}
}
