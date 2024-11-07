package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Utils {
    public boolean isOutOfScreen(Vector2 position) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        return position.x < 0 || position.x > screenWidth || position.y < 0 || position.y > screenHeight;
    }

    public boolean isOutOfScreenTop(float positionY) {
        float screenHeight = Gdx.graphics.getHeight();
        return positionY > screenHeight;
    }

    public boolean isOutOfScreenBottom(float positionY) {
        return positionY < 0;
    }

    public boolean isOutOfScreenLeft(float positionX) {
        return positionX < 0;
    }

    public boolean isOutOfScreenRight(float positionX) {
        float screenWidth = Gdx.graphics.getWidth();
        return positionX > screenWidth;
    }
}
