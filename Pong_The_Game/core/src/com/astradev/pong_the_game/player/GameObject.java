package com.astradev.pong_the_game.player;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface GameObject {

    Texture sprite = null;

    void tick();
    void render(SpriteBatch batch);
    void dispose();
    void setGameLoop(Pong gameLoop);

}
