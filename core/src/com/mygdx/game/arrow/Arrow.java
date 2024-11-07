package com.mygdx.game.arrow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Utils;

public class Arrow implements Pool.Poolable {
    Utils utils = new Utils();
    public final Vector2 position = new Vector2();
    public boolean isAlive = true;
    public boolean isMoving = false;
    private Texture arrowTexture;

    public void init(Vector2 playerPosition) {
        arrowTexture = new Texture(Gdx.files.internal("arrow.png"));
        position.set(playerPosition.x,  playerPosition.y);
        isAlive = true;
    }

    public void update (float deltaTime, Vector2 playerPosition) {
        if ( utils.isOutOfScreen(this.position)) {
            isAlive = false;
        } else if (isMoving) {
            this.position.add(1*deltaTime*60, 0);
        } else {
            this.position.set(playerPosition.x, playerPosition.y);
        }
    }

    public void render (SpriteBatch batch) {
        batch.draw(arrowTexture, position.x, position.y);
    }

    public void fire() {
        this.isMoving = true;
    }

    @Override
    public void reset() {
        this.position.set(0,0);
        isAlive = false;
    }
}
