package com.astradev.pong_the_game.scenes;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.astradev.pong_the_game.ui.TextInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Menu implements Screen {
/*
<<<<<<< Updated upstream
    private String ip = "";
    private int port = 6666;
    private Pong pong;

    private HashMap<String, ShapeRenderer> buttons = new HashMap<>();
    private HashMap<String, Rectangle> rects = new HashMap<>();
    private List<String> names = new ArrayList<>();

    private ShapeRenderer buttonSolo;
    private ShapeRenderer buttonConnect;
    private ShapeRenderer buttonHost;

    private int i = 0;


    public Menu(Pong pong) {
        this.pong = pong;

        buttonConnect = new ShapeRenderer();
        buttonConnect.setAutoShapeType(true);
        buttons.put("connect", buttonConnect);
        Rectangle rect_1 = new Rectangle(pong.getWidth()/2 - 85, pong.getHeight()/2 + 25,50,50);
        rects.put("connect", rect_1);
        names.add("connect");

        buttonSolo = new ShapeRenderer();
        buttonSolo.setAutoShapeType(true);
        buttons.put("solo", buttonSolo);
        Rectangle rect_2 = new Rectangle(pong.getWidth()/2 - 85, pong.getHeight()/2 + 25,50,50);
        rects.put("solo", rect_2);
        names.add("solo");

        buttonHost = new ShapeRenderer();
        buttonHost.setAutoShapeType(true);
        buttons.put("host", buttonHost);
        Rectangle rect_3 = new Rectangle(pong.getWidth()/2 - 85, pong.getHeight()/2 + 25,50,50);
        rects.put("host", rect_3);
        names.add("host");
    }

    public void drawButton(){
        buttonSolo.begin(ShapeRenderer.ShapeType.Filled);
        //buttonSolo.re


        i = 0;
        for (ShapeRenderer button : buttons.values()){
            button.begin(ShapeRenderer.ShapeType.Filled);
            button.rect(rects.get(names.get(i)).getX(), rects.get(names.get(i)).getY(),
                        rects.get(names.get(i)).getWidth(), rects.get(names.get(i)).getHeight());
            button.setColor(1,1,1,1);
            button.end();
            i += 1;
        }
        i = 0;
    }

    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0,0,0,1);
=======*/
    private Stage stage;
    private boolean show = false;
    private TextInput textInput;
    private Skin skin;
    private Pong pong;

    public Menu(Pong pong) {
        this.pong = pong;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        textInput = new TextInput(skin);

        Button btn_start = new Button();
        btn_start.setPosition(Pong.getWidth() / 2 - 50, Pong.getHeight() / 2 + 60);
        btn_start.setSize(100, 50);
        btn_start.setSkin(skin);

        stage.addActor(textInput.getIpField());
        stage.addActor(textInput.getPortField());
        //stage.addActor(btn_start);
    }

    public void tick() {

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Pong.setGameState("game");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
