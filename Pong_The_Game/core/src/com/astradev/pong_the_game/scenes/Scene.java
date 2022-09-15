package com.astradev.pong_the_game.scenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Scene {

    void render(SpriteBatch batch);
    void tick();

}
