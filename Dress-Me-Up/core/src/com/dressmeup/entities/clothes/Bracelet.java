package com.dressmeup.entities.clothes;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Bracelet extends AbstractClothes {
	
	public static final int CLOTHE_INDEX = 0;

	public Bracelet(DressMeUp game) {
		super(game);		
		setClothe("Place_holders/Category_Icons/Bracelet.png");
		setIcon("Place_holders/Category_Icons/Bracelet.png");
		ref = "imgbtn_bracelet";		
		setClotheBtnTexture();
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
