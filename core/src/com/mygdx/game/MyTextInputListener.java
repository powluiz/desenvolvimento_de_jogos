package com.mygdx.game;

import com.badlogic.gdx.Input;

public class MyTextInputListener implements Input.TextInputListener {
    @Override
    public void input(String text) {
        System.out.println(text);
    }

    @Override
    public void canceled() {

    }
}
