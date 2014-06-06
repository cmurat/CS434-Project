package smbModel;

import smbModel.entities.MovingEntity;

public abstract class Command {
	protected Entity sender;
	protected MovingEntity receiver;

	public void setSender(Entity sender) {
		this.sender = sender;
	}
	
	public void execute(MovingEntity receiver) {
		this.receiver = receiver;
	}

}
