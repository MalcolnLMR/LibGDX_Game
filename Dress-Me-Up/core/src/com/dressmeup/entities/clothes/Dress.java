package com.dressmeup.entities.clothes;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Dress extends AbstractClothes {
	
	public static final int NEW_CLOTHE_INDEX = 6;

	public Dress(DressMeUp game) {
		super(game);
		ref = "imgbtn_shirt";
	}
	
	public Dress(DressMeUp game, String clothePath, String iconPath, String ref) {
		super(game, clothePath, iconPath, ref, NEW_CLOTHE_INDEX);
		setClothe(clothePath);
		setIcon(iconPath);
		setRef(ref);
		setup();
	}
	
	@Override
	public void setup() {
		super.setup();
	}

	@Override
	public AbstractClothes getSelf() {
		return this;
	}
}
