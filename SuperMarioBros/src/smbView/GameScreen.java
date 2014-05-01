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
		label = new JLabel("Mario");
		p.add(label);
		add(p);
		addKeyListener(new PlayerListener(controller));
		setSize(800, 480);
		setVisible(true);
		
	}
	


}
