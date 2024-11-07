package com.mygdx.game.arrow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.GameAssetManager;
import com.mygdx.game.Utils;

public class Arrow implements Pool.Poolable {
    Utils utils = new Utils();
    public final Vector2 position = new Vector2();
    public boolean isAlive = true;
    public boolean isMoving = false;
    private Texture texture;
    public int speed;
    private float positionOffset;

    public void init(Vector2 playerPosition) {
        this.texture = GameAssetManager.getInstance().get(GameAssetManager.arrowTexture);
        this.isAlive = true;
        this.isMoving = false;
        this.speed = 160;
        this.positionOffset = 25f;
        this.position.set(playerPosition.x + this.positionOffset,  playerPosition.y);
    }

    public void update (float deltaTime, Vector2 playerPosition) {
        if (utils.isOutOfScreenRight(this.position.x)) {
            isAlive = false;
        } else if (isMoving) {
            this.position.add(deltaTime * this.speed, 0);
        } else {
            this.position.set(playerPosition.x + this.positionOffset, playerPosition.y);
        }
    }

    public void render (SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void fire() {
        this.isMoving = true;
    }



    @Override
    public void reset() {
        this.position.set(0,0);
        isMoving = false;
        isAlive = false;
    }
}
