package com.dressmeup.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dressmeup.configs.GameConfigs;
import com.dressmeup.enums.GameStates;
import com.dressmeup.game.DressMeUp;
import com.dressmeup.utils.MenuButton;

public class StatePause extends AbstractGameState {
	
	private final boolean DEBUG = false;
	private DressMeUp game;
	private Stage stage;
	private MenuButton menuButton, exitButton;
	private Table table;
	private Texture filter;
	
	public StatePause(DressMeUp game) {
		this.game = game;
		stage = new Stage();
		table = new Table(game.getSkinManager().getSkin());
		filter = new Texture(Gdx.files.internal("bg_tp.png"));
		setupButtons();
		table.setDebug(DEBUG);
		table.setSize(GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());		
		table.setBackground("imgui_pause");
		table.row();
		table.add(menuButton).size(menuButton.getWidth(), menuButton.getHeight()).left();
		table.row();
		table.add(exitButton).size(exitButton.getWidth(), exitButton.getHeight()).left().padLeft(50);
		stage.addActor(table);
	}
	
	public void setupButtons() {
		int mult = 15;
		menuButton = new MenuButton("Resume", game.getSkinManager().getSkin());
		menuButton.setSize(16 * mult, 9 * mult);
		menuButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {			
				super.clicked(event, x, y);
				game.getGameStateSystem().setActualState(GameStates.GAME);
			}
		});
		exitButton = new MenuButton("Exit", game.getSkinManager().getSkin());
		exitButton.setSize(16 * mult, 9 * mult);
		exitButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {			
				super.clicked(event, x, y);
				game.getGameStateSystem().setActualState(GameStates.EXIT);
			}
		});
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render() {
		stage.getBatch().begin();
		stage.getBatch().draw(filter, 0, 0, GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());		
		stage.getBatch().end();
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
