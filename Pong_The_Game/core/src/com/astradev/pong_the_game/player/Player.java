package com.astradev.pong_the_game.player;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player implements GameObject{
    private int x;
    private int y;
    private Rectangle collider;
    private Pong pong;
    private float speed = 5;
    private Texture sprite;
    private ShapeRenderer rectShape;
    private int score;

    private int upKey = Input.Keys.UP;
    private int downKey = Input.Keys.DOWN;

    private boolean goingDown = false;
    private boolean goingUp = false;
    private boolean stopped = true;

    public Player(Pong pong, int x, int y) {
        this.x = x;
        this.y = y;
        this.pong = pong;
        sprite = new Texture("badlogic.jpg");
        rectShape = new ShapeRenderer();
        rectShape.setAutoShapeType(true);

        setCollider();
    }

    public void setCollider(){
        collider = new Rectangle(x, y, 40, 100);
    }

    public void drawRect() {
        rectShape.begin(ShapeRenderer.ShapeType.Filled);
        rectShape.rect(collider.getX(), collider.getY(), collider.getWidth(), collider.getHeight());
        rectShape.setColor(Color.WHITE);
        rectShape.end();
    }

    @Override
    public void tick() {
        if(Gdx.input.isKeyPressed(getUpKey()) && collider.getY() + collider.getHeight() < pong.getHeight()){
            setY(getY() + getSpeed());
            setGoingUp();

        }
        if(Gdx.input.isKeyPressed(getDownKey()) && collider.getY() > 0){
            setY(getY() - getSpeed());
            setGoingDown();
        }
        if(!Gdx.input.isKeyPressed(getDownKey()) && !Gdx.input.isKeyPressed(getUpKey())){
            setStopped();
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        drawRect();

    }

    @Override
    public void dispose() {

        sprite.dispose();

    }

    @Override
    public void setGameLoop(Pong gameLoop) {
        pong = gameLoop;
    }

    public int getUpKey() {
        return upKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public int getScore() {
        return score;
    }

    public void gainScore(int score) {
        this.score += score;
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

    public void setCollider(Rectangle collider) {
        this.collider = collider;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isGoingDown() {
        return goingDown;
    }

    public void setGoingDown() {
        this.goingDown = true;
        stopped = false;
        goingUp = false;
    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public void setGoingUp() {
        this.goingUp = true;
        stopped = false;
        goingDown = false;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped() {
        this.stopped = true;
        goingUp = false;
        goingDown = false;
    }
}
