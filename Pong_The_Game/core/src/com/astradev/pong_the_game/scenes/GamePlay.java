package com.astradev.pong_the_game.scenes;

import com.astradev.pong_the_game.Pong;
import com.astradev.pong_the_game.player.Ball;
import com.astradev.pong_the_game.player.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;

public class GamePlay implements Scene{
    private HashMap<String, Player> players = new HashMap<>();
    private Ball ball;
    private Pong pong;

    public GamePlay(Pong pong) {
        players.put("player_1", new Player(pong, 10, 10));
        players.put("player_2", new Player(pong, pong.getWidth() - 50, 10));

        players.get("player_2").setUpKey(Input.Keys.W);
        players.get("player_2").setDownKey(Input.Keys.S);

        ball = new Ball(pong, 500, 500);
        ball.setGamePlay(this);
    }

    @Override
    public void render(SpriteBatch batch) {
        ScreenUtils.clear(0,0,0,1);

        for (Player player : players.values()){
            player.render(batch);
        }

        ball.render(batch);
    }

    @Override
    public void tick() {

        for (Player player : players.values()){
            player.tick();
        }

        ball.tick();

    }

    @Override
    public void dispose() {

    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
