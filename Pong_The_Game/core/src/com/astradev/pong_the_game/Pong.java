package com.astradev.pong_the_game;

import com.astradev.pong_the_game.multiplayer.Client;
import com.astradev.pong_the_game.multiplayer.Server;
import com.astradev.pong_the_game.player.Ball;
import com.astradev.pong_the_game.player.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.HashMap;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;

	private HashMap<String, Player> players = new HashMap<>();
	private Ball ball;

	private int width = 1600;
	private int height = 900;
	private double scale = 0.75;

	private Server server;
	private Client client;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		players.put("player_1", new Player(this, 10, 10));
		players.put("player_2", new Player(this, getWidth() - 50, 10));
		players.get("player_2").setUpKey(Input.Keys.W);
		players.get("player_2").setDownKey(Input.Keys.S);
		ball = new Ball(this, 500, 500);

		/*
		server = new Server();
		try {
			server.start(6666);
		} catch (IOException ignored) {

		}
		client = new Client();
		try {
			client.startConnection();
		} catch (IOException ignored) {

		}*/
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

