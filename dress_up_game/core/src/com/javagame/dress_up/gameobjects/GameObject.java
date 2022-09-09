package com.javagame.dress_up.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javagame.dress_up.MyDressUp;

public interface GameObject {

    Texture sprite = null;

    public void tick();
    public void render(SpriteBatch batch);
    public void dispose();
    public void setGameLoop(MyDressUp gameLoop);


}
