package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BalloonController {

    boolean isAlive;
    Texture texture;
    float x,y;

    public void init () {
        isAlive = true;
        texture = new Texture("balloon.png");
    }
}
