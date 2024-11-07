package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter {
    private final GameManager gameManager;

    public GameInputProcessor(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        gameManager.shootArrow();
        return true;
    }

    public boolean keyDown(int i) {
        if (i == Input.Keys.UP || i == Input.Keys.W) {
            gameManager.player.isMovingUp = true;
        } else if (i == Input.Keys.DOWN || i == Input.Keys.S) {
            gameManager.player.isMovingDown = true;
        }
        return true;
    }

    public boolean keyUp(int i) {
        if (i == Input.Keys.UP || i == Input.Keys.W) {
            gameManager.player.isMovingUp = false;
        } else if (i == Input.Keys.DOWN || i == Input.Keys.S) {
            gameManager.player.isMovingDown = false;
        }
        return true;
    }
}





