package com.dressmeup.entities.clothes;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class EarRings extends AbstractClothes {
	
	public static final int NEW_CLOTHE_INDEX = 3;

	public EarRings(DressMeUp game) {
		super(game);
		ref = "imgbtn_shirt";
	}
	
	public EarRings(DressMeUp game, String clothePath, String iconPath, String ref) {
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
