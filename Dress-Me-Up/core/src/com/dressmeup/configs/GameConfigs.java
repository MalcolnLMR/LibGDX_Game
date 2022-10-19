package com.dressmeup.configs;

public class GameConfigs {
	
	private static final double width = 1600;
	private static final double height = 800;
	private static final double scale = 1;
	
	public static int getScaledWidth() {
		return (int) (width * scale);		
	}
	
	public static int getScaledHeight() {
		return (int) (height * scale);		
	}
	
	public static double getScale() {
		return scale;
	}
	

}
