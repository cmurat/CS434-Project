package smbView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import smbController.GameController;

public class GameScreen extends JFrame {
	JLabel label;
	GameController controller;
	LevelView levelView;
	public GameScreen(GameController controller) throws IOException {
		this.controller = controller;
		
		addKeyListener(new PlayerListener(controller));
		
		levelView = new LevelView(controller.getLevel());
		setVisible(true);
		add(levelView);

		setSize(880, 520);
		levelView.addImages();
		levelView.addEnemies();
		repaint();
	}
	public void refresh() {
		levelView.refresh();
	}
}
