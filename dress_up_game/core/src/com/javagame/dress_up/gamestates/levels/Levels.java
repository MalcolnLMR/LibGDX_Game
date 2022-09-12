package com.javagame.dress_up.gamestates.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Levels {

    void render(SpriteBatch batch);
    void tick();
    void dispose();

}
