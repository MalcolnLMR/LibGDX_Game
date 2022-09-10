package com.javagame.dress_up;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.javagame.dress_up.MyDressUp;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		double scale = 0.75;
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode((int) (1600*scale), (int) (900*scale));
		config.setResizable(false);
		config.setTitle("Dress_Up_Game");
		new Lwjgl3Application(new MyDressUp(), config);
	}
}
