package com.dressmeup.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.dressmeup.configs.GameConfigs;

public class MenuButton extends TextButton {

	public MenuButton(String text, Skin skin, float x, float y) {
		super(text, skin);
		this.setSize(
				(float) (GameConfigs.getScaledWidth() * 0.1),
				(float) (GameConfigs.getScaledHeight() * 0.1)
				);				
		this.setX(x);
		this.setY(y);
	}
}
