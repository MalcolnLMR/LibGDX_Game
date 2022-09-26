package com.astradev.pong_the_game;

import com.astradev.pong_the_game.multiplayer.Client;
import com.astradev.pong_the_game.multiplayer.Server;
import com.astradev.pong_the_game.player.Ball;
import com.astradev.pong_the_game.player.Player;
<<<<<<< Updated upstream
import com.astradev.pong_the_game.scenes.GamePlay;
=======
>>>>>>> Stashed changes
import com.astradev.pong_the_game.scenes.Menu;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.HashMap;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;
<<<<<<< Updated upstream
	private int width = 1600;
	private int height = 900;
	private double scale = 0.75;

	private GamePlay gamePlay;
	private Menu menu;

	private HashMap<String, Object> gameStates = new HashMap<>();
	public String gameState = "menu";


=======
	private HashMap<String, Player> players = new HashMap<>();
	private Ball ball;
	private Menu menu;
	private static String gameState = "menu";
	public static int width = 1600;
	public static int height = 900;
	public static double scale = 0.75;
>>>>>>> Stashed changes
	
	@Override
	public void create () {
		batch = new SpriteBatch();
<<<<<<< Updated upstream

		gamePlay = new GamePlay(this);
		gameStates.put("game", gamePlay);
		menu = new Menu(this);
		gameStates.put("menu", menu);

=======
		players.put("player_1", new Player(this, 10, 10));
		players.get("player_1").setUpKey(Input.Keys.W);
		players.get("player_1").setDownKey(Input.Keys.S);
		players.put("player_2", new Player(this, getWidth() - 50, 10));
		ball = new Ball(this, 500, 500);

		menu = new Menu(this);
		gameState = "menu";
>>>>>>> Stashed changes
	}

	@Override
	public void render () {
		batch.begin();

<<<<<<< Updated upstream
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
=======
		if (gameState == "game"){

			// RENDER

			for (Player player : players.values()){
				player.render(batch);
			}

			ball.render(batch);

			batch.end();

			// TICK

			for (Player player : players.values()){
				player.tick();
			}

			ball.tick();

		} else if (gameState == "menu"){

			// RENDER

			menu.render(Gdx.graphics.getDeltaTime());

			batch.end();

			// TICK

			menu.tick();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public static String getGameState() {
		return gameState;
	}

	public static void setGameState(String gameState) {
		Pong.gameState = gameState;
	}
>>>>>>> Stashed changes
}

