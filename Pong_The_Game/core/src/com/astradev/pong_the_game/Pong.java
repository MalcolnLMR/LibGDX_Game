package com.astradev.pong_the_game;

import com.astradev.pong_the_game.player.Ball;
import com.astradev.pong_the_game.player.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;

	private HashMap<String, Player> players = new HashMap<>();
	private Ball ball;

	private int width = 1600;
	private int height = 900;
	private double scale = 0.75;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player(this, 10, 10);
		players.put("player_1", player);
		ball = new Ball(this, 500, 500);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0,0,0,1);
		batch.begin();

		for (Player player : players.values()){
			player.render(batch);
		}

		ball.render(batch);

		batch.end();

		for (Player player : players.values()){
			player.tick();
		}

		ball.tick();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (Player player : players.values()){
			player.dispose();
		}
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

	public HashMap<String, Player> getPlayers() {
		return players;
	}
}

