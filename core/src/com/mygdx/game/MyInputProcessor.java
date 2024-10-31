package com.mygdx.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor extends InputAdapter {
    Arrow arrow;

    public MyInputProcessor(Arrow arrow) {
        this.arrow = arrow;
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        arrow.setMoving(true);
        return false;
    }
}
