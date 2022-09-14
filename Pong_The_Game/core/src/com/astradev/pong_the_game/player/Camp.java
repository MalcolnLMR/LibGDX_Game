package com.astradev.pong_the_game.player;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ScreenUtils;

public class Camp implements GameObject{

    private Pong pong;

    public Camp(Pong pong) {
        this.pong = pong;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(SpriteBatch batch) {

        ScreenUtils.clear(0,0,0,1);

    }

    @Override
    public void dispose() {



    }

    @Override
    public void setGameLoop(Pong gameLoop) {
        pong = gameLoop;
    }
}
