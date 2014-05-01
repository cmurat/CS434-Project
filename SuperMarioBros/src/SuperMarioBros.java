import java.io.IOException;

import smbController.GameController;
import smbView.GameScreen;


public class SuperMarioBros {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		GameController controller = new GameController();
		new GameScreen(controller);

	}

}
