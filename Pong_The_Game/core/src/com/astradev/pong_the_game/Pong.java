package com.astradev.pong_the_game;

import com.astradev.pong_the_game.player.Player;
import com.astradev.pong_the_game.scenes.GamePlay;
import com.astradev.pong_the_game.scenes.Menu;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;
import java.util.HashMap;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;
	private HashMap<String, Player> players = new HashMap<>();
	private Menu menu;
	private static String gameState = "menu";
	public static int width = 1600;
	public static int height = 900;
	public static double scale = 0.75;
	private GamePlay gamePlay;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		gamePlay = new GamePlay(this);
		menu = new Menu(this);
		gameState = "menu";
	}

	@Override
	public void render () {
		batch.begin();

		if(gameState == "menu"){
			menu.render(Gdx.graphics.getDeltaTime());
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

	public static int getWidth() {
		return (int) (width * scale);
	}

	public static int getHeight() {
		return (int) (height * scale);
	}

	public static double getScale() {
		return scale;
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public static String getGameState() {
		return gameState;
	}

	public static void setGameState(String gameState) {
		Pong.gameState = gameState;
	}
}

