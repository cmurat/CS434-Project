package smbView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smbController.GameController;

public class GameScreen extends JFrame {
	JLabel label;
	GameController controller;
	
	public GameScreen(GameController controller) {
		this.controller = controller;
		JPanel p = new JPanel();
		label = new JLabel("Key Listener!");
		p.add(label);
		add(p);
		addKeyListener(new PlayerListener(controller));
		setSize(200, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GameController controller = new GameController();
		new GameScreen(controller);

	}

}
