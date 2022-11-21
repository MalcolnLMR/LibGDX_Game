package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class IconButton extends ImageButton {

	public IconButton(AbstractClothes clothe, float size, DressMeUp game) {		
		super(game.getSkinManager().getSkin(), "imgbtn_icon");
		this.setSize(size, size);
		this.getImage().setFillParent(true);
		this.addListener(clothe.getIconClickListener());
	}

}
