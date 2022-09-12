package com.javagame.dress_up.gamestates.levels;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.javagame.dress_up.MyDressUp;
import com.javagame.dress_up.gameobjects.MovableObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Level1 implements Levels{

    private Texture img;
    private HashMap<String, MovableObject> objects = new HashMap<String, MovableObject>();
    private List<String> keys = new ArrayList<String>();
    private List<String> keys_reversed = new ArrayList<String>();

    private MyDressUp gameLoop;

    public Level1(MyDressUp gameLoop){
        this.gameLoop = gameLoop;

        // FAZER ESCALA
        Pixmap pixmap200 = new Pixmap(Gdx.files.internal("badlogic.jpg"));
        Pixmap pixmap100 = new Pixmap((int) (256 * gameLoop.getScale()), (int) (256 * gameLoop.getScale()), pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        img = new Texture(pixmap100);
        pixmap200.dispose();
        pixmap100.dispose();

        //img = new Texture("badlogic.jpg");

        objects.put("badLogic1", new MovableObject(gameLoop, 0, 0, img.getWidth(), img.getHeight()));
        objects.get("badLogic1").setSprite(img);
        objects.get("badLogic1").getCollider().setY((gameLoop.getHeight() - img.getHeight()));
        keys.add("badLogic1");

        objects.put("badLogic2", new MovableObject(gameLoop, 0, 0, img.getWidth(), img.getHeight()));
        objects.get("badLogic2").setSprite(img);
        keys.add("badLogic2");

        keys_reversed.addAll(keys);
        Collections.reverse(keys_reversed);
    }

    public void toFront(String key){
        // Pega um elemento e coloca ele para desenhar primeiro na lista
        keys.remove(keys.indexOf(key));
        keys.add(key);

        keys_reversed.removeAll(keys);
        keys_reversed.addAll(keys);
        Collections.reverse(keys_reversed);
    }

    @Override
    public void render(SpriteBatch batch) {

        for(String key : keys){
            objects.get(key).render(batch);
        }

    }

    @Override
    public void tick() {

        for(String key : keys_reversed){
            objects.get(key).tick();
            if(objects.get(key).isHold()) {
                toFront(key);
                break;
            }

        }

    }

    @Override
    public void dispose() {

        for(MovableObject obj : objects.values()){
            obj.dispose();
        }

    }
}
