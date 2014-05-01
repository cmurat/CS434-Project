import smbController.GameController;
import smbView.GameScreen;


public class SuperMarioBros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameController controller = new GameController();
		new GameScreen(controller);

	}

}
