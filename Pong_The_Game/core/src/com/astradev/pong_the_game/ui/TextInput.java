package com.astradev.pong_the_game.ui;

import com.astradev.pong_the_game.Pong;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class TextInput {

    private TextField ipField;
    private TextField portField;

    public TextInput(Skin skin) {
        ipField = new TextField("Ip", skin);
        ipField.setPosition(Pong.getWidth() / 2 - 50, Pong.getHeight() / 2 - 60);
        ipField.setSize(100, 50);


        portField = new TextField("Port", skin);
        portField.setPosition(Pong.getWidth() / 2 - 50, Pong.getHeight() / 2);
        portField.setSize(100, 50);
    }

    public TextField getIpField() {
        return ipField;
    }

    public TextField getPortField() {
        return portField;
    }
}
