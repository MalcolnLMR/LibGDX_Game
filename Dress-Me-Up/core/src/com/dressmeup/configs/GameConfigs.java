package com.dressmeup.configs;

public class GameConfigs {
	
	private static final double WIDTH = 1600;
	private static final double HEIGHT = 800;
	private static final double SCALE = 1;
	
	public static int getScaledWidth() {
		return (int) (WIDTH * SCALE);		
	}
	
	public static int getScaledHeight() {
		return (int) (HEIGHT * SCALE);		
	}
	
	public static double getScale() {
		return SCALE;
	}
	
	public static float getCenterWidth() {
		return (float) (WIDTH / 2); 
	}
	
	public static float getCenterHeight() {
		return (float) (HEIGHT / 2); 
	}
	

}
