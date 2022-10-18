package com.marinc.entities;

import java.awt.image.BufferedImage;

public class Bow extends Weapons{
	
	public static int bowDamage = 5;

	public Bow(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}

}
