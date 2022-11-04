package com.dressmeup.gamestates;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.entities.AbstractClothes;
import com.dressmeup.entities.clothes.Hairs;
import com.dressmeup.entities.clothes.Skirts;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.utils.ClotheButton;
import com.dressmeup.utils.IconButton;

public class StateGame extends AbstractGameState {
	
	private static final int CATEGORY_BUTTON_SIZE = 100;
	private static final int CLOTHE_BUTTON_SIZE = 250;
	private static final int CATEGORY_BUTTON_PADDING = 5;
	private static final int CLOTHE_BUTTON_PADDING = 5;
	private final boolean DEBUG = true;
	private List<Class<? extends AbstractClothes>> clothes;
	private int actualPage = 0;
	private Stage stage;
	private Boolean active;	
	private DressMeUp game;
	private Table clickableClothes;
	
	public StateGame(DressMeUp game) {		
		this.game = game;
		stage = new Stage();	
		clothes = Arrays.asList(
				Skirts.class,
				Hairs.class
				);				
		setupProportions();
	}	
	
	public void setupProportions() {
		stage.clear();
		
		Table clothesOrigin = new Table();
		
		//clothesOrigin.setY(GameConfigs.getScaledHeight() - CATEGORY_BUTTON_SIZE/2);
		clothesOrigin.setY(0);
		clothesOrigin.setX((float) (GameConfigs.getScaledWidth() * 0.3));
		clothesOrigin.setWidth((float) (GameConfigs.getScaledWidth() * 0.7));
		clothesOrigin.setHeight(GameConfigs.getScaledHeight());
		clothesOrigin.top().left();		
		
		// Making Icons
		
		Table categoryIcons = new Table();		
		categoryIcons.left();
		
		for(String key : game.getClothesSystem().getIconKeys()) {
			categoryIcons.add(new IconButton(game.getClothesSystem().getClothe(key), CATEGORY_BUTTON_SIZE))
			.padRight(CATEGORY_BUTTON_PADDING)
			.left();
		}		
		
		clothesOrigin.add(categoryIcons).left();
		clothesOrigin.row();	
		
		// Making clickable clothes
		
		clickableClothes = new Table();
				
		for(String key : game.getClothesSystem().getClotheKeys()) {
			ClotheButton button = new ClotheButton(game.getClothesSystem().getClothe(key), CLOTHE_BUTTON_SIZE);
			if(button.getClothe().getClass().equals(clothes.get(actualPage)) ) {
				clickableClothes.add(button)
				.padRight(CLOTHE_BUTTON_PADDING)
				.left();				
			}
		}
		
		clothesOrigin.add(clickableClothes).padTop(50);		
		
		clothesOrigin.setDebug(DEBUG);
		categoryIcons.setDebug(DEBUG);
		clickableClothes.setDebug(DEBUG);
		
		
		stage.addActor(clothesOrigin);
	}
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);		
	}

	@Override
	public void render() {
		stage.draw();
	}
	
	@Override
	public void tick() {	
		stage.act();
	}
	
	@Override
	public void dispose() {
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
		setupProportions();
	}

	public Table getClickableClothes() {
		return clickableClothes;
	}

	public void setClickableClothes(Table clickableClothes) {
		this.clickableClothes = clickableClothes;
	}

}
