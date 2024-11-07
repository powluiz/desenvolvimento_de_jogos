package com.mygdx.game.balloon;

import com.badlogic.gdx.utils.Pool;

public class BalloonPool extends Pool<Balloon> {

    public BalloonPool(){
        super();
    }

    @Override
    protected Balloon newObject() {
        return new Balloon();
    }
}
