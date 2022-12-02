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

public class StateMenu extends AbstractGameState {
	
	private DressMeUp game;
	private Stage stage;	
	private GameStates state = GameStates.MENU;
	private Texture logo, background, filter;
	
	public StateMenu(DressMeUp game) {
		super();		
		this.game = game;
		stage = new Stage();
		create();
		logo = new Texture(Gdx.files.internal("logo.png"));
		background = new Texture(Gdx.files.internal("cenario_externo_fabuloso_atelie_aberto.png"));
		filter = new Texture(Gdx.files.internal("bg_tp.png"));
		generateMenu();
	}
	
	private void generateMenu() {		
		Table table = new Table();
		
		table.setY(0);
		table.setX(0);
		table.setHeight(500);
		table.setWidth(GameConfigs.getScaledWidth());
		
		MenuButton startBtn = new MenuButton(
				"New Game", game.getSkinManager().getSkin(),
				GameConfigs.getCenterWidth() - 100,
				GameConfigs.getCenterHeight() + 75);
		startBtn.addListener(getMenuChangeListener(GameStates.GAME));
		
		table.add(startBtn).size(startBtn.getWidth(), startBtn.getHeight()).left();
		//table.row();
		//stage.addActor(startBtn);	
		
		MenuButton exitBtn = new MenuButton(
				"Exit", game.getSkinManager().getSkin(),
				GameConfigs.getCenterWidth() - 100,
				GameConfigs.getCenterHeight() - 75);
		exitBtn.addListener(getMenuChangeListener(GameStates.EXIT));
		//stage.addActor(exitBtn);
		
		table.add(exitBtn).size(exitBtn.getWidth(), exitBtn.getHeight()).left().padLeft(50);
		
		table.center();
			
		stage.addActor(table);
	}
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(stage);		
	}
	
	@Override
	public void render() {	
		stage.act();

		stage.getBatch().begin();
		stage.getBatch().draw(background, 0, 0, GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());
		stage.getBatch().draw(filter, 0, 0, GameConfigs.getScaledWidth(), GameConfigs.getScaledHeight());		
		stage.getBatch().draw(logo, GameConfigs.getCenterWidth() - logo.getWidth()/2 + 10, GameConfigs.getCenterHeight() - logo.getHeight()/2);
		stage.getBatch().end();
		
		stage.draw();		
	}
	
	
	@Override
	public void tick() {	
		
	}
	
	@Override
	public void dispose() {
		
	}
	
	public ClickListener getMenuChangeListener(final GameStates gamestate) {
		return new ClickListener() {			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);		
				game.getGameStateSystem().setActualState(gamestate);		
			}			
		};
	}

	public GameStates getState() {
		return state;
	}

}
