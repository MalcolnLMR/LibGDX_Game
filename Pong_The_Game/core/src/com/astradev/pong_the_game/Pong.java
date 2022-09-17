package com.astradev.pong_the_game;

import com.astradev.pong_the_game.multiplayer.Client;
import com.astradev.pong_the_game.multiplayer.Server;
import com.astradev.pong_the_game.player.Ball;
import com.astradev.pong_the_game.player.Player;
import com.astradev.pong_the_game.scenes.GamePlay;
import com.astradev.pong_the_game.scenes.Menu;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.HashMap;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;
	private int width = 1600;
	private int height = 900;
	private double scale = 0.75;

	private GamePlay gamePlay;
	private Menu menu;

	private HashMap<String, Object> gameStates = new HashMap<>();
	public String gameState = "menu";


	
	@Override
	public void create () {
		batch = new SpriteBatch();

		gamePlay = new GamePlay(this);
		gameStates.put("game", gamePlay);
		menu = new Menu(this);
		gameStates.put("menu", menu);

	}

	@Override
	public void render () {
		batch.begin();

		if(gameState == "menu"){
			menu.render(batch);
		} else if (gameState == "game") {
			gamePlay.render(batch);
		}

		batch.end();

		if(gameState == "menu"){
			menu.tick();
		} else if (gameState == "game") {
			gamePlay.tick();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public int getWidth() {
		return (int) (width * scale);
	}

	public int getHeight() {
		return (int) (height * scale);
	}

	public double getScale() {
		return scale;
	}
}

