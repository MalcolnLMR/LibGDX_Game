package com.dressmeup.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.dressmeup.configs.GameConfigs;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();		
		config.setForegroundFPS(60);
		config.setTitle("Dress Me Up");
		config.setWindowedMode(GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());
		config.setResizable(false);	
		new Lwjgl3Application(new DressMeUp(), config);
	}
}
