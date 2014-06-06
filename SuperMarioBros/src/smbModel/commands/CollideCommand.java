package smbModel.commands;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import smbModel.Command;
import smbModel.commands.collisionCommands.util.BoundingRectangle;
import smbModel.entities.MovingEntity;
import smbModel.entities.tiles.BrickPiece;

public abstract class CollideCommand extends Command {
	protected double dx;
	protected double dy;

	@Override
	public void execute(MovingEntity receiver) {
		super.execute(receiver);

		Point senderLocation = sender.getLocation();
		Point entityLocation = receiver.getLocation();
		List<BoundingRectangle> boundingRectangles = createBoundingRectangles(receiver
				.getBounds());

		dx = senderLocation.getX() - entityLocation.getX();
		dy = senderLocation.getY() - entityLocation.getY();

		if (!(receiver instanceof BrickPiece))
			for (BoundingRectangle boundingRectangle : boundingRectangles) {
				if (boundingRectangle.intersects(sender.getBounds())) {
					decideDirection(boundingRectangle);
				}
			}
	}

	protected List<BoundingRectangle> createBoundingRectangles(Rectangle r) {
		List<BoundingRectangle> list = new ArrayList<BoundingRectangle>();
		int brWidth = 3;
		int tamponHeight = 8;

		// Create left rectangle
		Rectangle left = new Rectangle(r.x - 5, r.y + tamponHeight, brWidth,
				r.height - tamponHeight - 5);
		list.add(new BoundingRectangle(left, "left"));

		// Create top rectangle
		Rectangle top = new Rectangle(r.x, r.y - 15, r.width, brWidth);
		list.add(new BoundingRectangle(top, "up"));

		// Create right rectangle
		Rectangle right = new Rectangle(r.x + r.width - brWidth + 5, r.y
				+ tamponHeight, brWidth, r.height - tamponHeight - 5);
		list.add(new BoundingRectangle(right, "right"));

		// Create bottom rectangle
		Rectangle bottom = new Rectangle(r.x, r.y + r.height - brWidth + 15,
				r.width, brWidth + 5);
		list.add(new BoundingRectangle(bottom, "down"));

		return list;
	}

	private void decideDirection(BoundingRectangle boundingRectangle) {
		if (boundingRectangle.getPosition().equals("left")) {
			leftCollision();
		} else if (boundingRectangle.getPosition().equals("right")) {
			rightCollision();
		} else if (boundingRectangle.getPosition().equals("up")) {
			upCollision();
		} else if (boundingRectangle.getPosition().equals("down")) {
			downCollision();
		}
	}

	protected abstract void leftCollision();

	protected abstract void rightCollision();

	protected abstract void upCollision();

	protected abstract void downCollision();
}
