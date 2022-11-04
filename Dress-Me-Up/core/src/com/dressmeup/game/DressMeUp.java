package com.dressmeup.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dressmeup.systems.ClothesSystem;
import com.dressmeup.systems.DialogSystem;
import com.dressmeup.systems.GameStateSystem;
import com.dressmeup.systems.SaveSystem;
import com.dressmeup.systems.ScoreSystem;
import com.dressmeup.utils.SkinsManager;

public class DressMeUp extends ApplicationAdapter {
	SpriteBatch batch;
	
	private GameStateSystem gameStateSystem;
	private SaveSystem saveSystem;
	private ScoreSystem scoreSystem;
	private DialogSystem dialogSystem;
	private SkinsManager skinManager;
	private ClothesSystem clothesSystem;
	
	@Override
	public void create () {	
		this.skinManager = new SkinsManager(this);
		this.clothesSystem = new ClothesSystem(this);	
		this.gameStateSystem = new GameStateSystem(this);
		this.saveSystem = new SaveSystem(this);
		this.scoreSystem = new ScoreSystem(this);
		this.dialogSystem = new DialogSystem(this);	
		
		batch = new SpriteBatch();
	}

	@Override
	public void render () {		
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		switch (gameStateSystem.getActualState()) {
			case MENU:
				gameStateSystem.getMenu().render();
				gameStateSystem.getMenu().tick();
				break;
			case GAME:
				gameStateSystem.getGame().render();
				gameStateSystem.getGame().tick();
				break;
			case PAUSE:
				gameStateSystem.getGame().render();
				gameStateSystem.getPause().render();
				gameStateSystem.getPause().tick();
				break;
			case EXIT:
				Gdx.app.exit();
				break;
			default:				
				break;
		}
		
	}
	
	@Override
	public void dispose () {
		gameStateSystem.dispose();		
	}

	public GameStateSystem getGameStateSystem() {
		return gameStateSystem;
	}

	public SaveSystem getSaveSystem() {
		return saveSystem;
	}

	public ScoreSystem getScoreSystem() {
		return scoreSystem;
	}

	public DialogSystem getDialogSystem() {
		return dialogSystem;
	}

	public SkinsManager getSkinManager() {
		return skinManager;
	}

	public ClothesSystem getClothesSystem() {
		return clothesSystem;
	}
}
