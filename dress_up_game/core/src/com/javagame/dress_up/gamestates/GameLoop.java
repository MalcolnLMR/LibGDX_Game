package com.javagame.dress_up.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javagame.dress_up.MyDressUp;
import com.javagame.dress_up.gamestates.levels.Level1;

public class GameLoop implements GameStates{


    public Level1 level1;

    public GameLoop(MyDressUp gameLoop){

        level1 = new Level1(gameLoop);
        
    }

    @Override
    public void render(SpriteBatch batch) {

        level1.render(batch);

    }

    @Override
    public void tick() {

        level1.tick();

    }
}
