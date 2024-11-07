package com.mygdx.game.arrow;

import com.badlogic.gdx.utils.Pool;

public class ArrowPool extends Pool<Arrow> {

    public ArrowPool(){
        super();
    }

    @Override
    protected Arrow newObject() {
        return new Arrow();
    }
}
