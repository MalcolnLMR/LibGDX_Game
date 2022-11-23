package com.dressmeup.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.enums.GameStates;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.utils.MenuButton;

public class StatePause extends AbstractGameState {
	
	private DressMeUp game;
	private Stage stage;
	private MenuButton menuButton, exitButton;
	
	public StatePause(DressMeUp game) {
		this.game = game;
		stage = new Stage();
		setupButtons();
	}
	
	public void setupButtons() {
		stage.clear();
		menuButton = new MenuButton("Resume", game.getSkinManager().getSkin(), GameConfigs.getCenterWidth(), GameConfigs.getCenterHeight());
		menuButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {			
				super.clicked(event, x, y);
				game.getGameStateSystem().setActualState(GameStates.GAME);
			}
		});
		stage.addActor(menuButton);
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

	

}
