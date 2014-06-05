package smbModel;

import smbModel.entities.MovingEntity;

public abstract class Command {
	protected Entity sender;
	

	public void setSender(Entity sender) {
		this.sender = sender;
	}
	public abstract void execute(MovingEntity entity);

}
