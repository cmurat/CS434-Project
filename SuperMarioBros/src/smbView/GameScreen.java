package smbView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import smbController.GameController;

public class GameScreen extends JFrame {
	JLabel label;
	GameController controller;
	public GameScreen(GameController controller) throws IOException {
		this.controller = controller;
		
		addKeyListener(new PlayerListener(controller));
		
		LevelView levelView = new LevelView(controller.getMap());
		setVisible(true);
		add(levelView);
		setSize(800, 480);
		levelView.addImages();
		validate();
	}
}
