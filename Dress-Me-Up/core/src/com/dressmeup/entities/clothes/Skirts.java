package com.dressmeup.entities.clothes;

import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Skirts extends AbstractClothes{
	
	public static final int NEW_CLOTHE_INDEX = 2;
	
	public Skirts(DressMeUp game) {
		super(game);
		//setClothe("Roupas/saia.png");
		//setIcon("Roupas/saia.png");
		ref = "imgbtn_skirt";
		//setClotheBtnTexture();
		//setScaledClothe();
		//itSelf = this;
	}
	
	public Skirts(DressMeUp game, String clothePath, String iconPath, String ref) {
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