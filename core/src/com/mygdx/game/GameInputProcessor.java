package com.mygdx.game;

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
        // movimentacao vertical do personagem
        return false;
    }
}
