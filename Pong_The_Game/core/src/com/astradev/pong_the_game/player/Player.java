package com.astradev.pong_the_game.player;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player implements GameObject{
    private int x;
    private int y;
    private Rectangle collider;
    private Pong pong;
    private int speed = 5;
    private Texture sprite;

    public Player(Pong pong, int x, int y) {
        this.x = x;
        this.y = y;
        this.pong = pong;
        sprite = new Texture("badlogic.jpg");
        setCollider();
    }

    public void setCollider(){
        collider = new Rectangle(x, y, 40, 100);
    }

    @Override
    public void tick() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            collider.setY(collider.getY() + speed);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            collider.setY(collider.getY() - speed);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        batch.draw(sprite, collider.getX(), collider.getY());

    }

    @Override
    public void dispose() {

        sprite.dispose();

    }

    @Override
    public void setGameLoop(Pong gameLoop) {
        pong = gameLoop;
    }
}
