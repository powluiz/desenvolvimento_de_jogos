package com.mygdx.game;

import com.badlogic.gdx.utils.Pool;

public class ArrowPool extends Pool<Arrow> {

    public ArrowPool(int init, int max) {
        super(init, max);
    }

    public ArrowPool(){
        super();
    }

    @Override
    protected Arrow newObject() {
        return new Arrow();
    }
}
