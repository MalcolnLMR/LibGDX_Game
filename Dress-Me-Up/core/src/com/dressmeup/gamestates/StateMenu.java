package com.dressmeup.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.enums.GameStates;
import com.dressmeup.game.DressMeUp;

public class StateMenu extends AbstractGameState {
	
	private DressMeUp game;
	private Stage stage;	
	private GameStates state = GameStates.MENU;
	
	public StateMenu(DressMeUp game) {
		super();		
		this.game = game;
		stage = new Stage();
		create();
		generateMenu();
	}
	
	private void generateMenu() {		
		TextButton startBtn = new TextButton("New Game", game.getSkinManager().getSkin());
		startBtn.setWidth(200);
		startBtn.setHeight(100);
		startBtn.setX(GameConfigs.getCenterWidth() - 100);
		startBtn.setY(GameConfigs.getCenterHeight() + 75);
		//startBtn.getLabel().setFontScale(2);
		startBtn.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				game.getGameStateSystem().setActualState(GameStates.GAME);
		}
			
		});
		stage.addActor(startBtn);		
		

		TextButton exitBtn = new TextButton("Exit", game.getSkinManager().getSkin());
		exitBtn.setWidth(200);
		exitBtn.setHeight(100);
		exitBtn.setX(GameConfigs.getCenterWidth() - 100);
		exitBtn.setY(GameConfigs.getCenterHeight() - 75);
		//exitBtn.getLabel().setFontScale(2);
		exitBtn.addListener(new ClickListener() {			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);		
				game.getGameStateSystem().setActualState(GameStates.EXIT);		
			}			
		});
		stage.addActor(exitBtn);		
	}
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);		
	}
	
	@Override
	public void render() {	
		stage.act();
		stage.draw();		
	}
	
	
	@Override
	public void tick() {	
		
	}
	
	@Override
	public void dispose() {
		
	}

	public GameStates getState() {
		return state;
	}

}
