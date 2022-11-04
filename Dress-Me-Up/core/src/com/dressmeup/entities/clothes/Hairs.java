package com.dressmeup.entities.clothes;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.game.DressMeUp;

public class Hairs extends AbstractClothes {
	
	private DressMeUp game;
	
	public Hairs(DressMeUp game) {
		this.game = game;		
	}


	@Override
	public ClickListener getIconClickListener() {		
		return new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getGameStateSystem().getGame().setActualPage(1);;		
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
