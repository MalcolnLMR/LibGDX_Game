package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class ClotheButton extends ImageButton {
	
	private AbstractClothes clothe;

	public ClotheButton(AbstractClothes clothe, float size, DressMeUp game) {	
		super(game.getSkinManager().getSkin(), "imgbtn_default");
		this.clothe = clothe;
		this.setSize(size, size);
		this.addListener(clothe.getClotheClickListener());
	}

	public AbstractClothes getClothe() {
		return clothe;
	}

}
