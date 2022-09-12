package com.javagame.dress_up;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javagame.dress_up.gamestates.GameLoop;

public class MyDressUp extends ApplicationAdapter {
	private double scale = 0.75;
	private int halfScreenX;
	private int halfScreenY;
	private int width = (int) (1600 * scale);
	private int height = (int) (900 * scale);
	private SpriteBatch batch;
	private OrthographicCamera camera;

	private GameLoop game;

	@Override
	public void create () {
		halfScreenX = (int) (width / 2);
		halfScreenY = (int) (height / 2);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (float) (width), (float) (height));
		game = new GameLoop(this);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5F, 0,0.25F, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		game.render(batch);

		batch.end();

		game.tick();
	}

	@Override
	public void dispose () {

		batch.dispose();

	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public double getScale() {
		return scale;
	}

	public int getHalfScreenX() {
		return halfScreenX;
	}

	public int getHalfScreenY() {
		return halfScreenY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
