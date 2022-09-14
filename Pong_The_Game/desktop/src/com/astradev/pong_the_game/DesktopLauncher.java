package com.astradev.pong_the_game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.astradev.pong_the_game.Pong;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Pong_The_Game");
		config.setResizable(false);
		config.setWindowedMode(1600, 900);
		new Lwjgl3Application(new Pong(), config);
	}
}
