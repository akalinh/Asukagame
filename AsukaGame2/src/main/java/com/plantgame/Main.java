package com.plantgame;
import java.io.IOException;

public class
Main {
	public static void main(String[] args) {
		try {
			new PlantGame().launchFrame();
			BgmThread.bgmstart();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
