package com.javagame.dress_up;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.javagame.dress_up.MyDressUp;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		MyDressUp game = new MyDressUp();
		double scale = game.getScale();

		config.setForegroundFPS(60);
		config.setWindowedMode(game.getWidth(), game.getHeight());
		config.setResizable(false);
		config.setTitle("Dress_Up_Game");
		new Lwjgl3Application(game, config);
	}
}
