package com.plantgame;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			PlantGame plantGame = new PlantGame();
			plantGame.setResizable(false);
			plantGame.launchFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
