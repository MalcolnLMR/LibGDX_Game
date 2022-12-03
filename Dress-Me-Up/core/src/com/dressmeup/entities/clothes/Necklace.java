package com.dressmeup.entities.clothes;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Necklace extends AbstractClothes {
	
	public static final int CLOTHE_INDEX = 4;
	public static final int NEW_CLOTHE_INDEX = 1;

	public Necklace(DressMeUp game) {
		super(game);
		//setClothe("Roupas/colar.png");
		//setIcon("Roupas/colar_icon.png");
		ref = "imgbtn_necklace";	
		//setClotheBtnTexture();
		//setScaledClothe();
		//itSelf = this;
	}
	
	public Necklace(DressMeUp game, String clothePath, String iconPath, String ref) {
		super(game, clothePath, iconPath, ref, NEW_CLOTHE_INDEX);
		setClothe(clothePath);
		setIcon(iconPath);
		setRef(ref);
		setup();
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
	}
	
	@Override
	public AbstractClothes getSelf() {
		return this;
	}	
}