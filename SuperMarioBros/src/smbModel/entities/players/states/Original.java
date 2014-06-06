package smbModel.entities.players.states;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import smbModel.MusicPlayer;
import smbModel.entities.MovingEntity;
import smbModel.entities.Player;
import smbModel.entities.players.PlayerState;

public class Original extends PlayerState {
	private Timer deathAnimation;
	
	public Original(Player player) {
		super(player, "Assets/MarioImages/Original/marioIdleLeft.png");
		System.out.println("original");
		
	}

	@Override
	public void nextState() {
		player.setState(new Grown(player));

	}

	@Override
	public void previousState() {
		player.die();
		player.setImagePath("Assets/MarioImages/marioDeath.png");
		MusicPlayer.getInstance().playMarioDeathSound();
		
		
		deathAnimation = new Timer(50, new ActionListener() {
			double playerSpeed = -MovingEntity.MAX_SPEED;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.changeY(playerSpeed);
				playerSpeed += 2*MovingEntity.ACCELERATION;
				if(playerSpeed == MovingEntity.MAX_SPEED*2) {
					deathAnimation.stop();
				}
			}
		});
		
		deathAnimation.start();
		
	}
}
