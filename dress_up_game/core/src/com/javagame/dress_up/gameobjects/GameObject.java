package com.javagame.dress_up.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javagame.dress_up.MyDressUp;

public interface GameObject {

    Texture sprite = null;

    void tick();
    void render(SpriteBatch batch);
    void dispose();
    void setGameLoop(MyDressUp gameLoop);


}
