package smbModel.commands.collisionCommands;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import smbModel.Command;
import smbModel.MovingEntity;
import smbModel.commands.collisionCommands.util.BoundingRectangle;

public class CollideTileCommand extends Command {

	@Override
	public void execute(MovingEntity entity) {
		Point senderLocation = sender.getLocation();
		Point entityLocation = entity.getLocation();
		List<BoundingRectangle> boundingRectangles = createBoundingRectangles(entity.getBounds());
		
		double dx = senderLocation.getX() - entityLocation.getX();
		double dy = senderLocation.getY() - entityLocation.getY();
		
		
		for (BoundingRectangle boundingRectangle : boundingRectangles) {
			if(boundingRectangle.intersects(sender.getBounds())) {
				System.out.println(boundingRectangle.getPosition());
				System.out.println(sender.getClass() + " " + entity.getClass());
				if(boundingRectangle.getPosition().equals("left")) {
					entity.stopLeft();
					entity.changeX((dx + sender.getBounds().getWidth()));
				} else if(boundingRectangle.getPosition().equals("right")) {
					entity.changeX((dx - entity.getBounds().getWidth()));
					entity.stopRight();
				} else if(boundingRectangle.getPosition().equals("top")) {
					entity.stopUp();
					entity.changeY(dy + sender.getBounds().getHeight());
				} else if(boundingRectangle.getPosition().equals("bottom")) {
					entity.stopDown();
					entity.setCanGoDown(false);
					entity.changeY(dy - entity.getBounds().getHeight());
				}
			}
		}
		
		
//		if (Math.abs(dx) > Math.abs(dy)) {
//			if (dx < 0) {
//				entity.stopLeft();
//			}
//
//			if (dx > 0) {
//				entity.stopRight();
//			}
//		}
//		
//		if (Math.abs(dx) < Math.abs(dy)) {
//			if (dy < 0) {
//				entity.stopUp();
//				entity.changeY(1);
//			}
//
//			if (dy > 0) {
//				System.out.println("down collision");
//				entity.setCanGoDown(false);
//				entity.stopDown();
//				entity.changeY(-1);
//			}
//		}
	}
	
	public List<BoundingRectangle> createBoundingRectangles(Rectangle r) {
	    List<BoundingRectangle> list = new ArrayList<BoundingRectangle>();
	    int brWidth = 3;
	    int tamponHeight = 4;
	    
	    // Create left rectangle
	    Rectangle left = new Rectangle(r.x-10, r.y + tamponHeight, brWidth, r.height - tamponHeight);
	    list.add(new BoundingRectangle(left, "left"));

	    // Create top rectangle
	    Rectangle top = new Rectangle(r.x, r.y - 10, r.width, brWidth);
	    list.add(new BoundingRectangle(top, "top"));

	    // Create right rectangle
	    Rectangle right = new Rectangle(r.x + r.width - brWidth + 10, r.y + tamponHeight, brWidth,
	            r.height  - tamponHeight);
	    list.add(new BoundingRectangle(right, "right"));

	    // Create bottom rectangle
	    Rectangle bottom = new Rectangle(r.x, r.y + r.height - brWidth + 10,
	            r.width, brWidth);
	    list.add(new BoundingRectangle(bottom, "bottom"));

	    return list;
	}

}
