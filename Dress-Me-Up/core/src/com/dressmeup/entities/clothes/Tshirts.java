package com.dressmeup.entities.clothes;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Tshirts extends AbstractClothes {
	
	public static final int CLOTHE_INDEX = 8;

	public Tshirts(DressMeUp game) {
		super(game);
		setClothe("Place_holders/Category_Icons/Tshirt.png");
		setIcon("Place_holders/Category_Icons/Tshirt.png");
	}

	@Override
	public ClickListener getIconClickListener() {
		return new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getGameStateSystem().getGame().setActualPage(CLOTHE_INDEX);
			}
		};
	}

	@Override
	public ClickListener getClotheClickListener() {
		return new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
			}
		};
	}

}
