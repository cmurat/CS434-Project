package smbModel;

public abstract class Command {
	protected Entity sender;
	

	public void setSender(Entity sender) {
		this.sender = sender;
	}
	
	public abstract void execute(MovingEntity entity);
}
