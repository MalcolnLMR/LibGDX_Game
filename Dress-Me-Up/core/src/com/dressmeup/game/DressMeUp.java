package com.dressmeup.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.dressmeup.database.Database;
import com.dressmeup.systems.ClothesSystem;
import com.dressmeup.systems.CustomerSystem;
import com.dressmeup.systems.GameStateSystem;
import com.dressmeup.systems.SaveSystem;
import com.dressmeup.systems.ScoreSystem;
import com.dressmeup.utils.SkinsManager;

public class DressMeUp extends ApplicationAdapter {
	
	private GameStateSystem gameStateSystem;
	private SaveSystem saveSystem;
	private ScoreSystem scoreSystem;
	private CustomerSystem customerSystem;
	private SkinsManager skinManager;
	private ClothesSystem clothesSystem;
	private Database database;
	
	@Override
	public void create () {	
		this.database = new Database(this);
		this.skinManager = new SkinsManager(this);
		this.clothesSystem = new ClothesSystem(this);	
		this.customerSystem = new CustomerSystem(this);	
		this.saveSystem = new SaveSystem(this);
		this.scoreSystem = new ScoreSystem(this);
		this.gameStateSystem = new GameStateSystem(this);
		
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

	public CustomerSystem getCustomerSystem() {
		return customerSystem;
	}

	public SkinsManager getSkinManager() {
		return skinManager;
	}

	public ClothesSystem getClothesSystem() {
		return clothesSystem;
	}

	public Database getDatabase() {
		return database;
	}
}
