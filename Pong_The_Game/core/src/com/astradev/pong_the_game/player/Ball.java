package com.astradev.pong_the_game.player;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ball implements GameObject{

    private float x;
    private float y;
    private float width;
    private float height;
    private Rectangle collider;
    private ShapeRenderer rectShape;
    private int speedX, speedY;
    private Pong pong;

    public Ball(Pong pong, int x, int y) {
        this.pong = pong;
        collider = new Rectangle();
        setX(x);
        setY(y);
        setWidth(5);
        setHeight(5);
        setSpeedX(2);
        setSpeedY(2);
        rectShape = new ShapeRenderer();
        rectShape.setAutoShapeType(true);
    }

    public void drawRect(){
        rectShape.begin(ShapeRenderer.ShapeType.Filled);
        rectShape.rect(collider.getX(), collider.getY(), collider.getWidth(), collider.getHeight());
        rectShape.setColor(Color.WHITE);
        rectShape.end();
    }

    @Override
    public void tick() {
        if (getX() + getSpeedX() > pong.getWidth()){
            setSpeedX(getSpeedX() * -1);
        }
        if (getSpeedX() + getX() < 0) {
            setSpeedX(getSpeedX() * -1);
        }

        for (Player player : pong.getPlayers().values()){
            if (collider.contains(player.getCollider())){
                setSpeedX(getSpeedX() * -1);
                player.gainScore(1);
            }
        }

        if (getY() + getSpeedY() > pong.getHeight()){
            setSpeedY(getSpeedY() * -1);
        }
        if (getSpeedY() + getY() < 0) {
            setSpeedY(getSpeedY() * -1);
        }

        setX(getX() + getSpeedX());
        setY(getY() + getSpeedY());
    }

    @Override
    public void render(SpriteBatch batch) {
        drawRect();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void setGameLoop(Pong gameLoop) {

    }

    public float getX() {
        return collider.getX();
    }

    public void setX(float x) {
        this.collider.setX(x);
    }

    public float getY() {
        return collider.getY();
    }

    public void setY(float y) {
        this.collider.setY(y);
    }

    public float getWidth() {
        return collider.getWidth();
    }

    public void setWidth(float width) {
        this.collider.setWidth(width);
    }

    public float getHeight() {
        return collider.getHeight();
    }

    public void setHeight(float height) {
        this.collider.setHeight(height);
    }

    public Rectangle getCollider() {
        return collider;
    }

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
