package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Arrow implements Pool.Poolable {
    Utils utils = new Utils();
    private final Vector2 position = new Vector2();
    boolean isAlive = false;
    boolean isMoving = false;
    private Texture arrowTexture;

    public void init(float posX, float posY) {
        arrowTexture = new Texture(Gdx.files.internal("arrow.png"));
        position.set(posX,  posY);
        isAlive = false;
    }

    public void update (float delta, SpriteBatch batch) {
        if ( utils.isOutOfScreen(position)) {
            isAlive = false;
        } else if (isMoving) {
            position.add(1*delta*60, 0);
        }

        // render updates
        batch.draw(arrowTexture, position.x, position.y);
    }

    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    @Override
    public void reset() {
        position.set(0,0);
        isAlive = false;
    }
}
