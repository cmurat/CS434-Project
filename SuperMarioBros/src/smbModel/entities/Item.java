 package smbModel.entities;

import smbModel.Command;
import smbModel.level.Level;

public abstract class Item extends MovingEntity {
	
	public static final int MUSHROOM = 1;
	public static final int COIN = 2;
	public static final int FLOWER = 3;
	public static final int STAR = 4;
	
	public Item(int px, int py, String imagePath) {
		super(px, py, imagePath);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Command collide() {
		Command command = getCommand();
		command.setSender(this);
		return command;
	}
	
	protected abstract Command getCommand();
	@Override
	public void removeFromView() {
		level.addEntitiesToDelete(this);
		
	}
}
