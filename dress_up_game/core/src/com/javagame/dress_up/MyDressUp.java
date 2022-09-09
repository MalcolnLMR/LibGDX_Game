package com.javagame.dress_up;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javagame.dress_up.gameobjects.MovableObject;

public class MyDressUp extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private MovableObject badLogic;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		badLogic = new MovableObject(this, 0, 0, img.getWidth(), img.getHeight());
		badLogic.setSprite(img);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 800);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		badLogic.render(batch);
		batch.end();

		badLogic.tick();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		badLogic.dispose();
	}

	public OrthographicCamera getCamera() {
		return camera;
	}
}
