package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameAssetManager;
import com.mygdx.game.Utils;

public class Player {
    Utils utils = new Utils();
    private final Texture texture;
    public final Vector2 position;
    public boolean isMovingUp;
    public boolean isMovingDown;
    public int speed;

    public Player () {
        this.texture = GameAssetManager.getInstance().get(GameAssetManager.playerTexture);
        this.position = new Vector2(10,10);
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.speed = 120;
    }

    public void update (float deltaTime) {
        float playerTopPosition = this.position.y + this.texture.getHeight();
        if (this.isMovingUp && !this.utils.isOutOfScreenTop(playerTopPosition)) {
            this.position.y += deltaTime * this.speed;
        } else if (this.isMovingDown && !this.utils.isOutOfScreenBottom(this.position.y)) {
            this.position.y -= deltaTime * this.speed;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
}
