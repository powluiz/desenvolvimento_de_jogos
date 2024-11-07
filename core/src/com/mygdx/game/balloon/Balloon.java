package com.mygdx.game.balloon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Utils;

public class Balloon implements Pool.Poolable {

    Utils utils = new Utils();
    public final Vector2 position = new Vector2();
    public boolean isAlive = true;
    public boolean isHit = false;
    private Texture balloonTexture;

    public void init(Vector2 initialPosition) {
        balloonTexture = new Texture(Gdx.files.internal("balloon.png"));
        position.set(initialPosition.x,  initialPosition.y);
        isAlive = true;
    }

    public void update (float delta) {
        if (this.isHit || utils.isOutOfScreenTop(position.y)) {
            isAlive = false;
        } else {
            this.position.add(0, 1*delta*60);
        }
    }

    public void render (SpriteBatch batch) {
        batch.draw(balloonTexture, position.x, position.y);
    }

    @Override
    public void reset() {
        this.position.set(0,0);
        isAlive = false;
    }
}
