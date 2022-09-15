package com.astradev.pong_the_game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class IpInput {

    private TextField textField;
    private Skin skin;

    public IpInput() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        textField = new TextField("", skin);
        textField.setMessageText("IP");
        textField.setPosition(30, 30);
    }

    public String getText(){
        return textField.getText();
    }

    public void printText(){
        System.out.println(getText());
    }
}
