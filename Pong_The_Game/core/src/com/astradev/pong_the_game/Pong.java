package com.astradev.pong_the_game;

import com.astradev.pong_the_game.player.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Pong extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player(this, 10, 10);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0,0,0,1);
		batch.begin();
		player.render(batch);
		batch.end();

		player.tick();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
