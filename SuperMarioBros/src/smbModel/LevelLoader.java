package smbModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelLoader {
	public static void main(String[] args){
		new LevelLoader().loadLevel();
	}
	public Level loadLevel() {
		
		return null;
	}
	
	private Map createMap() {
		
		return null;
	}
	
	private ArrayList<String> readMapFile() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File("smbDemoStage.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read stage file");
			System.exit(1);
		}
		
		return loopOverMapFile(fileScanner);
	}
	
	private ArrayList<String> loopOverMapFile(Scanner fileScanner) {
		ArrayList<String> charMap = new ArrayList<String>();
		while(fileScanner.hasNextLine()) {
			charMap.add(fileScanner.nextLine());
		}
		return charMap;
	}
}
