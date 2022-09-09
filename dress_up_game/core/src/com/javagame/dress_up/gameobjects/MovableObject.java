package com.javagame.dress_up.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.javagame.dress_up.MyDressUp;

public class MovableObject implements GameObject{

    private Rectangle collider;
    private boolean hold = false;
    public Texture sprite = null;

    private MyDressUp gameLoop;

    public MovableObject(MyDressUp gameLoop, float x, float y, float width, float height) {
        this.gameLoop = gameLoop;
        collider = new Rectangle();
        collider.setX(x);
        collider.setY(y);
        collider.setWidth(width);
        collider.setHeight(height);
    }

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public boolean isHold() {
        return hold;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public Texture getSprite() {
        return sprite;
    }

    public void setSprite(Texture sprite) {
        this.sprite = sprite;
    }

    @Override
    public void tick(){
        Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        mouse = gameLoop.getCamera().unproject(mouse);

        if (isHold()){
            collider.setX(mouse.x);
            collider.setY(mouse.y);
        }

        if(collider.contains(mouse.x, mouse.y) && Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) setHold(true);

        if(isHold() && !Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) setHold(false);
    }

    @Override
    public void render(SpriteBatch batch) {

        if (sprite != null){
            batch.draw(sprite, collider.getX(), collider.getY());
        }

    }

    @Override
    public void dispose() {
        sprite.dispose();
    }

    @Override
    public void setGameLoop(MyDressUp gameLoop) {
        this.gameLoop = gameLoop;
    }

}
