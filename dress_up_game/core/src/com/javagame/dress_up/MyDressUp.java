package com.javagame.dress_up;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javagame.dress_up.gameobjects.MovableObject;

public class MyDressUp extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	MovableObject badLogic;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		badLogic = new MovableObject(0,0,img.getWidth(), img.getHeight());
		badLogic.setSprite(img);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		badLogic.render(batch);
		batch.end();

		badLogic.tick();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

		img.dispose();
	}
}
