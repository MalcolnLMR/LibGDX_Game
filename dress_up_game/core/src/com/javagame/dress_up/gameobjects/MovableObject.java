package com.javagame.dress_up.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MovableObject implements GameObject{

    private Rectangle collider;
    private boolean hold = false;
    public Texture sprite = null;

    public MovableObject(float x, float y, float width, float height) {
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
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());

        if (isHold()){
            collider.setX(mouse.x);
            collider.setY(mouse.y);
        }

        if(collider.contains(mouse) && Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) setHold(true);

        if(isHold() && Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) setHold(false);
    }

    @Override
    public void render(SpriteBatch batch) {

        if (sprite != null){
            batch.draw(sprite, collider.getX(), collider.getY());
        }

    }

}
