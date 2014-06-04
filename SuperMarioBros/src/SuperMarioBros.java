import java.io.IOException;

import smbController.GameController;
import smbModel.Command;
import smbModel.Entity;
import smbModel.Level;
import smbModel.MovingEntity;
import smbModel.Player;
import smbModel.players.Mario;
import smbView.GameScreen;


public class SuperMarioBros {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		GameController controller = new GameController();
		while(true){
			controller.refresh();
			Thread.sleep(20);
			
		}
	}

}
