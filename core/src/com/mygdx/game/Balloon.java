package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Balloon {

    boolean isAlive;
    Texture texture;
    float x,y;

    public void init () {
        isAlive = true;
        texture = new Texture("balloon.png");
    }
}
