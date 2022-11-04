package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.dressmeup.entities.AbstractClothes;

public class IconButton extends ImageButton {

	public IconButton(AbstractClothes clothe, float size) {		
		super(clothe.getIconDrawable((int) size));
		this.setSize(size, size);
		this.addListener(clothe.getIconClickListener());
	}

}
