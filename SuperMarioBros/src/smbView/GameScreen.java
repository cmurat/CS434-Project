package smbView;

import java.io.IOException;

import javax.swing.ImageIcon;
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
		levelView.setOpaque(false);
		add(levelView);

		setVisible(true);
		setSize(864, 500);
		levelView.printLevel();
		
		setBackground();
		repaint();
	}

	private void setBackground() {
		ImageIcon image = new ImageIcon("Assets/smb_background.png");
		JLabel imagelabel = new JLabel();
		imagelabel.setIcon(image);
		imagelabel.setLocation(0, 0);
		imagelabel.setSize(image.getIconWidth(), image.getIconHeight());
		add(imagelabel);
	}
	
	public void refresh() {
		levelView.refresh();
	}
}
