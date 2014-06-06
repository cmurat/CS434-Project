import java.io.IOException;

import smbController.GameController;


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
