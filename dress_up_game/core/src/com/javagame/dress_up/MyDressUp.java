package com.javagame.dress_up;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javagame.dress_up.gameobjects.MovableObject;

import java.util.HashMap;

public class MyDressUp extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private HashMap<String, MovableObject> objects = new HashMap<String, MovableObject>();
	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		objects.put("badLogic1", new MovableObject(this, 0, 0, img.getWidth(), img.getHeight()));
		objects.get("badLogic1").setSprite(img);
		objects.get("badLogic1").getCollider().setY(800-img.getHeight());

		objects.put("badLogic2", new MovableObject(this, 0, 0, img.getWidth(), img.getHeight()));
		objects.get("badLogic2").setSprite(img);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1600, 800);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5F, 0,0.25F, 1);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		for(MovableObject obj : objects.values()){
			obj.render(batch);
		}

		batch.end();

		for(MovableObject obj : objects.values()){
			obj.tick();
			if(obj.isHold()) break;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();

		for(MovableObject obj : objects.values()){
			obj.dispose();
		}
	}

	public OrthographicCamera getCamera() {
		return camera;
	}


}
